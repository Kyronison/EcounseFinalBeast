package com.kyronison.ecounse.ui.futures;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kyronison.ecounse.data.LastPrices;
import com.kyronison.ecounse.domain.Interactor;
import com.kyronison.ecounse.domain.LastPricesCallback;
import com.kyronison.ecounse.domain.PricesMapper;
import com.kyronison.ecounse.domain.Repository;
import com.kyronison.ecounse.matchers.FuturesMatcher;
import com.kyronison.ecounse.model.Instrument;

import java.util.ArrayList;
import java.util.List;

public class FuturesViewModel extends ViewModel {

    private final MutableLiveData<List<Instrument>> mText;

    private String additionalText;

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }

    private Repository repository;
    private PricesMapper mapper;
    private Interactor interactor;
    private FuturesMatcher futuresMatcher;

    public FuturesViewModel() {
        mText = new MutableLiveData<>();
        List<Instrument> tempList = new ArrayList<>(); // todo
        mText.setValue(tempList);
        repository = new Repository();
        mapper = new PricesMapper();
        interactor = new Interactor.Base(repository, mapper);
        futuresMatcher = new FuturesMatcher();
        Log.d("CALL","Price updated");
        updatePrice();
    }
    public void updatePrice() {
        interactor.fetchLastPrices(new LastPricesCallback() {
            @Override
            public void updatePrices(List<LastPrices> price) {
                List<Instrument> s = mapper.mapByFigi(price,futuresMatcher);
                setText(s);
                Log.d("CALL","Text setted");
            }
        },"futures");

    }

    public LiveData<List<Instrument>> getText() {
        Log.d("CALL","LiveData updated");
        return mText;
    }

    public void setText(List<Instrument> s) {
        Instrument sber = new Instrument("",
                additionalText,
                "", "", "");
        s.add(0, sber);
        mText.postValue(s);

    }
}