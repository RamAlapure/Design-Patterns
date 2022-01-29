package com.ramalapure.dp.visitor;

public class NewYearOfferPriceVisitor implements Visitor {
    private int totalPrice;

    public void visit(Car car) {
        totalPrice = car.getPrice() - (car.getPrice() * 7) / 100;
    }

    public void visit(Bike bike) {
        totalPrice = bike.getPrice() - (bike.getPrice() * 7) / 100;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
