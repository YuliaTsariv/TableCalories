package com.example.ProjectTestMySql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjectTestMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectTestMySqlApplication.class, args);
    }
}
