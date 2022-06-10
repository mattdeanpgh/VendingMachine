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
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private final Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS: {

					Machine itemsPresent = new Machine();

					List<Products> listOfInventory = new ArrayList<>(itemsPresent.getItemsInMachine());


						 for (Products prod : listOfInventory) {
							NumberFormat formatter = NumberFormat.getCurrencyInstance();
							String moneyString = formatter.format(prod.getPrice());
							System.out.println(prod.getSlotNumber() + " | " + prod.getName() + " | " + moneyString + " | " + prod.getProductType());

							 System.out.println("Press enter to return to the main menu.");
								 return choice;

							 }

					}

				}
					break;
				case MAIN_MENU_OPTION_PURCHASE:
					break;
				case MAIN_MENU_OPTION_EXIT:
					System.exit(0);
			}
		}
	}
}
