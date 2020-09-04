package com.example.gadsleaderboard;

public class LeaderboardData {
    private String name;
    private String hours;
    private String country;

    public LeaderboardData(String name, String hours, String country) {
        this.name = name;
        this.hours = hours;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }


}



