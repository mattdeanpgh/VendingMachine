package com.techelevator.products;

public class Chips extends Products{
    public Chips(String slotNumber, String name, double price, String productType, int inventoryCount) {
        super(slotNumber, name, price, productType, inventoryCount);
    }
    public String boughtIt() {
       return "Crunch Crunch, Yum!";

    }

}
