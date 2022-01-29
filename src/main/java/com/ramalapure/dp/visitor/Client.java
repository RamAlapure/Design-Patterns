package com.ramalapure.dp.visitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    public static final Logger log = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) {
        BMW car = new BMW();

        RegularPriceVisitor regularPrice = new RegularPriceVisitor();
        DiwaliOfferPriceVisitor diwaliOfferPrice = new DiwaliOfferPriceVisitor();
        NewYearOfferPriceVisitor newYearOfferPrice = new NewYearOfferPriceVisitor();

        car.accept(regularPrice);
        car.accept(diwaliOfferPrice);
        car.accept(newYearOfferPrice);

        int bmwRegularPrice = regularPrice.getTotalPrice();
        int bmwDiwaliOfferPrice = diwaliOfferPrice.getTotalPrice();
        int bmwNewYearOfferPrice = newYearOfferPrice.getTotalPrice();

        for (int i : new int[]{bmwRegularPrice, bmwDiwaliOfferPrice, bmwNewYearOfferPrice})
            log.log(Level.INFO, () -> String.valueOf(i));

    }
}
