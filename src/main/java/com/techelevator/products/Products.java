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

    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

}
