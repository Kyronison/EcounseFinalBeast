package com.kyronison.ecounse.info;

import java.util.ArrayList;
import java.util.Arrays;

public class BondsInfo extends InstrumentsInfo{
    public static final ArrayList<String> figiBonds = new ArrayList<String>(
            Arrays.asList(
                    "BBG00KSNVG40",//РСХБ 09Т1
                    "BBG011FJ4HS6",//ОФЗ 26238
                    "BBG011MLGP84",//ОФЗ 26240
                    "BBG00JX82779",//АФК Система выпуск 7
                    "TCS00A103943",//Аэрофлот выпуск 1
                    "TCS00A103D37",//Тинькофф Ипотечный Агент выпуск 1
                    "TCS00A106540"//М.Видео выпуск 4
            ));
    @Override
    public ArrayList<String> getInstrumentUids() {
        return null;
    }
}
