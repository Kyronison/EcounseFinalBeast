package com.kyronison.ecounse.domain;

import com.kyronison.ecounse.data.LastPrices;

import java.util.List;

public interface LastPricesCallback {
    void updatePrices(List<LastPrices> price);
}
