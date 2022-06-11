package com.techelevator;

import com.techelevator.*;
import com.techelevator.products.Products;
import com.techelevator.view.Menu;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String SUB_MENU_SELECT_PRODUCT = "Select Product";
    private static final String SUB_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_SELECT_PRODUCT, SUB_MENU_FINISH_TRANSACTION};
    Scanner scanner = new Scanner(System.in);

    private final Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            switch (choice) {
                case MAIN_MENU_OPTION_DISPLAY_ITEMS:

                    try {

                        Machine itemsPresent = new Machine();
                        List<Products> listOfInventory = new ArrayList<>(itemsPresent.getItemsInMachine());

                        for (Products prod : listOfInventory) {
                            NumberFormat formatter = NumberFormat.getCurrencyInstance();
                            String moneyString = formatter.format(prod.getPrice());
                            System.out.println(prod.getSlotNumber() + " | " + prod.getName() + " | " + moneyString + " | " + prod.getProductType());

                            menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);


                        }


                    } catch (NullPointerException e) {
                        System.out.println(" ");

                    }


                    break;

                case MAIN_MENU_OPTION_PURCHASE:
                    try {
                        Money current = new Money();
                        double displayCurrent = current.getCurrentMoney();
                        NumberFormat formatter = NumberFormat.getCurrencyInstance();
                        String moneyString = formatter.format(displayCurrent);


                        System.out.println();
                        System.out.print("Your current balance is: " + moneyString);
                        String purchaseChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

                        switch (purchaseChoice) {
                            case SUB_MENU_OPTION_FEED_MONEY: {
                                System.out.println("Please add your money by entering in values of $1, $2, $5, or $10:");
                                String userInput = scanner.nextLine();
                                double moneyPutIn = Double.parseDouble(userInput);

                            }
                            break;

                            case SUB_MENU_SELECT_PRODUCT: {
                                boolean stayInMenu = true;

                                Machine itemsPresent = new Machine();
                                List<Products> listOfInventory = new ArrayList<>(itemsPresent.getItemsInMachine());
                                for (Products prod : listOfInventory) {
                                    System.out.println(prod.getSlotNumber() + " | " + prod.getName() + " | " + moneyString + " | " + prod.getProductType());
                                }
                                while (stayInMenu) {
                                    System.out.println("Please enter the product code: ");
                                    String choiceInput = scanner.nextLine();
                                    for (Products prod : listOfInventory) {
                                        if (prod.getSlotNumber().toUpperCase().equals(choiceInput)) {
                                            String productChoice = prod.getSlotNumber();
                                            double productCost = Double.parseDouble(moneyString);

                                        }
                                        if (prod.getProductType().equals("Chip"));
                                            System.out.println("Crunch Crunch, Yum!" + " Enjoy!");
                                        if (prod.getProductType().equals("Drink"));
                                        System.out.println("Glug Glug, Yum!" + " Enjoy!");
                                        if (prod.getProductType().equals("Candy"));
                                        System.out.println(prod.getProductType().equals("Candy"));
                                        System.out.println("Munch Munch, Yum!" + " Enjoy!");
                                    }
                                }
                                stayInMenu = false;
                            }
                            break;

                            case SUB_MENU_FINISH_TRANSACTION: {

                            }
                            break;
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Not a Valid Choice.");
                    }


                    break;

                case MAIN_MENU_OPTION_EXIT:
                    System.exit(0);

            }
        }
    }
}


//create a new instance of machine
//having items present, you can get those items from that class