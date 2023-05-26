package com.kyronison.ecounse.matchers;

import java.util.HashMap;
import java.util.Map;

abstract public class InstrumentMatcher {
    abstract public String getTickerByFigi(String figi);
    abstract public String getNameByFigi(String figi);
}
