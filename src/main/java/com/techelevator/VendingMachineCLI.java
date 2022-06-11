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
            Money current = new Money();
            double displayCurrent = current.getCurrentMoney();

            switch (choice) {
                case MAIN_MENU_OPTION_DISPLAY_ITEMS:

                    try {

                        Machine itemsPresent = new Machine();

                        for (Products prod : itemsPresent.getItemsInMachine()) {
                                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                                String moneyString = formatter.format(prod.getPrice());
                                System.out.println(prod.getSlotNumber() + " | " + prod.getName() + " | " + moneyString + " | " + prod.getProductType());

//                                menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
                            }


                    } catch (NullPointerException e) {
                        System.out.println(" ");

                    }


                    break;

                case MAIN_MENU_OPTION_PURCHASE:


                    try {

                        boolean x = true;
                        while (x) {

                            NumberFormat formatter = NumberFormat.getCurrencyInstance();
                            String moneyString = formatter.format(displayCurrent);

                        switch (purchaseChoice) {
                            case SUB_MENU_OPTION_FEED_MONEY: {
                                System.out.println("Please add your money by entering in values of $1, $2, $5, or $10:");
                                String userInput = scanner.nextLine();
                                double moneyPutIn = Double.parseDouble(userInput);

                            System.out.println();
                            System.out.print("Your current balance is: " + moneyString);
                            String purchaseChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

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

                            switch (purchaseChoice) {

                                case SUB_MENU_OPTION_FEED_MONEY: {


                                    System.out.print("Please add your money by entering in values of $1, $2, $5, or $10: ");
                                    String userInput = scanner.nextLine();
                                    double moneyPutIn = Double.parseDouble(userInput);
                                    Money moneyInserted = new Money(displayCurrent, moneyPutIn);
                                    double moneyInMachine = moneyInserted.getFeedMoney();
                                    displayCurrent += moneyInMachine;

                                    System.out.println("Your current balance is " + displayCurrent);

                                    menu.getChoiceFromOptions(SUB_MENU_OPTIONS);


                                }

                                break;


                                case SUB_MENU_SELECT_PRODUCT: {
                                }
                                break;

                                case SUB_MENU_FINISH_TRANSACTION: {
                                    //Write transaction to file
                                    x = false;

                                }
                                break;


                            }
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