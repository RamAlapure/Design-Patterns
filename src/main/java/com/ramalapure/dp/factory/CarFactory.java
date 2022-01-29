package com.ramalapure.dp.factory;

public class CarFactory {

    private CarFactory() {
    }

    public static Car getInstance(String str) {
        Car instance;
        if ("Audi".equalsIgnoreCase(str)) {
            instance = new Audi();
        } else if ("BMW".equalsIgnoreCase(str)) {
            instance = new BMW();
        } else {
            throw new IllegalStateException("Unexpected value: " + str);
        }
        return instance;
    }

}
