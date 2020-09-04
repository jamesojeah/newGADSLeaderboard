package com.example.gadsleaderboard;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gadsleaderboard.services.LeaderboardDataService;
import com.example.gadsleaderboard.services.ServiceBuilder;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gadsleaderboard.ui.main.SectionsPagerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeaderboardActivity extends AppCompatActivity {

    private TextView textviewLearners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_activity);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        textviewLearners = findViewById(R.id.text_learner_name);


//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(LeaderboardDataService.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

//        LeaderboardDataService leaderboardDataService  = retrofit.create(LeaderboardDataService.class);

//        Call<List<LeaderboardData>> call = leaderboardDataService.getLeaderboardData();
//
//        call.enqueue(new Callback<List<LeaderboardData>>() {
//            @Override
//            public void onResponse(Call<List<LeaderboardData>> call, Response<List<LeaderboardData>> response) {
////               List<LeaderboardData> data = response.body();
////                String[] dataNames = new String[data.size()];
////                for (int i = 0; i<data.size(); i++){
////                    dataNames[i] = data.get(i).getName();
//                if (!response.isSuccessful()){
//                    textviewLearners.setText("Code: " + response.code());
//                    return;
//
//                }
//                textviewLearners.setText(response.message());
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<LeaderboardData>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Failed to retrieve data!" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}