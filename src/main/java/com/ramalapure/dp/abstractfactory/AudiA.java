package com.ramalapure.dp.abstractfactory;

import java.util.logging.Logger;

public class AudiA implements Car {

    private static final int PRICE = 100;

    public static final Logger log = Logger.getLogger(AudiA.class.getName());

    public AudiA() {
        log.info("Driving Audi");
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
