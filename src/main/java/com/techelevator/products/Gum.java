package com.techelevator.products;

public class Gum extends Products{
    public Gum(String slotNumber, String name, double price, String productType) {
        super(slotNumber, name, price, productType);
    }
    public void boughtGum() {
        System.out.println("Chew Chew, Yum!");
    }
}
