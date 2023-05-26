package com.kyronison.ecounse.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class LastInstrumentPrices {

    @SerializedName("lastPrices")
    List<LastPrices> lastPrices;

    @Override
    public String toString() {
        return "LastInstrumentPrices{" +
                "lastPrices=" + lastPrices +
                '}';
    }

    public void setLastPrices(List<LastPrices> lastPrices) {
        this.lastPrices = lastPrices;
    }
    public List<LastPrices> getLastPrices() {
        return lastPrices;
    }
}


