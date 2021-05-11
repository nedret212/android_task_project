package com.nedretgegeoglu.retrofit.adapter.fixture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.nedretgegeoglu.retrofit.R;
import com.nedretgegeoglu.retrofit.helpers.date_time.DateTimeHelper;
import com.nedretgegeoglu.retrofit.model.fixtures.ResponseModel;
import java.util.ArrayList;
import java.util.List;

public class SlideViewPagerAdapter extends PagerAdapter {
    public List<ResponseModel> matchList;
    Context ctx;
    RecyclerView fixtureRecyclerView;
    FixtureRecyclerViewAdapter adapter;

    public SlideViewPagerAdapter(Context ctx, List<ResponseModel> matchList, RecyclerView fixtureRecyclerView) {
        this.ctx = ctx;
        this.matchList= matchList;
        this.fixtureRecyclerView=fixtureRecyclerView;
    }

    @Override
    public int getCount() {
        return matchList.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.fixture_slide_screen, container,false);

        List<ResponseModel> weeklyFixture= getList(position, matchList);
        fixtureRecyclerView = view.findViewById(R.id.fixture_recycler_view);
        fixtureRecyclerView.setLayoutManager(new LinearLayoutManager(ctx));
        adapter = new FixtureRecyclerViewAdapter(weeklyFixture);
        fixtureRecyclerView.setAdapter(adapter);

        TextView weekDate=view.findViewById(R.id.weekDate);
        weekDate.setText(getWeekDate(weeklyFixture));
        TextView weekName=view.findViewById(R.id.weekName);
        weekName.setText(getWeekName(position));

        container.addView(view);
        return view;
    }

    List<ResponseModel> getList(int position, List<ResponseModel> holeFixture){
        List<ResponseModel> weeklyFixture = new ArrayList<>();
        for(int i=0;i<10;i++){
            weeklyFixture.add(i, holeFixture.get(i+(position*10)));
        }
        return weeklyFixture;
    }
    public String getWeekName(int position){
        String weekName="";
        if(position==0)weekName="1st Week";
        else if(position==1) weekName="2nd Week";
        else if(position==2) weekName="3rd Week";
        else weekName= (position+1)+"th Week";

        return weekName;
    }
    public String getWeekDate(List<ResponseModel> weeklyFixture){
        return DateTimeHelper.convertTimeStamp(weeklyFixture.get(0).getFixture().getTimestamp());
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
