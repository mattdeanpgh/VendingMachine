package com.techelevator;

import com.techelevator.*;
import com.techelevator.products.Chips;
import com.techelevator.products.Products;
import com.techelevator.view.Menu;

import java.awt.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

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
            int currentInventory = 5;

            switch (choice) {
                case MAIN_MENU_OPTION_DISPLAY_ITEMS:

                    try {
                        System.out.println();
                        Machine itemsPresent = new Machine();

                        for (Products prod : itemsPresent.getItemsInMachine()) {
                            NumberFormat formatter = NumberFormat.getCurrencyInstance();
                            String moneyString = formatter.format(prod.getPrice());
                            System.out.println(prod.getSlotNumber() + " | " + prod.getName() + " | " + moneyString + " | " + prod.getProductType() + " | " + prod.getInventoryCount() + " remaining.");

                        }


                    } catch (NullPointerException e) {
                        System.out.println(" ");

                    }


                    break;

                case MAIN_MENU_OPTION_PURCHASE:


                    try {
                        File log = new File("Log.txt");


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
//                                    moneyInserted.moneyInsert();

                                    if (!moneyInserted.moneyInsert()) {
                                        System.out.println("Invalid amount.");
                                    } else {
                                        displayCurrent += moneyInMachine;
                                    }


                                    {

                                        Date date = new Date();


                                        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
                                            NumberFormat format = NumberFormat.getCurrencyInstance();
                                            String feedMoney = format.format(moneyPutIn);
                                            NumberFormat.getCurrencyInstance();
                                            String totalMoney = format.format(displayCurrent);
                                            writer.println(">" + date.getFormattedDate() + " FEED MONEY " + feedMoney + " " + totalMoney);


                                        } catch (FileNotFoundException e) {
                                            System.out.println("File Not Found");

                                        }
                                    }

                                }
                                break;

                                case SUB_MENU_SELECT_PRODUCT: {
                                    System.out.println();
                                    System.out.print("Your current balance is: " + balanceMoney);
                                    System.out.println();
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
                                        if (choiceInput.equals(prod.getSlotNumber()) && prod.getPrice() <= displayCurrent) {
                                            System.out.println("Here is your " + prod.getName() + ". Enjoy!");
                                            System.out.println(prod.boughtIt());
                                            displayCurrent = displayCurrent - prod.getPrice();
                                            prod.reduceInventory();
                                            System.out.println("There are " + prod.getInventoryCount() + " left.");
//                                            for (Products xyz : itemsPresent.getItemsInMachine()) {
//                                                if (prod.getName().equals(xyz.getName())) {
//                                                    xyz.reduceInventory();
//                                                    System.out.println("There are " + xyz.getInventoryCount() + " left.");
//                                                }

                                        }

                                        Date date = new Date();
                                        for (Products xyz : itemsPresent.getItemsInMachine()) {
                                            if (prod.getName().equals(xyz.getName())) {
                                                xyz.reduceInventory();
                                            }

                                        }

                                        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
                                            NumberFormat format = NumberFormat.getCurrencyInstance();
                                            String moneyBefore = format.format(displayCurrent + prod.getPrice());
                                            NumberFormat.getCurrencyInstance();
                                            String moneyAfter = format.format(displayCurrent);
                                            writer.println(">" + date.getFormattedDate() + " " + prod.getName() + " " + prod.getSlotNumber() + " " + moneyBefore + " " + moneyAfter);


                                        } catch (FileNotFoundException e) {
                                            System.out.println("File Not Found");


                                        }

                                    }
                                }


                                break;

                                case SUB_MENU_FINISH_TRANSACTION: {

                                    Money change = new Money(displayCurrent, currentInventory);

                                    change.makePurchaseReturnChange();
                                    {
                                        Date date = new Date();
                                        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {
                                            NumberFormat format = NumberFormat.getCurrencyInstance();
                                            String changeDue = format.format(displayCurrent);
                                            NumberFormat.getCurrencyInstance();
                                            String noneLeft = format.format(0.0);
                                            writer.println(">" + date.getFormattedDate() + " " + "GIVE CHANGE" + " " + changeDue + " " + noneLeft);

                                        } catch (FileNotFoundException e) {
                                            System.out.println("File Not Found");
                                        }
                                    }
                                    x = false;
                                }
                            }
                        }

                        break;

                    } catch (NullPointerException e) {
                        System.out.println("Not a Valid Choice.");
                    }

                case MAIN_MENU_OPTION_EXIT:
                    System.exit(0);

            }

        }
    }
}
