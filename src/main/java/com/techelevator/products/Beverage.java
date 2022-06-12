package com.techelevator.products;

public class Beverage extends Products{
    public Beverage(String slotNumber, String name, double price, String productType) {
        super(slotNumber, name, price, productType);
    }
    public String boughtIt() {
        return  "Glug Glug, Yum!";
    }
}
