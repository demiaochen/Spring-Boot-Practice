package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    // A bean is an instance of a class managed by Spring container

    // Spring container: the IoC container
    //  Part of the core of the Spring Framework
    //  Responsible for managing all the beans
    //  Performs dependency inejction

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student derek = new Student(
                    "Derek",
                    "me@demiao.com",
                    LocalDate.of(2000, Month.APRIL, 15)
            );
            Student derekie = new Student(
                    "Derekie",
                    "i@demiao.com",
                    LocalDate.of(2010, Month.MARCH, 15)
            );

            repository.saveAll(
                    List.of(derek, derekie)
            );
        };
    }
}
