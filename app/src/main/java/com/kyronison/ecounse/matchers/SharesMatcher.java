package com.kyronison.ecounse.matchers;

import java.util.HashMap;
import java.util.Map;

public class SharesMatcher extends InstrumentMatcher{

    public static Map<String, String> figiToTicker = new HashMap<>();
    public static Map<String, String> figiToName = new HashMap<>();

    static {
        figiToTicker.put("BBG004731354", "ROSN");
        figiToTicker.put("BBG006L8G4H1", "YNDX");
        figiToTicker.put("BBG004731032", "LKOH");
        figiToTicker.put("BBG004S681B4", "NLMK");
        figiToTicker.put("BBG004RVFCY3", "MGNT");
        figiToTicker.put("BBG004730N88", "SBER");
        figiToTicker.put("BBG004731489", "GMKN");
        figiToTicker.put("BBG00475KKY8", "NVTK");
        figiToTicker.put("BBG004S68507", "MAGN");
        figiToTicker.put("BBG004S68598", "MTLR");
        figiToTicker.put("BBG004S681W1", "MTSS");
        figiToTicker.put("BBG00QPYJ5H0", "TCSG");
        figiToTicker.put("BBG004730RP0", "GAZP");
        figiToTicker.put("BBG00JXPFBN0", "FIVE");
        figiToTicker.put("BBG000N16BP3", "MOEX");

        figiToName.put("BBG004731354", "Роснефть");
        figiToName.put("BBG006L8G4H1", "Яндекс");
        figiToName.put("BBG004731032", "Лукойл");
        figiToName.put("BBG004S681B4", "НЛМК");
        figiToName.put("BBG004RVFCY3", "Магнит");
        figiToName.put("BBG004730N88", "Сбербанк");
        figiToName.put("BBG004731489", "Норильский никель");
        figiToName.put("BBG00475KKY8", "Новатэк");
        figiToName.put("BBG004S68507", "ММК");
        figiToName.put("BBG004S68598", "Мечел");
        figiToName.put("BBG004S681W1", "МТС");
        figiToName.put("BBG00QPYJ5H0", "Тинькофф");
        figiToName.put("BBG004730RP0", "Газпром");
        figiToName.put("BBG00JXPFBN0", "X5 RetailGroup");
        figiToName.put("BBG000N16BP3", "Московская Биржа");

    }
    @Override
    public String getTickerByFigi(String figi){
        return figiToTicker.get(figi);
    }


    @Override
    public String getNameByFigi(String figi){
        return figiToName.get(figi);
    }
}
