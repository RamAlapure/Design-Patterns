package com.ramalapure.dp.abstractfactory;

import java.util.logging.Logger;

public class BMWA implements Car {

    private static final int PRICE = 120;
    public static final Logger log = Logger.getLogger(BMWA.class.getName());

    public BMWA() {
        log.info("Driving BMW");
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
