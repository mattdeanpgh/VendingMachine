package com.techelevator.products;

public class Candy extends Products{
    public Candy(String slotNumber, String name, double price, String productType) {
        super(slotNumber, name, price, productType);
    }
    public String boughtIt() {
        return  "Munch Munch, Yum!";
    }
}
