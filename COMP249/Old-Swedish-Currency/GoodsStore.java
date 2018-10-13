//-------------------------------------------------------
//Assignment (1)
//Written by: (Christopher McArthur 40004257)
//For COMP 249 Section (P) – Winter 2016
//--------------------------------------------------------
package A1;

import java.util.Scanner;

public class GoodsStore {
	public static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		HouseholdGoods[] hhgGoodsSold = new HouseholdGoods[100];
		System.out.println("------------------------------------------------------\n"
		+ "Welcome to Chris' Household Goods Store\n"
		+ "------------------------------------------------------\n");
		
		do
		{
			System.out.print(strMainMenu);
			int intChoice = keyboard.nextInt();
			switch(intChoice)
			{
			case 1:
				if(!PasswordCheck()) //get pw and validate over 3 tries
				{
					System.out.println("Wrong Password! Try again.");
					if(!PasswordCheck())
					{
						System.out.println("Wrong Password! Try again.");
						if(!PasswordCheck())
						{
							System.out.println("Wrong Password! No more Tries.\n\n\n");
							break;
						}
					}
				}
				
				if(!(hhgGoodsSold[99] == null)) //make sure array isnt full
				{
					System.out.println("Max number of items sold.");
					break;
				}
				
				//add item to array
				System.out.print("Adding new Item to sale list.\nWhate is the type of the item? (Electronics, Appliance, or Furniture)");
				String strType = keyboard.next();
				System.out.print("What is the description of " + strType + "?");
				String strDescript = keyboard.next();
				System.out.print("What is the price of " + strType + " in OldSweedishCurrency? (riksdalers skillings runstycken)");
				int risk = keyboard.nextInt();
				int skill = keyboard.nextInt();
				int runs = keyboard.nextInt();
				OldSweedCurrency oscPrice = new OldSweedCurrency(risk, skill, runs);
				hhgGoodsSold[HouseholdGoods.getGoodsCreated()] = new HouseholdGoods(strType, strDescript, oscPrice);
				System.out.print("Added " + strType + " to items sold at price " + oscPrice + ".");
				break;
			case 2:
				if(!PasswordCheck())
				{
					System.out.println("Wrong Password! Try again.");
					if(!PasswordCheck())
					{
						System.out.println("Wrong Password! Try again.");
						if(!PasswordCheck())
						{
							System.out.println("Wrong Password! No more Tries.\n\n\n");
							break;
						}
					}
				}
				
				System.out.println("Which good would you like to change? (index)");
				int intUserInputTwo = keyboard.nextInt();
				if(hhgGoodsSold[intUserInputTwo] == null)
				{
					System.out.println("No Household Good exists for that entry yet.\n\n\n");
					break;
				}
				else
				{
					boolean bolStopEditing = false;
					do
					{
						System.out.println("Good Sold: " + intUserInputTwo + "\n" + 
						hhgGoodsSold[intUserInputTwo] + "\n\n");
						int intMenuChoice;
						do
						{
							System.out.println(strAttribute);
							intMenuChoice = keyboard.nextInt();
						}while(intMenuChoice <= 0 && intMenuChoice > 5);
						
						switch(intMenuChoice)
						{				
						case 1: //type
							System.out.println("What is the new type? (Electronics, Appliance, or Furniture)");
							strType = keyboard.next();
							hhgGoodsSold[intUserInputTwo].setType(strType);
							break;
						case 2://description
							System.out.println("What is new description?");
							strDescript = keyboard.next();
							hhgGoodsSold[intUserInputTwo].setDescription(strDescript);
							break;
						case 3://price
							System.out.println("What is new price? (riksdalers skillings runstycken)");
							risk = keyboard.nextInt();
							skill = keyboard.nextInt();
							runs = keyboard.nextInt();
							oscPrice = new OldSweedCurrency(risk, skill, runs);
							hhgGoodsSold[intUserInputTwo].setPrice(oscPrice);
							break;
						case 4://quit
							bolStopEditing = true;
							break;
						default:
							System.out.println("Invalid input. Try again.");
						}
					}while(!bolStopEditing);
				}
				break;
			case 3:
				System.out.print("Which type do you want to look for?");
				strType = keyboard.next();
				for(int i = 0; i < HouseholdGoods.getGoodsCreated(); i += 1)
				{
					int intCounter = 0;
					
					if(hhgGoodsSold[i].getType().equals(strType))  
					{
						intCounter += 1;
						System.out.println("Good: " + i + "found.\n " + hhgGoodsSold[i]);
					}
					//at the end
					if(i == HouseholdGoods.getGoodsCreated())
					{
						if(intCounter == 0)
						{
							System.out.println("No items found.");
						}
						else 
						{
							System.out.println("Total items found: " + intCounter + ".");
						}
					}
				}
				break;
			case 4:
				System.out.print("Which price do you want to look below? (riksdalers skillings runstycken)");
				risk = keyboard.nextInt();
				skill = keyboard.nextInt();
				runs = keyboard.nextInt();
				oscPrice = new OldSweedCurrency(risk, skill, runs);
				for(int i = 0; i < HouseholdGoods.getGoodsCreated(); i += 1)
				{
					int intCounter = 0;
					
					if(hhgGoodsSold[i].getPrice().compareTo(oscPrice) == -1)  
					{
						intCounter += 1;
						System.out.println("Good: " + i + "found.\n " + hhgGoodsSold[i]);
					}
					//at the end
					if(i == HouseholdGoods.getGoodsCreated())
					{
						if(intCounter == 0)
						{
							System.out.println("No items found.");
						}
						else 
						{
							System.out.println("Total items found: " + intCounter + ".");
						}
					}
				}
				break;
			case 5: //information
					boolean bolStopStats = false;
					do
					{
						do
						{
							System.out.println(strStatsMenu);
							intChoice = keyboard.nextInt();
						}while(intChoice <= 0 && intChoice > 6);
						
						switch(intChoice)
						{
						case 1:
							int intCheapest = lowestPrice(hhgGoodsSold);
							System.out.println(hhgGoodsSold[intCheapest]);
							break;
						case 2:
							int intExpensive = highestPrice(hhgGoodsSold);
							System.out.println(hhgGoodsSold[intExpensive]);
							break;
						case 3:
							
							int intElec = 0, intAppli = 0, intFurn = 0;
							for(int i = 0; i < HouseholdGoods.getGoodsCreated(); i += 1)
							{
								if(hhgGoodsSold[i].getType().equals("Electronics"))
								{
									intElec += 1;
								}
								else if(hhgGoodsSold[i].getType().equals("Appliance"))
								{
									intAppli += 1;
								}
								else if(hhgGoodsSold[i].getType().equals("Furniture"))
								{
									intFurn += 1;
								}
							}
							System.out.println("Electronics sold: " + intElec +", Appliances sold: " + intAppli + ", Furniture sold: "+ intFurn);
							break;
						case 4:
							OldSweedCurrency oscSumCosts = new OldSweedCurrency();
							for(int i = 0; i < HouseholdGoods.getGoodsCreated(); i+=1)
							{
								oscSumCosts.add(hhgGoodsSold[i].getPrice());
							}
							OldSweedCurrency oscAvgCost = OldSweedCurrency.convertFromRunstycken(oscSumCosts.convertToRunstycken() / HouseholdGoods.getGoodsCreated());
							System.out.print("The average cost of household goods sold was: " + oscAvgCost);
							break;
						case 5:
							bolStopStats = true;
							break;
						default:
							System.out.println("Invalid input. Try again.");
						}
					}while(!bolStopStats);
				break;
			case 6:
				System.out.println("Thanks for using me =D !!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input. Try again.");
			}
		}while(true);
	}
	
	
	public static final String strMainMenu = "\n\nWhat would you like to do?\n"
		+ "1. Enter a new item in inventory (password required)\n"
		+ "2. Change information of an item in inventory (password required)\n"
		+ "3. Display all items of a specific type\n"
		+ "4. Display all items under a certain price\n"
		+ "5. Statistics on your inventory\n"
		+ "6. Quit\n"
		+ "Please enter your choice -->";
	
	public static final String strAttribute = "\n\nWhat would you like to change?\n"
			+ "1. Type\n"
			+ "2. Description\n"
			+ "3. Price\n"
			+ "4. Quit\n"
			+ "Enter choice -->";
	
	public static final String strStatsMenu = "\n\nWhat information would you like?\n"
			+ "1. Cost and details of cheapest item\n"
			+ "2. Cost and details of most costly item\n"
			+ "3. Number of items of a each type\n"
			+ "4. Average cost of items in inventory\n"
			+ "5. Quit\n"
			+ "Enter your choice >";
		
	public static boolean PasswordCheck()
	{
		String strPassword = "comp249";
		System.out.println("\nEnter your password: ");
		String strUserInput = keyboard.next();
			
		if(strUserInput.equals(strPassword))
			return true;
		else 
			return false;	
	}
		
	static public int lowestPrice(HouseholdGoods[] hhgSearch)
	{
		int intIndex = 0;
		for(int i = 1; i < HouseholdGoods.getGoodsCreated(); i += 1)
		{
			if(hhgSearch[i].getPrice().compareTo(hhgSearch[i-1].getPrice()) == -1)
			{
				intIndex = i;
			}
		}
		return intIndex;
	}
	
	static public int highestPrice(HouseholdGoods[] hhgSearch)
	{
		int intIndex = 0;
		for(int i = 1; i < HouseholdGoods.getGoodsCreated(); i += 1)
		{
			if(hhgSearch[i].getPrice().compareTo(hhgSearch[i-1].getPrice()) == 1)
			{
				intIndex = i;
			}
		}
		return intIndex;
	}
}
