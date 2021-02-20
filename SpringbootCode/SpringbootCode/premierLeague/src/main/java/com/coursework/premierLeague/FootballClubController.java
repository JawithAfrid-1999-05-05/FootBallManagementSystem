package com.coursework.premierLeague;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
@RequestMapping
public class FootballClubController {


    private FootballclubRepository footballclubRepository = new FootballclubRepository();

    @GetMapping("/football/university")
    public List<UniversityFootballClub> getAllUniversityclubs() {
        return footballclubRepository.getUniversityClubs();
    }

    @GetMapping("/football/school")
    public List<SchoolFootballClub> getAllSchoolclubs() {
        return footballclubRepository.getSchoolClubs();
    }


    @GetMapping(value = "/football/university/{sortby}")
    public List<UniversityFootballClub> sortUniClubs(@PathVariable String sortby) {
        return footballclubRepository.sortUniversity(sortby);
    }

    @GetMapping(value = "/football/school/{sortby}")
    public List<SchoolFootballClub> sortSchoolClub (@PathVariable String sortby) {
        return footballclubRepository.sortSchool(sortby);
    }




    @GetMapping("/match/all")
    public List<Match> getAll() {
        return footballclubRepository.getPlayedMatches();
    }

    @GetMapping("/match/random")
    public Match generateRandom() {
        return footballclubRepository.random();
    }

    @GetMapping("/match/{date}")
    public List<Match> getByDate(@PathVariable String date) {
        return footballclubRepository.getMatchByDate(date);
    }




}
