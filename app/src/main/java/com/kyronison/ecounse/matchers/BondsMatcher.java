package com.kyronison.ecounse.matchers;

import java.util.HashMap;
import java.util.Map;

public class BondsMatcher extends InstrumentMatcher{

    public static Map<String, String> figiToTicker = new HashMap<>();
    public static Map<String, String> figiToName = new HashMap<>();
    static {
        figiToTicker.put("BBG00KSNVG40", "RU000A0ZZ505");
        figiToTicker.put("BBG011FJ4HS6", "SU26238RMFS4");
        figiToTicker.put("BBG011MLGP84", "SU26240RMFS0");
        figiToTicker.put("BBG00JX82779", "RU000A106540");
        figiToTicker.put("TCS00A103943", "RU000A103943");
        figiToTicker.put("TCS00A103D37", "RU000A103D37");
        figiToTicker.put("TCS00A106540", "RU000A106540");


        figiToName.put("BBG00KSNVG40", "РСХБ 09Т1");
        figiToName.put("BBG011FJ4HS6", "ОФЗ 26238");
        figiToName.put("BBG011MLGP84", "ОФЗ 26240");
        figiToName.put("BBG00JX82779", "АФК Система выпуск 7");
        figiToName.put("TCS00A103943", "Аэрофлот выпуск 1");
        figiToName.put("TCS00A103D37", "Тинькофф Ипотечный Агент выпуск 1");
        figiToName.put("TCS00A106540", "М.Видео выпуск 4");

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
