package com.example.demo.athlete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AthleteRepository
        extends JpaRepository<Athlete,Long> {
    // Select * From athlete where email = ?
    @Query("SELECT a FROM Athlete a WHERE a.email = ?1")
    Optional<Athlete> findAthleteByEmail(String email);
}
