package com.kyronison.ecounse.info;

import java.util.ArrayList;
import java.util.Arrays;

public class SharesInfo extends InstrumentsInfo {

    public static final ArrayList<String> figiShares = new ArrayList<String>(
            Arrays.asList(
        "BBG004731354",//ROSN
        "BBG006L8G4H1",//YNDX
        "BBG004731032",//LKOH
        "BBG004S681B4",//NLMK
        "BBG004RVFCY3",//MGNT
        "BBG004730N88",//SBER
        "BBG004731489",//GMNK
        "BBG00475KKY8",//NVTK
        "BBG004S68507",//MMK
        "BBG004S68598",//MTLR
        "BBG004S681W1",//MTSS
        "BBG00QPYJ5H0",//TCSG
        "BBG004730RP0",//GAZP
        "BBG00JXPFBN0",//FIVE
        "BBG000N16BP3"));//MOEX

    @Override
    public ArrayList<String> getInstrumentUids() {
        return null;
    }

}

/*
// futures gold, silver, sp500, gmnk, y...

4x2 hashmap ticker, name, key (instrument uid)(figi)
layout 4 textView name, ticker, time, price
viewholder setText x4

logging add and update viewmodel













 */
