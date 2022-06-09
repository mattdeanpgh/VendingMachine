package com.techelevator.products;

public class Beverage extends Products{
    public Beverage(String slotNumber, String name, double price, String productType) {
        super(slotNumber, name, price, productType);
    }
    public void boughtBeverage() {
        System.out.println("Glug Glug, Yum!");
    }
}
