package com.nedretgegeoglu.retrofit.service;

import com.nedretgegeoglu.retrofit.model.standings.StandingsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface StandingsApi {

    @Headers({
            "x-rapidapi-key: 12c6bdab2cce16ad261220703ea9e6c0",
            "x-rapidapi-host: v3.football.api-sports.io"
    })
    @GET("standings?season=2019&league=39")
    Call<StandingsModel> getData();
}
