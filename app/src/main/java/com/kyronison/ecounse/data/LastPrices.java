package com.kyronison.ecounse.data;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class LastPrices {

    @SerializedName("figi")
    String figi;

    @SerializedName("price")
    Price price;

    @SerializedName("time")
    Date time;

    @SerializedName("instrumentUid")
    String instrumentUid;

    @Override
    public String toString() {
        return "LastPrices{" +
                "figi='" + figi + '\'' +
                ", price=" + price +
                ", time=" + time +
                ", instrumentUid='" + instrumentUid + '\'' +
                '}';
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getFigi() {
        return figi;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setInstrumentUid(String instrumentUid) {
        this.instrumentUid = instrumentUid;
    }

    public String getInstrumentUid() {
        return instrumentUid;
    }

}
