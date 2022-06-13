package com.techelevator.products;

public class Products {
    private String name;
    private String slotNumber;
    private int inventoryCount = 5;
    private String productType;
    private double price;

    public Products(String slotNumber, String name, double price, String productType, int inventoryCount) {
        this.slotNumber = slotNumber;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.inventoryCount = inventoryCount;
    }

    public Products(String slotNumber, String name, double price, String productType) {
        this.slotNumber = slotNumber;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }



    public String boughtIt() {
        return boughtIt();
    }
    public int reduceInventory() {
        if (this.inventoryCount == 0) {
            System.out.println("Item SOLD OUT. Please select another option.");
        } inventoryCount = inventoryCount - 1;
return inventoryCount;
    }

    public int getInventoryCount() {
        return inventoryCount;
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
