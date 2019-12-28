//AUTHOR: Khalid Smalls
//COURSE: CPT187
//PURPOSE: SodNotZod sales program
//CREATEDATE: 10/25/1019


package edu.cpt187.smalls.participation;

import java.util.Scanner;

public class MainClass 
{
	public static final String MENU_CREATE_ORDER = "Create Order";
	public static final String MENU_QUIT = "Quit";


	public static void main(String[] args) 
	{	
		//instantiate Scanner 
		Scanner input = new Scanner(System.in);

		//Declare local variables
		String userName = "";
		char menuSelection = ' ';
		int currentHowMany = 0;


		//instantiate a sod order
		SodOrder currentOrder = new SodOrder();

		displayWelcomeBanner();
		userName = getUserName(input);
		menuSelection = validateMainSelection(input);

		while (menuSelection != 'Q') 
		{
			menuSelection = validateItemSelection(input, currentOrder.getItemNamePremium(), currentOrder.getItemPricePremium(),currentOrder.getItemNameSpecial(),
					currentOrder.getItemPriceSpecial(), currentOrder.getItemNameBasic(),currentOrder.getItemPriceBasic());
			currentOrder.setItemName(menuSelection);
			currentOrder.setItemPrice(menuSelection);
			currentHowMany = validateHowMany(input); 
			currentOrder.setHowMany(currentHowMany);
			menuSelection = validateDiscountSelection(input, currentOrder.getDiscountNameMember(), currentOrder.getDiscountNameSenior(),
					currentOrder.getDiscountNameNone(), currentOrder.getDiscountRateMember(), currentOrder.getDiscountRateSenior(),
					currentOrder.getDiscountRateNone());
			currentOrder.setDiscountRate(menuSelection);
			displayItemReceipt(userName, currentOrder.getItemName(), currentOrder.getItemPrice(), currentOrder.getHowMany(), currentOrder.getDiscountRate()
					,currentOrder.getDiscountAmt(), currentOrder.getDiscountPrice(), currentOrder.getSubTotal(), currentOrder.getTaxRate(),
					currentOrder.getTaxAmt(), currentOrder.getTotalCost());
			menuSelection = validateMainSelection(input);
		}//END of run while
		displayFarewell();
		input.close();
	}//END of main



	//VOID methods
	//display welcome banner
	public static void displayWelcomeBanner() 
	{
		System.out.printf("\n%s\n", "|*****************************************************|");
		System.out.println("|\t\tWELCOME TO SodNotZod                  |");
		System.out.printf("%s\n", "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("| This example sales program allows the employee to   |");
		System.out.println("| fullfill multiple orders of sod while keeping track |");
		System.out.println("| of sales and types of sod sold.                     |"); 
		System.out.printf("%s\n", "|*****************************************************|"); 
	}//end of display welcome banner



	//display farewell
	public static void displayFarewell() 
	{
		System.out.println("\n\n\t\tThank you for using this program.");
		System.out.println("\n\t\tHave a nice day!"); 
	}//end of display farewell

	public static void displayMainMenu() 
	{
		System.out.println("\n|********************************************|");
		System.out.println("|\t\tMAIN MENU                    |");
		System.out.printf("%s\n", "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|"); 
		System.out.printf("%s%-5s%s%28s\n","|", "[A]", MENU_CREATE_ORDER, "|");
		System.out.printf("%s%-5s%s%36s\n","|", "[Q]", MENU_QUIT, "|");
		System.out.printf("%s\n", "|********************************************|"); 
		System.out.print("Press 'A' to place an order (or 'Q' to quit): ");
	}//end of display main menu

	//display item menu
	public static void displayItemMenu(String borrowedItemNamePremium, double borrowedItemPricePremium, String borrowedItemNameSpecial, 
			double borrowedItemPriceSpecial, String borrowedItemNameBasic, double borrowedItemPriceBasic) 
	{
		System.out.printf("\n%s\n", "|****************************************************|");
		System.out.println("|\t\tSOD MENU                             |"); 
		System.out.printf("%s\n", "|****************************************************|"); 
		System.out.printf("%s%s%-24s%s%8.2f%s%10s\n", "|", "[A]", borrowedItemNamePremium, "$", borrowedItemPricePremium, "/sq.ft.", "|");
		System.out.printf("%s%s%-24s%s%8.2f%s%10s\n", "|", "[B]", borrowedItemNameSpecial, "$", borrowedItemPriceSpecial, "/sq.ft.", "|");
		System.out.printf("%s%s%-24s%s%8.2f%s%10s\n", "|", "[C]", borrowedItemNameBasic, "$", borrowedItemPriceBasic, "/sq.ft.", "|"); 
		System.out.printf("%s\n", "|****************************************************|"); 
		System.out.print("Select a menu option: ");
	}//end of display item menu

	//display discount menu
	public static void displayDiscountMenu(Scanner borrowedInput, String borrowedDiscountNameMember, String borrowedDiscountNameSenior, String borrowedDiscountNameNone,
			double borrowedDiscountRateMember, double borrowedDiscountRateSenior, double borrowedDiscountRateNone) 
	{
		System.out.println("\n|********************************************|");
		System.out.println("|\t\tDISCOUNT MENU                |");
		System.out.printf("%s\n", "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|"); 
		System.out.printf("%s%s%-30s%.0f%s%5s\n", "|", "[A]", borrowedDiscountNameMember, borrowedDiscountRateMember * 100, "% off", "|");
		System.out.printf("%s%s%-30s%.0f%s%5s\n", "|", "[B]", borrowedDiscountNameSenior, borrowedDiscountRateSenior * 100, "% off", "|");
		System.out.printf("%s%s%-30s%12s\n", "|", "[C]", borrowedDiscountNameNone, "|");   
		System.out.printf("%s\n", "|********************************************|"); 
		System.out.print("Select a menu option: ");
	}



	//display item receipt
	public static void displayItemReceipt(String userName, String borrowedItemName, double borrowedItemPrice, int borrowedHowMany,
			double borrowedDiscountRate, double borrowedDiscountAmt, double borrowedDiscountPrice, double borrowedSubTotal, double borrowedTaxRate,
			double borrowedTaxAmt, double borrowedTotalCost) 
	{
		System.out.printf("\n%s", "|****************************************************|");
		System.out.println("\n|\t\tITEM RECIEPT                         |");
		System.out.printf("%s\n", "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|"); 
		System.out.printf("%-2s%-20s%20s%12s\n", "|", "USER NAME:", userName, "|"); 
		System.out.printf("%-2s%-20s%20s%12s\n", "|", "ITEM NAME", borrowedItemName, "|"); 
		System.out.println("|----------------------------------------------------|");
		System.out.printf("%-2s%-20s%9s%8.2f%s%8s\n", "|",  "ITEM PRICE:", "$", borrowedItemPrice, "/sq.ft.", "|");
		System.out.printf("%-2s%-20s%9s%8.2f%s%8s\n", "|", "DISCOUNT PRICE:", "$", borrowedDiscountPrice, "/sq.ft.", "|");
		System.out.printf("%-2s%-20s%14d%18s\n", "|", "HOW MANY ITEMS:", borrowedHowMany, "|");
		System.out.println("|----------------------------------------------------|");
		System.out.printf("%-2s%-20s%9s%8.2f%15s\n", "|", "SUB TOTAL:", "$", borrowedSubTotal, "|"); 
		System.out.printf("%-2s%-20s%9s%8.2f%15s\n", "|", "TAX:", "$", borrowedTaxAmt, "|");
		System.out.printf("%-2s%-20s%9s%8.2f%15s\n", "|", "TOTAL COST:", "$", borrowedTotalCost, "|");
		System.out.printf("%s\n", "|****************************************************|");    

	}//end of display item receipt



	//VR methods
	//get user name
	public static String getUserName(Scanner borrowedInput) 
	{
		String localUserName = ""; 
		System.out.print("\nPlease enter your user name: "); 
		localUserName = borrowedInput.next(); 
		return localUserName; 
	}//end of get user name


	public static char validateMainSelection(Scanner borrowedInput) 
	{
		char localMainSelection = ' ';
		displayMainMenu();
		localMainSelection = borrowedInput.next().toUpperCase().charAt(0);
		while(localMainSelection != 'A' && localMainSelection != 'Q') 
		{
			System.out.println("\n\t***Invalid selection***\n");
			displayMainMenu();
			localMainSelection =  borrowedInput.next().toUpperCase().charAt(0);
		}
		return localMainSelection;
	}//END of validateMainSelection

	public static char validateItemSelection(Scanner borrowedInput, String borrowedItemNamePremium, double borrowedItemPricePremium, String borrowedItemNameSpecial, 
			double borrowedItemPriceSpecial, String borrowedItemNameBasic, double borrowedItemPriceBasic) 
	{
		char localItemSelection = ' '; 
		displayItemMenu(borrowedItemNamePremium, borrowedItemPricePremium, borrowedItemNameSpecial, 
				borrowedItemPriceSpecial, borrowedItemNameBasic, borrowedItemPriceBasic);
		localItemSelection = borrowedInput.next().toUpperCase().charAt(0); 

		while (localItemSelection != 'A' && localItemSelection != 'B' && localItemSelection != 'C') 
		{
			System.out.print("\n\t\t***Invalid Selection***\n");
			displayItemMenu(borrowedItemNamePremium, borrowedItemPricePremium, borrowedItemNameSpecial, 
					borrowedItemPriceSpecial, borrowedItemNameBasic, borrowedItemPriceBasic); 
			localItemSelection = borrowedInput.next().toUpperCase().charAt(0); 
		}
		return localItemSelection; 
	}//END of validateItemSelection


	//validate how many items
	public static int validateHowMany(Scanner borrowedInput) 
	{
		int localHowMany = 0; 
		System.out.print("\nPlease enter the number of items to be purchased: ");
		localHowMany = borrowedInput.nextInt(); 

		while (localHowMany <= 0) 
		{
			System.out.println("\n\t\t***Invalid entry***");
			System.out.print("Please enter the number of items to be purchased: ");
			localHowMany = borrowedInput.nextInt(); 
		}
		return localHowMany; 
	}//END of validateHowMany


	//validate discount selection
	public static char validateDiscountSelection(Scanner borrowedInput, String borrowedDiscountNameMember, String borrowedDiscountNameSenior, String borrowedDiscountNameNone,
			double borrowedDiscountRateMember, double borrowedDiscountRateSenior, double borrowedDiscountRateNone ) 
	{
		char localItemSelection = ' '; 
		displayDiscountMenu(borrowedInput, borrowedDiscountNameMember, borrowedDiscountNameSenior, borrowedDiscountNameNone, borrowedDiscountRateMember,
				borrowedDiscountRateSenior, borrowedDiscountRateNone);
		localItemSelection = borrowedInput.next().toUpperCase().charAt(0); 

		while (localItemSelection != 'A' && localItemSelection != 'B' && localItemSelection != 'C') 
		{
			System.out.print("\n\t\t***Invalid Selection***\n");
			displayDiscountMenu(borrowedInput, borrowedDiscountNameMember, borrowedDiscountNameSenior, borrowedDiscountNameNone, borrowedDiscountRateMember,
					borrowedDiscountRateSenior, borrowedDiscountRateNone); 
			localItemSelection = borrowedInput.next().toUpperCase().charAt(0); 
		}
		return localItemSelection; 
	}










}//END of class
