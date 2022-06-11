package com.techelevator.products;

public class Gum extends Products{
    public Gum(String slotNumber, String name, double price, String productType, int inventoryCount) {
        super(slotNumber, name, price, productType, inventoryCount);
    }
    public void boughtIt() {
        System.out.println("Chew Chew, Yum!");
    }
}
