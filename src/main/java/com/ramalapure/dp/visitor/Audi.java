package com.ramalapure.dp.visitor;

public class Audi implements Car, Visitable{

    private static final int PRICE = 120;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public int getPrice() {
        return PRICE;
    }
}
