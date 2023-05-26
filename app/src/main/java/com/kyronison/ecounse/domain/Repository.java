package com.kyronison.ecounse.domain;

import static com.kyronison.ecounse.info.BondsInfo.figiBonds;
import static com.kyronison.ecounse.info.FuturesInfo.figiFutures;
import static com.kyronison.ecounse.info.OptionsInfo.figiOptions;
import static com.kyronison.ecounse.info.SharesInfo.figiShares;
import static com.kyronison.ecounse.utils.KeyToken.keyToken;
import static com.kyronison.ecounse.utils.Utils.BASE_URL;

import android.util.Log;

import androidx.annotation.NonNull;

import com.kyronison.ecounse.data.DataDto;
import com.kyronison.ecounse.data.LastInstrumentPrices;
import com.kyronison.ecounse.data.LastPrices;
import com.kyronison.ecounse.data.PricesApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    Retrofit retrofit;

    public void fetchData(LastPricesCallback lastPricesCallback, String type){

        DataDto dto = new DataDto();

        switch (type){
            case "shares": dto.setFigi(figiShares); break;
            case "options": dto.setInstrumentId(figiOptions); break;
            case "bonds": dto.setFigi(figiBonds); break;
            case "futures": dto.setFigi(figiFutures); break;
        }
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("accept", "application/json")
                        .header("Authorization",keyToken)
                        .header("Content-Type","application/json")
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });
        OkHttpClient client = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PricesApi service = retrofit.create(PricesApi.class);

        Call<LastInstrumentPrices> call = service.getPrices(dto);
        call.enqueue(new Callback<>() {

            @Override
            public void onResponse(@NonNull Call<LastInstrumentPrices> call, @NonNull Response<LastInstrumentPrices> response) {
                if (response.isSuccessful()) {
                    LastInstrumentPrices lastInstrumentPrices = response.body();
                    Log.d("decision", lastInstrumentPrices.getLastPrices().toString());
                    List<LastPrices> lastPrices = lastInstrumentPrices.getLastPrices();
                    if (lastPrices.size() > 0){
                        lastPricesCallback.updatePrices(lastPrices);
                    }

                } else {
                    Log.d("decision", response.code() + "ds" + response.raw().body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<LastInstrumentPrices> call, @NonNull Throwable t) {
                Log.d("decision", t.toString());
            }
        });
    }
}
