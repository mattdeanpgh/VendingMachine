package com.techelevator;

import com.techelevator.products.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Machine {
    private List<Products> itemsInMachine = new ArrayList<Products>();

    public Machine() {

    }

    public Machine(List<Products> itemsInMachine) {
        this.itemsInMachine = itemsInMachine;
    }


    public List<Products> getItemsInMachine() {
//        return itemsInMachine;
//    }
//
//
//    public List<Products> itemsInMachine () {
////        this.itemsInMachine = itemsInMachine;

    File inventory = new File("vendingmachine.csv");



        try (Scanner fileInput = new Scanner(inventory)) {
            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                {
                    String[] productDetails = lineOfText.split("\\|");
                    {
                        String productLocation = productDetails[0];
                        String productName = productDetails[1];
                        double productCost = Double.parseDouble(productDetails[2]);
                        String productType = productDetails[3];
                        int inventoryCount = 5;


                        if (productType.equals("Drink")) {
                            Beverage newBeverage = new Beverage(productLocation, productName, productCost, productType, inventoryCount);
                            {
                                itemsInMachine.add(newBeverage);
                            }
                        } else if (productType.equals("Chip")) {

                            Chips newChip = new Chips(productLocation, productName, productCost, productType, inventoryCount);
                            {
                                itemsInMachine.add(newChip);
                            }
                        } else if (productType.equals("Candy")) {
                            Candy newCandy = new Candy(productLocation, productName, productCost, productType, inventoryCount);
                            {
                                itemsInMachine.add(newCandy);
                            }
                        } else if (productType.equals("Gum")) {
                            Gum newGum = new Gum(productLocation, productName, productCost, productType, inventoryCount);
                            {
                                newGum.setName(productName);
                                itemsInMachine.add(newGum);
                            }
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return itemsInMachine;

//        for (Products prod : itemsInMachine) {
//            NumberFormat formatter = NumberFormat.getCurrencyInstance();
//            String moneyString = formatter.format(prod.getPrice());
//            System.out.println(prod.getSlotNumber() + " | " + prod.getName() + " | " + moneyString + " | " + prod.getProductType());
        //need to have quantity remaining

//
    }
}







