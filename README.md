
# gradle-tutorial

- Ref

https://www.youtube.com/watch?v=-dtcEMLNmn0

## Learning 

```
gradle build

./gradlew build

// build.gradle.00, attributes 'Main-Class': 'com.oopsmails.simplemain.SimpleMain'
java -jar build/libs/gradle-tutorial.jar

java -jar build/libs/gradle-tutorial-1.0-SNAPSHOT.jar

```

### Tasks

```
task helloViewer {
    dependsOn check
	doFirst {
		println 'Hello, ' + nameProperty + '!'
	}
}

test.enable = false // will disable the task, > Task :test SKIPPED
```

gradle tasks // to list all tasks

### implementation gradleApi(), run java codes

```
// This will look for buildSrc folder 
dependencies {
    ......
    implementation gradleApi()
}

import com.oopsmails.gradlebasics.GreetingTask

task greetingTask(type: GreetingTask) {
	group "Albert group"
	greetingName "Albert"
}
```

### gradle java task logging

Gradle utilizes a logging framework. You can log messages to that. By default, only log level _lifecycle_ and above are shown, but you can log at other levels such as _debug_ and _info_.

To log at _debug_ level (visible with builds using `gradle --debug` or lower)

```
project.logger.debug('my debug message')
```

To log at info level (visible with gradle --info builds and lower)

```
project.logger.info('my info message')
```

To log at lifecycle level (visible by default)

```
project.logger.lifecycle('my message visible by default')
```

## Error

### Spring boot app cannot start

Because configured "spring-boot-starter-data-jpa", but no db url. If any error, the bootRun will fail.

### Spring boot app cannot start, logging

> Exception in thread "main" java.lang.IllegalArgumentException: LoggerFactory is not a Logback LoggerContext but Logback is on the classpath. Either remove Logback or the competing implementation (class org.gradle.internal.logging.slf4j.OutputEventListenerBackedLoggerContext loaded from file:/home/albert/.gradle/caches/7.3.3/generated-gradle-jars/gradle-api-7.3.3.jar). If you are using WebLogic you will need to add 'org.slf4j' to prefer-application-packages in WEB-INF/weblogic.xml: org.gradle.internal.logging.slf4j.OutputEventListenerBackedLoggerContext
at org.springframework.util.Assert.instanceCheckFailed(Assert.java:702)

- The following fix is not perfect, i.e, will cause logging not working with Spring Boot application, see below.

```
configurations {
	all*.exclude module : 'spring-boot-starter-logging'
//	all*.exclude module : 'logback-classic'
}
```

> Caused by: java.lang.IllegalArgumentException: LoggerFactory is not a Logback LoggerContext but Logback is on the classpath. Either remove Logback or the competing implementation (class org.gradle.internal.logging.slf4j.OutputEventListenerBackedLoggerContext loaded from file:/home/albert/.gradle/caches/7.3.3/generated-gradle-jars/gradle-api-7.3.3.jar). If you are using WebLogic you will need to add 'org.slf4j' to prefer-application-packages in WEB-INF/weblogic.xml: org.gradle.internal.logging.slf4j.OutputEventListenerBackedLoggerContext

- This (so far 20220715) is the proper solution! Because the root cause is 
- 
```
implementation gradleApi()
```
So, take those out and no need to `all*.exclude module : 'spring-boot-starter-logging'`

### intellij, showing GreetingTask as error

Reload All Gradle Projects, in Gradle view.

