package com.kyronison.ecounse.info;

import java.util.ArrayList;
import java.util.Arrays;

public class FuturesInfo extends InstrumentsInfo{
    public static final ArrayList<String> figiFutures = new ArrayList<String>(
            Arrays.asList(
                    "FUTNG1023000",//NG-10.23 Природный газ NGV3
                    "FUTBR0424000",//BR-4.24 Нефть Brent BRJ4
                    "FUTCO0623000",//Co-6.23 Медь CoM3
                    "FUTGOLD03240",//GOLD-3.24 Золото GDH4
                    "FUTWHEA03240",//WHEAT-3.24 Индекс Пшеницы W4H4
                    "FUTDAX062300",//DAX-6.23 DAX 40 DXM3
                    "FUTNASD06230",//NASD-6.23 Nasdaq 100 NAM3
                    "FUTRTS032500"//RTS-3.25 Индекс РТС RIH5
            ));
    @Override
    public ArrayList<String> getInstrumentUids() {
        return null;
    }
}
