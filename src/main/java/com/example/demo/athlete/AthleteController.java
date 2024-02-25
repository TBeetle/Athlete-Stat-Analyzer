package com.example.demo.athlete;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/athlete")
public class AthleteController {

    private final AthleteService athleteService;

    @Autowired
    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public List<Athlete> getAthlete() {
        return athleteService.getAthletes();
    }

    @PostMapping
    public void registerNewAthlete(@RequestBody Athlete athlete) {
        athleteService.addNewAthlete(athlete);
    }
    @DeleteMapping(path = "{athleteId}")
    public void deleteAthlete(@PathVariable("athleteId") Long athleteId) {
        athleteService.deleteAthlete(athleteId);
    }
   @PutMapping(path = "{athleteId}")
    public void updateAthlete(
            @PathVariable("athleteId") Long athleteId,
           @RequestParam(required = false) String name,
           @RequestParam(required = false) String email) {
        athleteService.updateAthlete(athleteId,name,email);
    }

}
