package com.kyronison.ecounse.ui.bonds;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kyronison.ecounse.data.LastPrices;
import com.kyronison.ecounse.domain.Interactor;
import com.kyronison.ecounse.domain.LastPricesCallback;
import com.kyronison.ecounse.domain.PricesMapper;
import com.kyronison.ecounse.domain.Repository;
import com.kyronison.ecounse.matchers.BondsMatcher;
import com.kyronison.ecounse.model.Instrument;

import java.util.ArrayList;
import java.util.List;

public class BondsViewModel extends ViewModel {

    private final MutableLiveData<List<Instrument>> mText;

    private String additionalText;

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }

    private Repository repository;
    private PricesMapper mapper;
    private Interactor interactor;
    private BondsMatcher bondsMatcher;

    public BondsViewModel() {
        mText = new MutableLiveData<>();
        List<Instrument> tempList = new ArrayList<>(); // todo
        mText.setValue(tempList);
        repository = new Repository();
        mapper = new PricesMapper();
        interactor = new Interactor.Base(repository, mapper);
        bondsMatcher = new BondsMatcher();
        Log.d("CALL","Price updated");
        updatePrice();
    }
    public void updatePrice() {
        interactor.fetchLastPrices(new LastPricesCallback() {
            @Override
            public void updatePrices(List<LastPrices> price) {
                //price.forEach(v -> v.setPrice(
                //        new Price(v.getPrice().getUnits()+0, v.getPrice().getNano())));
                List<Instrument> s = mapper.mapByFigi(price,bondsMatcher);
                setText(s);
                Log.d("CALL",price.toString());
            }
        },"bonds");

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