package com.coursework.premierLeague;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {
    public static ArrayList<FootballClub> clubs = new ArrayList<>();
    public static ArrayList<Match> playedMatches = new ArrayList<>();



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



    public void readFromFile(String filename, ArrayList arrayList) throws IOException {

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

    }


    /**
     * Delete an existing football club
     * @param club name of the club
     * @return returns true if the club has been deleted, false if the club is not found
     */
    @Override
    public void deleteClub(FootballClub club) {
        clubs.remove(club);

    }

    /**
     * Display statistics of a given club
     * @param club name of the club
     * @return true if club exists, false if club not found
     */
    @Override
    public void displayStatistics(FootballClub club) {
        club.displayStatistics();

    }


    /**
     * Displays all clubs statistics in descending order (by points)
     */
    @Override
    public void displayPremierLeagueTable() {
        Collections.sort(clubs);
        System.out.format("%10s%10s%15s%10s%10s%10s%13s%14s\n", "name","points","goalsRecieved","wins","draws","defeats","goalsScored","matchesPlayed");
        for (FootballClub footballClub : clubs){
            footballClub.displayRecord();
            System.out.println();
        }


    }

    /**
     * Add a new Match records
     * @param club1 club 1 name (If its not a draw, winner detail is taken as club 1 )
     * @param score1 score of club 1
     * @param club2 club 2 name (If its not a draw, defeated club detail is taken as club 2)
     * @param score2 score of club 2
     */
    @Override
    public void addMatch(String date,FootballClub club1, int score1, int goals1, FootballClub club2, int score2, int goals2) {



        int indexOfClub1 = clubs.indexOf(club1);
        int indexOfClub2 = clubs.indexOf(club2);


        if(score1==score2){
            clubs.get(indexOfClub1).setDraws(club1.getDraws()+1);
            clubs.get(indexOfClub2).setDraws(club2.getDraws()+1);

        }else if(score1>score2){
            clubs.get(indexOfClub1).setWins(club1.getWins()+1);
            clubs.get(indexOfClub2).setDefeats(club2.getDefeats()+1);
        }else{
            clubs.get(indexOfClub2).setWins(club2.getWins()+1);
            clubs.get(indexOfClub1).setDefeats(club1.getDefeats()+1);
        }
        clubs.get(indexOfClub1).setPoints(club1.getPoints()+score1);
        clubs.get(indexOfClub2).setPoints(club2.getPoints()+score2);
        clubs.get(indexOfClub1).setGoalsScored(club1.getGoalsScored()+goals1);
        clubs.get(indexOfClub2).setGoalsScored(club2.getGoalsScored()+goals2);
        clubs.get(indexOfClub1).setGoalsReceved(club1.getGoalsReceived()+goals2);
        clubs.get(indexOfClub2).setGoalsReceved(club2.getGoalsReceived()+goals1);
        clubs.get(indexOfClub1).setMatchesPlayed(club1.getMatchesPlayed()+1);
        clubs.get(indexOfClub2).setMatchesPlayed(club2.getMatchesPlayed()+1);

        Match playedMatch = new Match(date, club1,club2,score1,score2);
        playedMatches.add(playedMatch);



    }

    /**
     * To check if a club exists in the records
     * @param clubName name of the club
     * @param clubName array which contaisn all clubs
     * @return returns the club object if exists, else it will return NULL
     */
    public FootballClub exists(String clubName){
        for (FootballClub footballClub : clubs){
            if (footballClub.getName().equals(clubName)){
                return footballClub;
            }
        }
        return null;

    }


    @Override
    public boolean run() {
        boolean exit = false;
        System.out.println("\n\n< < < < Premier Laaguue Manager > > > >\n");
        System.out.println("1 --- add new Football club");
        System.out.println("2 --- delete a Football club");
        System.out.println("3 --- display statistics of a Football club");
        System.out.println("4 --- display Premier League Table");
        System.out.println("5 --- add a new played Match");
        System.out.println("6 --- save in a file");
        System.out.println("7 --- exit");

        Scanner sc = new Scanner(System.in);
        String choice = sc.next();

        switch (choice) {
            case "1": // Add new Football club
                System.out.println("enter 1 -> add a University football club");
                System.out.println("enter 2 -> add a School football club");
                int choice2 = sc.nextInt();

                System.out.println(" club name : ");
                String clubName = sc.next();
                while (exists(clubName)!=null) { // checks for duplicates
                    System.out.print("This club name already exists!\n Enter a different club name : ");
                    clubName = sc.next();
                }

                System.out.format(" location : ");
                String location = sc.next();


                switch (choice2) {
                    case 1:
                        //University football club is chosen
                        UniversityFootballClub universityClub = new UniversityFootballClub(clubName, location,0,0,0,0,0,0,0);
                        clubs.add(universityClub);
                        break;

                    case 2:
                        //School football club is chosen
                        System.out.format(" division : ");
                        String division = sc.next();

                        SchoolFootballClub schoolClub = new SchoolFootballClub(clubName, location, 0,0,0,0,0,0,0,division);
                        clubs.add(schoolClub);
                        break;
                }
                System.out.println("Club added successfully");
                break;

            case "2": // delete a club
                System.out.println("Enter club name you want to delete");
                String name = sc.next();
                FootballClub club = exists(name);
                if (club==null) { // checks for duplicates
                    System.out.print("This club does not exist!");
                }else {
                    deleteClub(club);
                }
                break;

            case "3": // Display statistics of a club
                System.out.println("Enter club name ");
                String clubname = sc.next();
                FootballClub footballClub = exists(clubname);
                if (footballClub==null) { // checks if exists
                    System.out.print("This club does not exist!");
                }else {
                    displayStatistics(footballClub);
                }
                break;
            case "4": // Display statistics of all clubs
                displayPremierLeagueTable();
                break;
            case "5": // Add new Match
                System.out.println("Enter date ( mm-dd-yyyy): ");
                String dateFormat = sc.next();
                Date date;
                try {
                    date = new SimpleDateFormat("MM-dd-yyyy").parse(dateFormat);
                } catch (ParseException ex) {
                    System.out.println("Invalid Date");
                    break;
                }

                System.out.println("Enter club name (1/2) :");
                String c1 = sc.next();
                FootballClub club_1 = exists(c1);

                while (club_1==null) {
                    System.out.println("Club does not exists, please retype");
                    c1 = sc.next();
                    club_1 = exists(c1);
                }

                System.out.println("Enter score (1/2) : ");
                int score_1 = sc.nextInt();
                System.out.println("Enter goals scored (1/2) : ");
                int goals_1 = sc.nextInt();

                System.out.println("Enter club name (2/2) :");
                String c2 = sc.next();
                FootballClub club_2 = exists(c2);

                while (club_2==null) {
                    System.out.println("Club does not exists, please retype");
                    c2 = sc.next();
                    club_2 = exists(c2);

                }

                System.out.println("Enter score (1/2) : ");
                int score_2 = sc.nextInt();
                System.out.println("Enter goals scored (1/2) : ");
                int goals_2 = sc.nextInt();

                addMatch(dateFormat,club_1,score_1,goals_1,club_2,score_2,goals_2);

                break;
            case "6": // Saves to file
                writeToFile("clubs.txt",clubs);
                writeToFile("playedMatches.txt",playedMatches);

                break;

            case "7": //exit
                exit = true;
                break;
            default: // when user gives wrong input
                System.out.println("Invalid Decision");
                break;
        }
        return exit; // True - loop ends in the While loop of the main method,
        // False - loop runs again & asks for input..
    }

    public static void main(String[] args) {
        PremierLeagueManager pml = new PremierLeagueManager();

        try {
            pml.readFromFile("clubs.txt",clubs);
            pml.readFromFile("playedMatches.txt",playedMatches);

        } catch (IOException e) {
            System.out.println("Cannot find file");

        }
        boolean exit = false;
        while (!exit){
            exit = pml.run();

        }
    }
}
