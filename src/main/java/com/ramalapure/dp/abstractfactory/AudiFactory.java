package com.ramalapure.dp.abstractfactory;

public class AudiFactory {

    private AudiFactory() {
    }

    public static Car getInstance(String str) {
        Car instance;
        if ("AudiA".equalsIgnoreCase(str)) {
            instance = new AudiA();
        } else if ("AudiB".equalsIgnoreCase(str)) {
            instance = new AudiB();
        } else {
            throw new IllegalStateException("Unexpected value: " + str);
        }
        return instance;
    }
}
