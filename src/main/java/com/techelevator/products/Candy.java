package com.techelevator.products;

public class Candy extends Products{
    public Candy(String slotNumber, String name, double price, String productType, int inventoryCount) {
        super(slotNumber, name, price, productType, inventoryCount);
    }
    public String boughtIt() {
        return  "Munch Munch, Yum!";
    }
}
