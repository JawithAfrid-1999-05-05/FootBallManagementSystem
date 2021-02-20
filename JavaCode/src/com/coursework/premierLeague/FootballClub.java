package com.coursework.premierLeague;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Comparable<FootballClub>{



    private int wins; //number of wins
    private int draws; // number of draws
    private int defeats; // number of defeats
    private int goalsReceived; //number of goals received
    private int goalsScored; // number of goals scored
    private int points; //number of points scored
    private int matchesPlayed; // number of matches played


    public FootballClub(String name, String location, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int points, int matchesPlayed) {
        super(name, location);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.points = points;
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceved(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", goalsReceved=" + goalsReceived +
                ", goalsScored=" + goalsScored +
                ", points=" + points +
                ", matchesPlayed=" + matchesPlayed +
                "} " + super.toString();
    }

    public void displayStatistics(){
        System.out.println("wins=" + wins +
                "\ndraws=" + draws +
                "\ndefeats=" + defeats +
                "\ngoalsReceved=" + goalsReceived +
                "\ngoalsScored=" + goalsScored +
                "\npoints=" + points +
                "\nmatchesPlayed=" + matchesPlayed);

    }

    public void displayRecord(){
        System.out.format("%10s%10s%15s%10s%10s%10s%13s%14s\n", getName(),points,goalsReceived,wins,draws,defeats,goalsScored,matchesPlayed);

    }



    @Override
    public int compareTo(FootballClub o) {
        return o.points-this.points;
    }


}
