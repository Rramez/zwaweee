package com.example.theSpringIsComing.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandlinerunner(StudentRepository repository){
        return args ->{
            student wadea = new student(
                    "Wadea",
                    LocalDate.of(2000, Month.JULY,5),
                    "wadea.minecraft@gmail.com"
            );
            student eyad = new student(
                    "Eyad",
                    LocalDate.of(1849, Month.JULY,5),
                    "eyadbfs@gmail.com"
            );
            repository.saveAll(List.of(wadea,eyad));
        };
    }
}
