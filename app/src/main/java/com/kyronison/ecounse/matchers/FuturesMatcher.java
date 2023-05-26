package com.kyronison.ecounse.matchers;

import java.util.HashMap;
import java.util.Map;

public class FuturesMatcher extends InstrumentMatcher{

    public static Map<String, String> figiToTicker = new HashMap<>();
    public static Map<String, String> figiToName = new HashMap<>();
    static {
        figiToTicker.put("FUTNG1023000", "NGV3");
        figiToTicker.put("FUTBR0424000", "BRJ4");
        figiToTicker.put("FUTCO0623000", "CoM3");
        figiToTicker.put("FUTGOLD03240", "GDH4");
        figiToTicker.put("FUTWHEA03240", "W4H4");
        figiToTicker.put("FUTDAX062300", "DXM3");
        figiToTicker.put("FUTNASD06230", "NAM3");
        figiToTicker.put("FUTRTS032500", "RIH5");

        figiToName.put("FUTNG1023000", "NG-10.23 Природный газ");
        figiToName.put("FUTBR0424000", "BR-4.24 Нефть Brent");
        figiToName.put("FUTCO0623000", "Co-6.23 Медь");
        figiToName.put("FUTGOLD03240", "GOLD-3.24 Золото");
        figiToName.put("FUTWHEA03240", "WHEAT-3.24 Индекс Пшеницы");
        figiToName.put("FUTDAX062300", "DAX-6.23 DAX 40");
        figiToName.put("FUTNASD06230", "NASD-6.23 Nasdaq 100");
        figiToName.put("FUTRTS032500", "RTS-3.25 Индекс РТС");


    }
    @Override
    public String getTickerByFigi(String figi) {
        return figiToTicker.get(figi);

    }

    @Override
    public String getNameByFigi(String figi) {
        return figiToName.get(figi);
    }
}
