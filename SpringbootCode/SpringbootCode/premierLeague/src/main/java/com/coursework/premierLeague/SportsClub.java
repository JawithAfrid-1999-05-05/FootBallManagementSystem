package com.coursework.premierLeague;

import java.io.Serializable;

public class SportsClub implements Serializable{
    private static final long serialVersionUID = 6529685098267757690L;

    private String name; // name of the club
    private String location; // location of the club

    public SportsClub(String name, String location) {
        this.name = name;
        this.location = location;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SportsClub{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
