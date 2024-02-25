package com.example.demo.athlete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AthleteConfig {
    @Bean
    CommandLineRunner commandLineRunner(AthleteRepository repository) {
        return args -> {
            Athlete Lebron = new Athlete(
                    "Lebron James",
                    "lebronsagent@yahoo.com",
                    "Small Forward",
                    LocalDate.of(1984, Month.DECEMBER,30)
            );
            Athlete Tiger = new Athlete(
                    "Tiger Woods",
                    "tigersagent@aol.com",
                    "Golfer",
                    LocalDate.of(1975, Month.DECEMBER,30)
            );
            repository.saveAll(List.of(Lebron, Tiger));
        };


    };
}
