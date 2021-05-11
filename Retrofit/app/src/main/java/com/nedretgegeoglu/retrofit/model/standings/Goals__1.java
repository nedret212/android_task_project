
package com.nedretgegeoglu.retrofit.model.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Goals__1 {

    @SerializedName("for")
    @Expose
    private int _for;
    @SerializedName("against")
    @Expose
    private int against;

    public int getFor() {
        return _for;
    }

    public void setFor(int _for) {
        this._for = _for;
    }

    public int getAgainst() {
        return against;
    }

    public void setAgainst(int against) {
        this.against = against;
    }

}
