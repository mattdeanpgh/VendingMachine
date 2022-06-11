package com.techelevator.products;

public class Beverage extends Products{
    public Beverage(String slotNumber, String name, double price, String productType, int inventoryCount) {
        super(slotNumber, name, price, productType, inventoryCount);
    }
    public void boughtBeverage() {
        System.out.println("Glug Glug, Yum!");
    }
}
