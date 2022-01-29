package com.ramalapure.dp.abstractfactory;

public class BMWFactory {

    private BMWFactory() {
    }

    public static Car getInstance(String str) {
        Car instance;
        if ("BMWA".equalsIgnoreCase(str)) {
            instance = new BMWA();
        } else if ("BMWB".equalsIgnoreCase(str)) {
            instance = new BMWB();
        } else {
            throw new IllegalStateException("Unexpected value: " + str);
        }
        return instance;
    }
}
