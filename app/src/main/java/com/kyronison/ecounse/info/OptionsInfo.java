package com.kyronison.ecounse.info;

import java.util.ArrayList;
import java.util.Arrays;

public class OptionsInfo extends InstrumentsInfo {
    public static final ArrayList<String> figiOptions = new ArrayList<String>(
            Arrays.asList(
                    "64c8e02b-be2d-4e8d-b940-901d11eeec39",//Московская Биржа CALL ME117CF3A
                    "8f6984cd-7e29-42cc-bdb3-b1c9485d654f",//Роснефть CALL RN420CR3A
//                    "64925a5a-838e-4f08-a62c-41b5c9b75d41",//Сбер Банк SR260CF3B
                    "d12c87f7-0001-4943-a741-b615f5ac4ca8"//Yandex CALL 2200₽ 31.05 YN2200CF3A
            ));
    @Override
    public ArrayList<String> getInstrumentUids() {
        return null;
    }
}
