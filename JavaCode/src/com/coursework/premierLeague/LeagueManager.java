package com.coursework.premierLeague;

public interface LeagueManager {
    boolean run();
    void deleteClub(FootballClub club);
    void displayStatistics(FootballClub club);
    void displayPremierLeagueTable();
    void addMatch(String date,FootballClub club1, int score1, int goals1, FootballClub club2, int score2, int goals2);

}
