
package com.nedretgegeoglu.retrofit.model.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Away {

    @SerializedName("played")
    @Expose
    private int played;
    @SerializedName("win")
    @Expose
    private int win;
    @SerializedName("draw")
    @Expose
    private int draw;
    @SerializedName("lose")
    @Expose
    private int lose;
    @SerializedName("goals")
    @Expose
    private Goals__2 goals;

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public Goals__2 getGoals() {
        return goals;
    }

    public void setGoals(Goals__2 goals) {
        this.goals = goals;
    }

}
