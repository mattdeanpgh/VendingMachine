package com.techelevator;

public class Money {
    private double currentMoney = 0;
    private double productPrice;

    public Money(double currentMoney, double productPrice) {
        this.currentMoney = currentMoney;

        this.productPrice = productPrice;
    }



    public double getCurrentMoney() {
        return currentMoney;
    }

    public double getProductPrice() {
        return productPrice;
    }
    public double feedMoney(double moneyInserted) {
        currentMoney = currentMoney + moneyInserted;
        return currentMoney;
    }

    public void makePurchaseReturnChange() { //toString
        double change = currentMoney - productPrice;
        int quarterCounter = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;
        int quartersFromTruncation = (int) (change / .25);
        int dimesFromTruncation = (int) (((change * 100) - (quartersFromTruncation * 25)) / 10);

        if (change >= .25) {
            quarterCounter += change / .25;
        }
        if (change >=.10) {
            change = change - ((quartersFromTruncation * 25) / 100);
            dimeCounter += change /.1;
        }
        if (change >= .05) {
            change = change - ((((quartersFromTruncation * 25) + (dimesFromTruncation * 10)) / 100));
            nickelCounter += change / .05;
        }
        System.out.println("Change due is " + change + "(" + quarterCounter + " quarters, " + dimeCounter + " dimes, " + nickelCounter + " nickels)");
    }
}

//inventory reduction: inventory count needs to go down by 1 each time that item is purchased
//if item inventory == 0 sout "SOLD OUT" and return to previous menu
