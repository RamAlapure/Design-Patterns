package com.ramalapure.dp.abstractfactory;

import java.util.logging.Logger;

public class AudiB implements Car {

    private static final int PRICE = 100;
    public static final Logger log = Logger.getLogger(AudiB.class.getName());

    public AudiB() {
        log.info("Driving Audi");
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
