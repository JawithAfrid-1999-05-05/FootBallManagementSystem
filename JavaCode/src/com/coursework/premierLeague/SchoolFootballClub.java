package com.coursework.premierLeague;

import java.io.Serializable;

public class SchoolFootballClub extends FootballClub{
    private String division; //School divisions (primary , secondary)

    public SchoolFootballClub(String name, String location, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int points, int matchesPlayed, String division) {
        super(name, location, wins, draws, defeats, goalsReceived, goalsScored, points, matchesPlayed);
        this.division = division;
    }



    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }


    @Override
    public String toString() {
        return "SchoolFootballClub{" +
                "division='" + division + '\'' +
                "} " + super.toString();
    }
}
