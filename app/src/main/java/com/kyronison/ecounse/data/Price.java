package com.kyronison.ecounse.data;

import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("units")
    String units;

    @SerializedName("nano")
    int nano;



    public Price(String units, int nano) {
        this.units = units;
        this.nano = nano;
    }

    @Override
    public String toString() {
        String temp = nano + "";
        return units + "," + (temp).substring(0,Math.min(2,temp.length()));
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getUnits() {
        return units;
    }

    public void setNano(int nano) {
        this.nano = nano;
    }

    public int getNano() {
        return nano;
    }

}
