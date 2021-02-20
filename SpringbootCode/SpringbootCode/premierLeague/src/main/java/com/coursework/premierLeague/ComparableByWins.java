package com.coursework.premierLeague;
import java.util.Comparator;

public class ComparableByWins implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub team1, FootballClub team2) {
        //
        if (team1.getWins() >team2.getWins()) {
            return -1;
        } else if (team1.getWins() <team2.getWins()){
            return 1;
        }else {
            //
            if (team1.getPoints() > team2.getPoints()){
                return -1;
            }else if (team1.getPoints()<team2.getPoints()){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
