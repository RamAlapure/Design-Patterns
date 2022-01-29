package com.ramalapure.dp.factory;

import java.util.logging.Logger;

public class Audi implements Car {

    private static final int PRICE = 100;
    public static final Logger log = Logger.getLogger(Audi.class.getName());

    public Audi() {
        log.info("Driving Audi");
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
