package com.ramalapure.dp.abstractfactory;

public class CarFactory {

    private CarFactory() {
    }

    public static Car getInstance(String brand, String model) {
        Car instance;
        if ("Audi".equalsIgnoreCase(brand)) {
            instance = AudiFactory.getInstance(model);
        } else if ("BMW".equalsIgnoreCase(brand)) {
            instance = BMWFactory.getInstance(model);
        } else {
            throw new IllegalStateException("Unexpected value: " + brand);
        }
        return instance;
    }

}
