package com.techelevator;

import com.techelevator.products.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Machine {
    public static void main(String[] args) {

        List <Products> itemsInMachine = new ArrayList<>();

        File inventory = new File("vendingmachine.csv");

        {
            try (Scanner fileInput = new Scanner(inventory)) {
                while (fileInput.hasNextLine()) {
                    String lineOfText = fileInput.nextLine();
                    {
                        String [] productDetails = lineOfText.split("\\|");
                        {
                            String productLocation = productDetails[0];
                            String productName = productDetails[1];
                            Double productCost = Double.parseDouble(productDetails[2]);
                            String productType = productDetails[3];

                            if (productType.equals("Drink")) {
                            Beverage newBeverage = new Beverage(productLocation, productName, productCost, productType);
                            {
                                itemsInMachine.add(newBeverage);
                            }
                        }
                                else if (productType.equals("Chip")) {

                                    Chips newChip = new Chips(productLocation, productName, productCost, productType ); {
                                        itemsInMachine.add(newChip);
                                    }
                        }
                                else if (productType.equals("Candy")) {
                                    Candy newCandy = new Candy(productLocation, productName, productCost, productType); {
                                        itemsInMachine.add(newCandy);
                                    }
                                }
                                else if (productType.equals("Gum")) {
                                    Gum newGum = new Gum(productLocation, productName, productCost, productType); {
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
        }

        for (Products prod : itemsInMachine) {
        System.out.println(prod.getSlotNumber() + " | " + prod.getName() + " | " + prod.getPrice() + " | " + prod.getProductType()); //need to have quantity remaining
        }

        }

    }

