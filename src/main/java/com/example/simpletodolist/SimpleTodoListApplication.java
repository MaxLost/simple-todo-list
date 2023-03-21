package com.example.simpletodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackageClasses = Task.class)
@EnableJpaRepositories
public class SimpleTodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleTodoListApplication.class, args);
    }

}
