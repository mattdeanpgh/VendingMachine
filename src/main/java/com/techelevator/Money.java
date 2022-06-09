package com.techelevator;

public class Money {
    private double currentMoney;
    private double changeInCoins;
//    private static final double QUARTERS;
//    private double NICKELS;
//    private double DIMES;

    public Money(double currentMoney, double changeInCoins) {
        this.currentMoney = currentMoney;
        this.changeInCoins = changeInCoins;
    }

    public double feedMoney (double moneyInserted) {
        currentMoney = currentMoney + moneyInserted;
        return currentMoney;
    }
//    public double makePurchase (double productPrice) {
//        double change = 0;
//          double changeInCoins = 0;
//        change = (currentMoney - productPrice);
//        if (change % QUARTERS == 0) {
//            return changeInCoins;
//        } else if ((change / QUARTERS) % DIMES == 0);
//            return changeInCoins;
//        } else if (((change / QUARTERS) / DIMES) % NICKELS == 0)
//        return changeInCoins;
//    }
//    make a counter of each coin


    public double changeReturned ()

    /*
    change return method:
    current money - product price = change
    changeToReturn = ((change % QUARTERS) % DIMES) % NICKELS
    return = changeToReturn

     */
}
