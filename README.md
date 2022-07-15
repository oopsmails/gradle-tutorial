
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


