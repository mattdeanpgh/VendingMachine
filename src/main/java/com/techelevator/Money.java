package com.techelevator;

import com.techelevator.products.Products;

import java.io.*;
import java.util.*;

public class Money extends Machine {
    private double currentMoney = 0;
    private double feedMoney;


    public Money(double currentMoney, double feedMoney) {
        this.feedMoney = feedMoney;
        this.currentMoney = currentMoney;

    }

    public Money() {

    }

    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    public double getCurrentMoney() {
        return currentMoney;
    }


    public double getFeedMoney() {
        return feedMoney;
    }

    public void FeedMoney(double moneyInserted) {
        if (moneyInserted <= 0 || moneyInserted >= 10) {
            System.out.println("Invalid amount. Return to main menu.");
        } else {
            currentMoney = currentMoney + moneyInserted;

//        } return currentMoney;
        }
    }
        public double withdraw ( double priceOfProduct){
            currentMoney = currentMoney - priceOfProduct;
            return currentMoney;
        }

        public void makePurchaseReturnChange () {
            int quarterCounter = 0;
            int dimeCounter = 0;
            int nickelCounter = 0;
            int quartersFromTruncation = (int) (currentMoney / .25);
            int dimesFromTruncation = (int) (((currentMoney * 100) - (quartersFromTruncation * 25)) / 10);

            if (currentMoney >= .25) {
                quarterCounter += currentMoney / .25;
            }
            if (currentMoney >= .10) {
                currentMoney = currentMoney - ((quartersFromTruncation * 25) / 100);
                dimeCounter += currentMoney / .1;
            }
            if (currentMoney >= .05) {
                currentMoney = currentMoney - ((((quartersFromTruncation * 25) + (dimesFromTruncation * 10)) / 100));
                nickelCounter += currentMoney / .05;
            }
            System.out.println("Change due is " + currentMoney + "(" + quarterCounter + " quarters, " + dimeCounter + " dimes, " + nickelCounter + " nickels)");
        }
    }







//inventory reduction: inventory count needs to go down by 1 each time that item is purchased
//if item inventory == 0 sout "SOLD OUT" and return to previous menu
