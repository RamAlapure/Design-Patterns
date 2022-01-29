package com.ramalapure.dp.visitor;

public class Honda implements Bike, Visitable {
    int price = 30;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public int getPrice() {
        return price;
    }
}
