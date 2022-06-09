package com.techelevator;

public class Money {
    private double currentMoney = 0;
    private double changeInCoins;
    private double productPrice;
//    private static final double QUARTERS;
//    private double NICKELS;
//    private double DIMES;

    public Money(double currentMoney, double changeInCoins, double productPrice) {
        this.currentMoney = currentMoney;
        this.changeInCoins = changeInCoins;
        this.productPrice = productPrice;
    }

    public double feedMoney(double moneyInserted) {
        currentMoney = currentMoney + moneyInserted;
        return currentMoney;
    }

    public void makePurchaseReturnChange() { //toString
        // get the change due, find how many quarters/dimes/nickels to return
        // change due / .
        int quarterCounter = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;
        double change = currentMoney - productPrice; //make a method for making change and plug into here
        int quartersFromTruncation = (int) (change / .25);
        int dimesFromTruncation = (int) ((change / .25) / .1);
//        int nickelsFromTruncation = 0;

        if (change >= .25) {
            quarterCounter += change / .25;

        }
        if (change >=.10) {

            change = (change * 100) - (quartersFromTruncation * 25);
            dimeCounter += change /10;

        }
        if (change >= .05) {
            change = (change / .25);
            nickelCounter += change / .05;

        }
        System.out.println("Change due is " + change + "(" + quarterCounter + " quarters, " + dimeCounter + " dimes, " + nickelCounter + " nickels)");



    }
}

//inventory reduction: inventory count needs to go down by 1 each time that item is purchased
//if item inventory == 0 sout "SOLD OUT" and return to previous menu
