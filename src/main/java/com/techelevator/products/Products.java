package com.techelevator.products;

public class Products {
    private String name;
    private String slotNumber;
    private int inventoryCount = 5;
    private String productType;
    private double price;

//    public Products(String name, String slotNumber, int inventoryCount, String productType, double price) {
//        this.name = name;
//        this.slotNumber = slotNumber;
//        this.inventoryCount = inventoryCount;
//        this.productType = productType;
//        this.price = price;
//    }
    public Products(String slotNumber, String name, double price, String productType) {
        this.slotNumber = slotNumber;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
