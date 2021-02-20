package com.coursework.premierLeague;

import java.io.Serializable;

public class Match implements Serializable{
    private String date; //mm-dd-yy
    private FootballClub club1;
    private FootballClub club2;
    private int score1;
    private int score2;

    public Match(String date, FootballClub club1, FootballClub club2, int score1, int score2) {
        this.date = date;
        this.club1 = club1;
        this.club2 = club2;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FootballClub getClub1() {
        return club1;
    }

    public void setClub1(FootballClub club1) {
        this.club1 = club1;
    }

    public FootballClub getClub2() {
        return club2;
    }

    public void setClub2(FootballClub club2) {
        this.club2 = club2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }
}
