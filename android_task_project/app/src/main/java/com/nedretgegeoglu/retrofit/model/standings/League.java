
package com.nedretgegeoglu.retrofit.model.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class League {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("logo")
    @Expose
    public String logo;
    @SerializedName("flag")
    @Expose
    public String flag;
    @SerializedName("season")
    @Expose
    public int season;
    @SerializedName("standings")
    public List<List<Standing>> standings = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public List<List<Standing>> getStandings() {
        return standings;
    }

    public void setStandings(List<List<Standing>> standings) {
        this.standings = standings;
    }

}
