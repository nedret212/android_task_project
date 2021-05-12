package com.nedretgegeoglu.retrofit.service;

import com.nedretgegeoglu.retrofit.model.fixtures.FixtureModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface FixturesApi {

    @Headers({
            "x-rapidapi-key: 12c6bdab2cce16ad261220703ea9e6c0",
            "x-rapidapi-host: v3.football.api-sports.io"
    })
    @GET("fixtures?season=2019&league=39")
    Call<FixtureModel> getData();
}
