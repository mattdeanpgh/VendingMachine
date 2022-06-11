package com.techelevator.products;

public class Candy extends Products{
    public Candy(String slotNumber, String name, double price, String productType) {
        super(slotNumber, name, price, productType);
    }
    public void boughtIt() {
        System.out.println("Munch Munch, Yum!");
    }
}
