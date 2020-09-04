package com.example.gadsleaderboard.services;

import com.example.gadsleaderboard.LeaderboardData;
import com.example.gadsleaderboard.model.TopLearnersData;
import com.google.gson.JsonArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface LeaderboardDataService {

        @GET("api/hours")
        Call<List<TopLearnersData>> getTopLearnersData();
    }

