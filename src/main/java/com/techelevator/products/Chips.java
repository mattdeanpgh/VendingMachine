package com.techelevator.products;

public class Chips extends Products{
    public Chips(String slotNumber, String name, double price, String productType) {
        super(slotNumber, name, price, productType);
    }
    public String boughtIt() {
       return "Crunch Crunch, Yum!";

    }


//
//    @Override
//    public int getInventoryCount() {
//        return inventoryCount;
//    }
//
//    public int inventoryCount = 5;
}
