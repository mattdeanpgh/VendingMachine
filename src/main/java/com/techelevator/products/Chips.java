package com.techelevator.products;

public class Chips extends Products{
    public Chips(String slotNumber, String name, double price, String productType) {
        super(slotNumber, name, price, productType);
    }
    public void boughtChips() {
        System.out.println("Crunch Crunch, Yum!");
    }
}