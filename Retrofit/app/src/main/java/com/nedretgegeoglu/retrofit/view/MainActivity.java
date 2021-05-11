package com.nedretgegeoglu.retrofit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nedretgegeoglu.retrofit.R;
import com.nedretgegeoglu.retrofit.adapter.RecyclerViewAdapter;
import com.nedretgegeoglu.retrofit.model.standings.Standing;
import com.nedretgegeoglu.retrofit.model.standings.StandingsModel;
import com.nedretgegeoglu.retrofit.service.StandingsApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<Standing> standingsModels;
    String baseUrl="https://v3.football.api-sports.io/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Standings");
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        Gson gson= new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        loadData();
    }

    private void loadData(){
        StandingsApi standingsApi = retrofit.create(StandingsApi.class);
        Call<StandingsModel> call= standingsApi.getData();
        call.enqueue(new Callback<StandingsModel>() {
            @Override
            public void onResponse(Call<StandingsModel> call, Response<StandingsModel> response) {
                if(response.isSuccessful()){
                   StandingsModel responseObject=  response.body();
                   standingsModels=new ArrayList<>(responseObject.response.get(0).getLeague().getStandings().get(0));

                   recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                   recyclerViewAdapter = new RecyclerViewAdapter(standingsModels);
                   recyclerView.setAdapter(recyclerViewAdapter);

                   /**for(Standing standing: standingsModels){
                       System.out.println(standing.team.getName());
                   }*/
                }
            }

            @Override
            public void onFailure(Call<StandingsModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public void changePage(View view){
        Intent intent = new Intent(MainActivity.this, FixtureActivity.class);
        startActivity(intent);
    }
}