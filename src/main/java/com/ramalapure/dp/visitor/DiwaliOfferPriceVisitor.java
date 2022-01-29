package com.ramalapure.dp.visitor;

public class DiwaliOfferPriceVisitor implements Visitor {
    private int totalPrice;

    public void visit(Car car) {
        totalPrice = car.getPrice() - (car.getPrice() * 10) / 100;
    }

    public void visit(Bike bike) {
        totalPrice = bike.getPrice() - (bike.getPrice() * 10) / 100;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
