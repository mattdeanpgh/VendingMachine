package com.techelevator;

import com.techelevator.products.Products;

import java.io.*;
import java.util.*;

public class Money extends Machine{
    private double currentMoney = 0;
    private double change;

    public Money(double currentMoney, double change) {

        this.currentMoney = currentMoney;
        this.change = change;
    }
    public Money() {
        
    }

    @Override
    public List<Products> getItemsInMachine() {
        return super.getItemsInMachine();
    }
    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    public double getCurrentMoney() {
        return currentMoney;
    }
//    public double getChange() throws FileNotFoundException {
//        File inventory = new File("vendingmachine.csv");
//        try (Scanner fileInput = new Scanner(inventory)) {
//            while (fileInput.hasNextLine()) {
//                String lineOfText = fileInput.nextLine();
//                {
//                    String[] productDetails = lineOfText.split("\\|");
//                    double productPrice = Double.parseDouble(productDetails[2]);
//
//                    change = currentMoney - productPrice;
//                }
//            }
//        }
    public double getChange() {

        return change;
    }

    public double feedMoney(double moneyInserted) {
        currentMoney = currentMoney + moneyInserted;
        return currentMoney;
    }

    public void makePurchaseReturnChange() { //toString
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
