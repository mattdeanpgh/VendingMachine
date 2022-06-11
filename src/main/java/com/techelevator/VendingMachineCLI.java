package com.techelevator;

import com.techelevator.*;
import com.techelevator.products.Chips;
import com.techelevator.products.Products;
import com.techelevator.view.Menu;

import java.awt.*;
import java.io.*;
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
                        System.out.println();
                        Machine itemsPresent = new Machine();

                        for (Products prod : itemsPresent.getItemsInMachine()) {
                            NumberFormat formatter = NumberFormat.getCurrencyInstance();
                            String moneyString = formatter.format(prod.getPrice());
                            System.out.println(prod.getSlotNumber() + " | " + prod.getName() + " | " + moneyString + " | " + prod.getProductType() + " | " + prod.getInventoryCount() + " remaining.");

//                                menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
                        }


                    } catch (NullPointerException e) {
                        System.out.println(" ");

                    }


                    break;

                case MAIN_MENU_OPTION_PURCHASE:


                    try {
                        File log = new File("Log.txt");
                        Date dateFormatted = new Date();


                        boolean x = true;
                        while (x) {

                            NumberFormat formatter = NumberFormat.getCurrencyInstance();
                            String balanceMoney = formatter.format(displayCurrent);

                            System.out.println();
                            System.out.print("Your current balance is: " + balanceMoney);
                            System.out.println();
                            String purchaseChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);


                            switch (purchaseChoice) {

                                case SUB_MENU_OPTION_FEED_MONEY: {
                                    System.out.println();
                                    System.out.print("Please add your money by entering in values of $1, $2, $5, or $10: ");
                                    String userInput = scanner.nextLine();
                                    double moneyPutIn = Double.parseDouble(userInput);
                                    Money moneyInserted = new Money(displayCurrent, moneyPutIn);
                                    double moneyInMachine = moneyInserted.getFeedMoney();
                                    displayCurrent += moneyInMachine;

                                    if (moneyPutIn > 0) {


                                        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
                                            writer.println("Date " + "Time" + " FEED MONEY " + moneyPutIn + " " + displayCurrent);


                                        } catch (FileNotFoundException e) {
                                            System.out.println("File Not Found");

//                                    System.out.println("Your current balance is " + displayCurrent);

//                                    menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

                                        }
                                    }
                                }
                                break;

                                case SUB_MENU_SELECT_PRODUCT: {
//                                    boolean stayInMenu = true;
                                    System.out.println();
                                    Machine itemsPresent = new Machine();
                                    List<Products> listOfInventory = new ArrayList<>(itemsPresent.getItemsInMachine());
                                    for (Products prod : listOfInventory) {
                                        NumberFormat format = NumberFormat.getCurrencyInstance();
                                        String moneyString = format.format(prod.getPrice());
                                        System.out.println(prod.getSlotNumber() + " | " + prod.getName() + " | " + moneyString + " | " + prod.getProductType() + " | " + prod.getInventoryCount() + " remaining.");
                                    }
                                    System.out.println();
                                    System.out.print("Please enter the product code: ");
                                    String choiceInput = scanner.nextLine();
                                    for (Products prod : listOfInventory) {
                                        if (prod.getSlotNumber().toUpperCase().contains(choiceInput.toUpperCase())) {

                                        }
//                                            balanceMoney = current.getFeedMoney() - prod.getPrice();
//                                        displayCurrent =
//
//                                        if (prod.getProductType().equals("Chip")) ;
//                                        System.out.println(Chips.bought);
//                                        if (prod.getProductType().equals("Drink")) ;
//                                        System.out.println("Glug Glug, Yum!" + " Enjoy!");
//                                        if (prod.getProductType().equals("Candy")) ;
//                                        System.out.println(prod.getProductType().equals("Candy"));
//                                        System.out.println("Munch Munch, Yum!" + " Enjoy!");
                                    }
//                                    while (stayInMenu) {
//                                        String userInput = scanner.nextLine();
//                                        double moneySpent =
//                                    }
                                }
//                                        stayInMenu = false; I think the boolean statement at the top of the try block will apply to all of these menus so this probably isn't needed
//                                menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

                                break;


                                case SUB_MENU_FINISH_TRANSACTION: {

                                    //Write transaction to file
                                    x = false;
                                }

                            }
                        }


                        break;


//                                default:
//                                    throw new IllegalStateException("Unexpected value: " + purchaseChoice);


                    } catch (NullPointerException e) {
                        System.out.println("Not a Valid Choice.");
                    }

                case MAIN_MENU_OPTION_EXIT:
                    System.exit(0);

            }

        }
    }
}


//create a new instance of machine
//having items present, you can get those items from that class