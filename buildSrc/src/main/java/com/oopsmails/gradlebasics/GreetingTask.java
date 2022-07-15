package com.oopsmails.gradlebasics;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GreetingTask extends DefaultTask {
    private String greetingName;

    public void setGreetingName(String greetingName) {
        this.greetingName = greetingName;
    }

    @Input
    public String getGreetingName() {
        return greetingName;
    }

    @TaskAction
    public void verify() {
        getLogger().lifecycle("Working Directory = " + System.getProperty("user.dir"));

        String currentDir = System.getProperty("user.dir");
        getLogger().lifecycle("Current dir using System:" + currentDir);

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        getLogger().lifecycle("Current absolute path is: " + s);

        try {
            String currentPath = new java.io.File(".").getCanonicalPath();
            getLogger().lifecycle("Current dir:" + currentPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        getLogger().quiet("Greetings dear " + greetingName);
    }
}
