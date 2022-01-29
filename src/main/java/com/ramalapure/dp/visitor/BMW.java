package com.ramalapure.dp.visitor;

public class BMW implements Car, Visitable {

    private static final int PRICE = 100;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public int getPrice() {
        return PRICE;
    }
}
