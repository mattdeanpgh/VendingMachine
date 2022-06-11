package com.techelevator.products;

public class Products {
    private String name;
    private String slotNumber;
    private int inventoryCount = 5;
    private String productType;
    private double price;

//, int inventoryCount

    public Products(String slotNumber, String name, double price, String productType, int inventoryCount) {
        this.slotNumber = slotNumber;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.inventoryCount = inventoryCount;
    }


    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
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
