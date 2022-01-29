package com.ramalapure.dp.factory;

import java.util.logging.Logger;

public class BMW implements Car {

    private static final int PRICE = 100;
    public static final Logger log = Logger.getLogger(BMW.class.getName());

    public BMW() {
        log.info("Driving BMW");
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
