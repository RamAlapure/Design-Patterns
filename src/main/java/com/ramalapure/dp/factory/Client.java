package com.ramalapure.dp.factory;

import java.util.logging.Logger;

public class Client {

    public static final Logger log = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {
        Car a = CarFactory.getInstance("Audi");
        log.info(a.getClass().getName());

        Car b = CarFactory.getInstance("BMW");
        log.info(b.getClass().getName());
    }
}
