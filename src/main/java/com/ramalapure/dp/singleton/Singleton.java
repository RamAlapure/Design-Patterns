package com.ramalapure.dp.singleton;

import java.util.logging.Logger;

public class Singleton {

    public static final Logger log = Logger.getLogger(Singleton.class.getName());
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (singleton == null) singleton = new Singleton();
            return singleton;
        }
    }

    public void process() {
        log.info("Processing singleton");
    }
}
