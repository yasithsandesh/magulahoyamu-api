package com.yasithsandesh.magulahoyamuapi;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class MagulahoyamuApiApplication {

    public static void main(String[] args) {

        // Only load .env if exists
        File envFile = new File(".env");
        if(envFile.exists()) {
            Dotenv dotenv = Dotenv.load();
            dotenv.entries().forEach(e ->
                    System.setProperty(e.getKey(), e.getValue())
            );
        }
        SpringApplication.run(MagulahoyamuApiApplication.class, args);


    }

}
