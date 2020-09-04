package com.example.gadsleaderboard.services;

import android.app.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;

public class ServiceBuilder {


    private static final String baseUrl = "https://gadsapi.herokuapp.com/";
//
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S buildService (Class<S> serviceType){
        return retrofit.create(serviceType);

    }

//    public static <S> S service(Class<S> serviceClass, String baseUrl) {
//        return new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(MoshiConverterFactory.create())
//                .build().create(serviceClass);
//    }


}
