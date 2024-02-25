package com.example.demo.athlete;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    @Autowired
    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public List<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }
    public void addNewAthlete(Athlete athlete) {
        Optional<Athlete> athleteByEmail = athleteRepository.findAthleteByEmail(athlete.getEmail());
        if (athleteByEmail.isPresent()) {
            throw new IllegalStateException("This email is already taken");
        }
        athleteRepository.save(athlete);
    }
    public void deleteAthlete(Long athleteId) {
        boolean exists = athleteRepository.existsById(athleteId);
        if(!exists) {
            throw new IllegalStateException("athlete with id"+athleteId+" does not exist");
        }
        athleteRepository.deleteById(athleteId);
    }
    @Transactional
    public void updateAthlete(Long athleteId,String name, String email) {
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() ->
                new IllegalStateException("student with that id doesn't exist"));
        if (name != null && name.length() > 0 && !Objects.equals(athlete.getName(),name)) {
            athlete.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(athlete.getEmail(),email)) {
            Optional<Athlete> athleteOptional = athleteRepository.findAthleteByEmail(email);
            if(athleteOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            athlete.setEmail(email);
        }
    }
}
