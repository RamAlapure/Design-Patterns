package com.ramalapure.dp.abstractfactory;

import java.util.logging.Logger;

public class BMWB implements Car {

    private static final int PRICE = 100;

    public static final Logger log = Logger.getLogger(BMWB.class.getName());

    public BMWB() {
        log.info("Driving BMW");
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
