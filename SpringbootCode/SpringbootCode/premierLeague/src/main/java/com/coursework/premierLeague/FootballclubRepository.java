package com.coursework.premierLeague;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FootballclubRepository {

    private String clubFileName = "C:\\Users\\MAC\\Desktop\\Afridh-project\\JavaCode";
    private String matchFileName = "C:\\Users\\MAC\\Desktop\\Afridh-project\\JavaCode";


    private ArrayList<FootballClub> clubs = new ArrayList<>();
    private ArrayList<Match> playedMatches = new ArrayList<>();


    public FootballclubRepository(){
        try {

            this.readFromFile(clubFileName,clubs);
           this.readMatchFromFile(matchFileName,playedMatches);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList readFromFile(String filename, ArrayList arrayList) throws IOException {

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream input = new ObjectInputStream(fis);
        while(true) {
            try{
                Object obj = input.readObject();
                SportsClub sc = (SportsClub) obj;
                FootballClub fb = (FootballClub)sc;
                arrayList.add(fb);
            }catch (Exception e){
                break; // to avoid End of File Exception
            }
        }
        System.out.println("Successfully read from file");
        input.close();
        fis.close();

        return arrayList;


    }

    public ArrayList readMatchFromFile(String filename, ArrayList arrayList) throws IOException {

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream input = new ObjectInputStream(fis);
        while(true) {
            try{
                Object obj = input.readObject();
                Match match = (Match) obj;
                arrayList.add(match);
            }catch (Exception e){
                break; // to avoid End of File Exception
            }
        }
        System.out.println("Successfully read from file");
        input.close();
        fis.close();

        return arrayList;


    }

    public void writeToFile(String filename, ArrayList arrayList){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for(Object o : arrayList) {
                objectOut.writeObject(o);
            }
            objectOut.close();
            fileOut.close();
            System.out.println("Changes are saved ");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<UniversityFootballClub> getUniversityClubs(){
        ArrayList<UniversityFootballClub> uniClubs = new ArrayList<>();

        for (FootballClub footballClub : clubs){
            if(footballClub instanceof UniversityFootballClub){
                uniClubs.add((UniversityFootballClub) footballClub);
            }
        }
        return uniClubs;
    }

    public List<SchoolFootballClub> getSchoolClubs(){
        ArrayList<SchoolFootballClub> schoolClubs = new ArrayList<>();

        for (FootballClub footballClub : clubs){
            if(footballClub instanceof SchoolFootballClub){
                schoolClubs.add((SchoolFootballClub) footballClub);
            }
        }
        return schoolClubs;
    }



    public List<UniversityFootballClub> sortUniversity(String sortBy){
        List<UniversityFootballClub> allClubs = getUniversityClubs();

        if(sortBy.equals("goals")) {
            allClubs.sort(new ComparableByGoals());
        }else if(sortBy.equals("wins")) {
            allClubs.sort(new ComparableByWins());
        }
        return allClubs;
    }

    public List<SchoolFootballClub> sortSchool(String sortBy){
        List<SchoolFootballClub> allClubs = getSchoolClubs();

        if(sortBy.equals("goals")) {
            allClubs.sort(new ComparableByGoals());
        }else if(sortBy.equals("wins")) {
            allClubs.sort(new ComparableByWins());
        }
        return allClubs;
    }

    public ArrayList<Match> getPlayedMatches() {
        return playedMatches;
    }


    public List<Match> getMatchByDate(String date){



        List<Match> allmatches = playedMatches;

        if (date.equals("null"))
            return allmatches;

        ArrayList filtered = new ArrayList();


        for (Match match : allmatches){

            if (match.getDate().equals(date)){

                filtered.add(match);
            }
        }

        return filtered;

    }

    public Match random(){
        List allclubs = clubs;
        int size = allclubs.size();

        Random rand = new Random();

        int num1 = rand.nextInt(size);

        FootballClub TeamA = (FootballClub) allclubs.get(num1);

        int num2 = rand.nextInt(size);

        while (num2 == num1){
            num2 = rand.nextInt(size);
        }

        FootballClub TeamB =(FootballClub) allclubs.get(num2);

        int scoreA = rand.nextInt(100);
        int scoreB = rand.nextInt(100);

        String randDate = "00-00-0000" ;
        try {
            randDate= RandomDateGen.createRandomDate(2000,2020);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Match playedMatch = addMatch(randDate, TeamA, scoreA, TeamB, scoreB);

        playedMatches.add(playedMatch);



        writeToFile(matchFileName,playedMatches);
        writeToFile(clubFileName,clubs);


        return playedMatch;


    }

    public Match addMatch(String date, FootballClub club1, int score1, FootballClub club2, int score2) {

        int clubA = clubs.indexOf(club1);
        int clubB = clubs.indexOf(club2);

        if(score1==score2){
            clubs.get(clubA).setDraws(club1.getDraws()+1);
            clubs.get(clubB).setDraws(club2.getDraws()+1);

        }else if (score1>score2){
            clubs.get(clubA).setWins(club1.getWins()+1);
            clubs.get(clubB).setDefeats(club2.getDefeats()+1);
        }else{
            clubs.get(clubB).setWins(club2.getWins()+1);
            clubs.get(clubA).setDefeats(club1.getDefeats()+1);
        }
        clubs.get(clubA).setPoints(club1.getPoints()+score1);
        clubs.get(clubB).setPoints(club2.getPoints()+score2);
        clubs.get(clubA).setMatchesPlayed(club1.getMatchesPlayed()+1);
        clubs.get(clubB).setMatchesPlayed(club2.getMatchesPlayed()+1);

        Match playedMatch = new Match(date, club1,club2,score1,score2);


        return playedMatch;






    }

}
