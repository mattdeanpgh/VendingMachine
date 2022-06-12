package com.techelevator;

import com.techelevator.products.Products;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;


public class Money {
    private double currentMoney = 0;
    private double feedMoney;
    private double withdraw;


    public Money(double currentMoney, double feedMoney) {
        this.feedMoney = feedMoney;
        this.currentMoney = currentMoney;


    }
    public Money(double withdraw) {
        this.withdraw = withdraw;
    }

    public Money() {

    }

    public double getCurrentMoney() {
        return currentMoney;
    }

    public double getFeedMoney() {
        return feedMoney;
    }

//    public boolean moneyInsert () {
//        boolean validInput = true;
//        double fedMoney = 0;
//
//        if (fedMoney < 0 || fedMoney != 1 || fedMoney != 2 || fedMoney != 5 || fedMoney != 10 || fedMoney > 10) {
//            validInput = false;
//            System.out.println("Invalid amount.");
////        } else {
//
//        } return
//    }
    public void makePurchaseReturnChange () {
            int quartersFromTruncation = (int) (currentMoney / .25);
            int dimesFromTruncation = (int) (((currentMoney * 100) - (quartersFromTruncation * 25)) / 10);
            int nickelsFromTruncation = (int) (((currentMoney*100) - ((quartersFromTruncation*25) + (dimesFromTruncation*10))) / 5);

            NumberFormat format = NumberFormat.getCurrencyInstance();
            String moneyString = format.format(currentMoney);
            System.out.println("Change due is " + moneyString + ": " + quartersFromTruncation + " quarter(s), " + dimesFromTruncation + " dime(s), " + nickelsFromTruncation + " nickel(s)");
        }
    }







//inventory reduction: inventory count needs to go down by 1 each time that item is purchased
//if item inventory == 0 sout "SOLD OUT" and return to previous menu
