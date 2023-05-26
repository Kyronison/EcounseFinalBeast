package com.kyronison.ecounse.data;

import java.util.List;

public class DataDto {

    private List<String> figi;

    private List<String> instrumentId;

    public List<String> getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(List<String> instrumentId) {
        this.instrumentId = instrumentId;
    }

    public List<String> getFigi() {
        return figi;
    }

    public void setFigi(List<String> figi) {
        this.figi = figi;
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "figi=" + figi +
                '}';
    }
}
