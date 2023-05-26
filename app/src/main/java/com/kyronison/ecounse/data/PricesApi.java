package com.kyronison.ecounse.data;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface PricesApi {

    @POST("tinkoff.public.invest.api.contract.v1.MarketDataService/GetLastPrices")
    Call<LastInstrumentPrices> getPrices(@Body DataDto dataDto);
}
