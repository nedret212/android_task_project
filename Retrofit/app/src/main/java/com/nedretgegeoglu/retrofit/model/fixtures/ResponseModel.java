package com.nedretgegeoglu.retrofit.model.fixtures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseModel {

    @SerializedName("fixture")
    @Expose
    private Fixture fixture;
    @SerializedName("league")
    @Expose
    private League league;
    @SerializedName("teams")
    @Expose
    private Teams teams;
    @SerializedName("goals")
    @Expose
    private Goals goals;

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

}
