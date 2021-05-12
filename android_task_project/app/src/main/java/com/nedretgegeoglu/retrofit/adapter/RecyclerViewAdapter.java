package com.nedretgegeoglu.retrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nedretgegeoglu.retrofit.R;
import com.nedretgegeoglu.retrofit.model.standings.Standing;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {

    private ArrayList<Standing> standingsList;

    public RecyclerViewAdapter(ArrayList<Standing> standingsList) {
        this.standingsList = standingsList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.row_layout, parent, false);

        return  new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(standingsList.get(position));
    }

    @Override
    public int getItemCount() {
        return standingsList.size();

    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView index;
        TextView teamName;
        TextView match;
        TextView win;
        TextView draw;
        TextView lose;
        TextView points;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(Standing standingsModel){
            index= itemView.findViewById(R.id.index);
            teamName=itemView.findViewById(R.id.team_name);
            match=itemView.findViewById(R.id.match);
            win=itemView.findViewById(R.id.win);
            draw=itemView.findViewById(R.id.draw);
            lose=itemView.findViewById(R.id.lose);
            points=itemView.findViewById(R.id.points);

            index.setText(standingsModel.getRank()+".");
            teamName.setText(standingsModel.team.getName());
            match.setText("38");
            win.setText(String.valueOf(standingsModel.all.getWin()));
            draw.setText(String.valueOf(standingsModel.all.getDraw()));
            lose.setText(String.valueOf(standingsModel.all.getLose()));
            points.setText(String.valueOf(standingsModel.getPoints()));
        }
    }
}
