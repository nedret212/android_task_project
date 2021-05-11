package com.nedretgegeoglu.retrofit.model.fixtures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Periods {

    @SerializedName("first")
    @Expose
    private int first;
    @SerializedName("second")
    @Expose
    private int second;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

}
