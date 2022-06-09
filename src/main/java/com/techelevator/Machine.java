package com.techelevator;

import com.techelevator.products.Products;

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

                            Products newProduct = new Products(productLocation, productName, productCost, productType ); {
                                newProduct.setName(productName);
                                itemsInMachine.add(newProduct);
                        }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        for (Products prod : itemsInMachine) {

            System.out.println(prod.getName() + " " + prod.getPrice() + " " + prod.getProductType());

        }

    }
}