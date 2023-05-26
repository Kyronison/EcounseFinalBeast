package com.kyronison.ecounse.matchers;

import java.util.HashMap;
import java.util.Map;

public class OptionsMatcher extends InstrumentMatcher {
    public static Map<String, String> figiToTicker = new HashMap<>();
    public static Map<String, String> figiToName = new HashMap<>();
    static {
        figiToTicker.put("64c8e02b-be2d-4e8d-b940-901d11eeec39", "ME117CF3A");
        figiToTicker.put("8f6984cd-7e29-42cc-bdb3-b1c9485d654f", "RN420CR3A");
//        figiToTicker.put("64925a5a-838e-4f08-a62c-41b5c9b75d41", "SR260CF3B");
        figiToTicker.put("d12c87f7-0001-4943-a741-b615f5ac4ca8", "YN2200CF3A");


        figiToName.put("64c8e02b-be2d-4e8d-b940-901d11eeec39", "Московская Биржа");
        figiToName.put("8f6984cd-7e29-42cc-bdb3-b1c9485d654f", "Роснефть");
//        figiToName.put("64925a5a-838e-4f08-a62c-41b5c9b75d41", "Сбер Банк");
        figiToName.put("d12c87f7-0001-4943-a741-b615f5ac4ca8", "Yandex CALL 2200₽ 31.05");

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
