package com.itmo.ctdev;

import com.itmo.ctdev.parsing.WorkoutDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final WorkoutDataParser workoutDataParser;

    @Autowired
    public Application(WorkoutDataParser workoutDataParser) {
        this.workoutDataParser = workoutDataParser;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        workoutDataParser.parseWorkoutFile();
    }
}