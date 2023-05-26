package com.kyronison.ecounse.model;

import android.util.Log;

public class Instrument {
    private String figi;
    private String name;
    private String price;
    private String time;
    private String ticker;

    public Instrument(String figi, String name, String price, String time, String ticker) {
        this.figi = figi;
        this.name = name;
        this.price = price;
        this.time = time;
        this.ticker = ticker;
    }

    public String getTime() {
        if (time.length() < 16) {
            return "";
        }
        Log.d("CALL",time);
        return time.substring(0,4)+time.substring(11,16);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}
