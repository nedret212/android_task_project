package com.nedretgegeoglu.retrofit.adapter.fixture;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nedretgegeoglu.retrofit.R;
import com.nedretgegeoglu.retrofit.model.fixtures.ResponseModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FixtureRecyclerViewAdapter extends RecyclerView.Adapter<FixtureRecyclerViewAdapter.FixtureRowHolder> {
    private List<ResponseModel> matchList;

    public FixtureRecyclerViewAdapter(List<ResponseModel> matchList) {
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public FixtureRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.fixtures_screen, parent, false);
        return new FixtureRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FixtureRecyclerViewAdapter.FixtureRowHolder holder, int position) {
        holder.bind(matchList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public class FixtureRowHolder extends RecyclerView.ViewHolder {
        TextView homeTeamName;
        TextView awayTeamName;
        TextView score;
        ImageView homeTeamLogo;
        ImageView awayTeamLogo;

        public FixtureRowHolder(@NonNull View itemView) { super(itemView); }
        public void bind(ResponseModel responseModel, int position) {
            homeTeamName= itemView.findViewById(R.id.homeTeamName);
            awayTeamName= itemView.findViewById(R.id.awayTeamName);
            score= itemView.findViewById(R.id.score);
            homeTeamLogo = itemView.findViewById(R.id.homeTeamLogo);
            awayTeamLogo = itemView.findViewById(R.id.awayTeamLogo);

            Picasso.get().load(responseModel.getTeams().getHome().getLogo()).into(homeTeamLogo);
            Picasso.get().load(responseModel.getTeams().getAway().getLogo()).into(awayTeamLogo);

            homeTeamName.setText(responseModel.getTeams().getHome().getName());
            awayTeamName.setText(responseModel.getTeams().getAway().getName());
            score.setText(String.valueOf(responseModel.getGoals().getHome())+" - "+ String.valueOf(responseModel.getGoals().getAway()));

            if(responseModel.getTeams().getHome().isWinner()==true) homeTeamName.setTypeface(null, Typeface.BOLD);
            if(responseModel.getTeams().getAway().isWinner()==true) awayTeamName.setTypeface(null, Typeface.BOLD);

        }
    }

}
