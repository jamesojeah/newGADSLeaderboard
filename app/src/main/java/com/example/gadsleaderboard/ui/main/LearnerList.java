package com.example.gadsleaderboard.ui.main;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.LeaderboardData;
import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.adapters.DataAdapter;
import com.example.gadsleaderboard.model.TopLearnersData;
import com.example.gadsleaderboard.services.LeaderboardDataService;
import com.example.gadsleaderboard.services.ServiceBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.gadsleaderboard.services.ServiceBuilder.buildService;


public class LearnerList extends Fragment {


    RecyclerView recyclerView;
//    LinearLayoutManager linearLayoutManager;

    List<TopLearnersData> learnersList;
//    public List<TopLearnersData> topLearnersDatas = new ArrayList<>();
    private static Service service;

    DataAdapter dataAdapter;



    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.learner_list_fragment, container, false);

        recyclerView = root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        dataAdapter = new DataAdapter(getActivity(), learnersList);

        LeaderboardDataService taskService = ServiceBuilder.buildService(LeaderboardDataService.class);
        Call<List<TopLearnersData>> call = taskService.getTopLearnersData();

        call.enqueue(new Callback<List<TopLearnersData>>() {
            @Override
            public void onResponse(Call<List<TopLearnersData>> call, Response<List<TopLearnersData>> response) {
                learnersList = response.body();
                try {
                    dataAdapter.setLearnerNamesList(learnersList);
                }catch (NullPointerException ignored){

                }

                Log.d("Datas", "These are the data" + response.body());
            }

            @Override
            public void onFailure(Call<List<TopLearnersData>> call, Throwable t) {
                Toast.makeText(getActivity(), "Failed to retrieve data!" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(dataAdapter);
        return root;
    }





//        Service serviceAPI = ServiceBuilder.getClient();
//
//        Call<JsonArray> loadLearnerCall = serviceAPI.getLeaderboardArray();
//
//        loadLearnerCall.enqueue(new Callback<JsonArray>() {
//            @Override
//            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
//
//                try {
//
//                    String teamString = response.body().toString();
//
//                    Type listType = new TypeToken<List<TopLearnersData>>() {}.getType();
//                    topLearnersDatas = getTeamListFromJson(teamString, listType);
//
//                    recyclerView.setItemAnimator(new DefaultItemAnimator());
//                    recyclerView.setAdapter(new DataAdapter(getApplicationContext(), topLearnersDatas));

                    //sorting recipe in alphabetical order which UI test was done upon
                    // Collections.sort(recipes, Recipe.BY_NAME_ALPHABETICAL);


//                } catch (Exception e) {
//                    Log.d("onResponse", "There is an error");
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<JsonArray> call, Throwable t) {
//
//                Log.d("onFailure", t.toString());
//
//            }
//
//
//        });
//    }
//
//    public static <T> List<T> getTeamListFromJson(String jsonString, Type type) {
//        if (!isValid(jsonString)) {
//            return null;
//        }
//        return new Gson().fromJson(jsonString, type);
//    }
//
//    public static boolean isValid(String json) {
//        try {
//            new JsonParser().parse(json);
//            return true;
//        } catch (JsonSyntaxException jse) {
//            return false;
//        }
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        loadJSON();
//    }
}
