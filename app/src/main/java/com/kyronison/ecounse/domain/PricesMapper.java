package com.kyronison.ecounse.domain;

import com.kyronison.ecounse.data.LastPrices;
import com.kyronison.ecounse.matchers.InstrumentMatcher;
import com.kyronison.ecounse.model.Instrument;

import java.util.ArrayList;
import java.util.List;

public class PricesMapper {

    public List<Instrument> mapByFigi(List<LastPrices> p, InstrumentMatcher instrumentMatcher) {
            List<Instrument> shares = new ArrayList<>();
            p.forEach(e ->
                    shares.add(
                            new Instrument(e.getFigi(), instrumentMatcher.getNameByFigi(e.getFigi()),
                                    e.getPrice() + "",
                                    e.getTime() + "", instrumentMatcher.getTickerByFigi(e.getFigi())
                            ))
            );

            return shares;
    }
    public List<Instrument> mapByUid(List<LastPrices> p, InstrumentMatcher instrumentMatcher) {
        List<Instrument> shares = new ArrayList<>();
        p.forEach(e ->
                shares.add(
                        new Instrument(e.getInstrumentUid(), instrumentMatcher.getNameByFigi(e.getInstrumentUid()),
                                e.getPrice() + "",
                                e.getTime() + "", instrumentMatcher.getTickerByFigi(e.getInstrumentUid())
                        ))
        );
        return shares;
    }
}
