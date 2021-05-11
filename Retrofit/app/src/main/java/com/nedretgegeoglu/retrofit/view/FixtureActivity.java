package com.nedretgegeoglu.retrofit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nedretgegeoglu.retrofit.R;
import com.nedretgegeoglu.retrofit.adapter.fixture.SlideViewPagerAdapter;
import com.nedretgegeoglu.retrofit.model.fixtures.FixtureModel;
import com.nedretgegeoglu.retrofit.model.fixtures.ResponseModel;
import com.nedretgegeoglu.retrofit.service.FixturesApi;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FixtureActivity extends AppCompatActivity {
    public static ViewPager viewPager;
    SlideViewPagerAdapter slideViewPagerAdapter;
    String baseUrl="https://v3.football.api-sports.io/";
    Retrofit retrofit;
    RecyclerView fixtureRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture);
        setTitle("Fixtures");

        viewPager=findViewById(R.id.viewPager);

        Gson gson= new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        loadData();
    }

    private void loadData(){
        FixturesApi fixturesApi = retrofit.create(FixturesApi.class);
        Call<FixtureModel> call= fixturesApi.getData();
        call.enqueue(new Callback<FixtureModel>() {
            @Override
            public void onResponse(Call<FixtureModel> call, Response<FixtureModel> response) {
                if(response.isSuccessful()){
                    FixtureModel responseObject=  response.body();
                    List<ResponseModel> matchList =responseObject.getResponse();

                    fixtureRecyclerView = findViewById(R.id.fixture_recycler_view);
                    slideViewPagerAdapter=new SlideViewPagerAdapter(FixtureActivity.this, matchList, fixtureRecyclerView);
                    viewPager.setAdapter(slideViewPagerAdapter);

                    /**for(ResponseModel responseModel: matchList){
                        System.out.println(responseModel.getTeams().getHome().getName());
                    }*/
                }
            }

            @Override
            public void onFailure(Call<FixtureModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}