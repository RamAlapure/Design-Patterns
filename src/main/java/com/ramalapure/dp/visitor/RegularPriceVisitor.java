package com.ramalapure.dp.visitor;

public class RegularPriceVisitor implements Visitor {
    private int totalPrice;

    public void visit(Car car) {
        totalPrice = car.getPrice();
    }

    public void visit(Bike bike) {
        totalPrice = bike.getPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
