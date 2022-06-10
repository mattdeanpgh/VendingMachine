package com.techelevator;

import com.techelevator.*;
import com.techelevator.products.Products;
import com.techelevator.view.Menu;

import java.text.NumberFormat;
import java.util.ArrayList;
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

	private final Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS: {

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
				}

					break;
				case MAIN_MENU_OPTION_PURCHASE: {
//					Money current = new Money();

					System.out.println();
					System.out.print("Your current balance is: ");
						String purchaseChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					}
						break;
					case MAIN_MENU_OPTION_EXIT:
						System.exit(0);
				}
			}
		}
	}

