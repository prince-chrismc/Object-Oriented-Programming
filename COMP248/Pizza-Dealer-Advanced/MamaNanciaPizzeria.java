import java.util.Scanner;

public class MamaNanciaPizzeria 
{
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) 
	{
		
		int intMaxNumberOfPizzas, intMainMenuChoice;
		
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" + 
		"     Welcome to  Mama Nancia‘s Pizzeria\n" + 
				"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
		 
		System.out.println("Bonjourno Mama Nancia!\n" +
		"Whats the maximum number of pizza you can make today? ");
		
		intMaxNumberOfPizzas = keyboard.nextInt();
		DeluxePizza[] todaysPizzas = new DeluxePizza[intMaxNumberOfPizzas];
		
		do
		{
			do
			{
				System.out.println("\n\n" + strMenu);
				intMainMenuChoice = keyboard.nextInt();
				System.out.println(" --> " + intMainMenuChoice + " <--");
			}while(intMainMenuChoice <= 0 && intMainMenuChoice > 5);
			
			switch(intMainMenuChoice)
			{
			case 1: 
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
				
				System.out.println("How many pizza's would you like to add? ");
				int intUserInput = keyboard.nextInt();
				if(intUserInput > todaysPizzas.length - DeluxePizza.getNumberOfPizzas())
				{
					System.out.println("You do not have enough ingredients! Limiting your"
							+ " selection to " + (todaysPizzas.length - DeluxePizza.getNumberOfPizzas()) + ".");
					intUserInput = todaysPizzas.length - DeluxePizza.getNumberOfPizzas();			
				}
				
				for(int x = DeluxePizza.getNumberOfPizzas(); x < intUserInput; x +=1)
				{
					String strSize;
					int intPep, intCheese, intMushroom, intVeggie;
					boolean bolStuffed;
					
					System.out.println("What size? (s/m/l) ");
					strSize = keyboard.next();
					System.out.println("how much Cheese? (#) ");
					intCheese = keyboard.nextInt();
					System.out.println("How much Pepperoni? (#) ");
					intPep = keyboard.nextInt();
					System.out.println("How much Mushrooms? (#) ");
					intMushroom = keyboard.nextInt();
					System.out.println("How much Veggies? (#) ");
					intVeggie = keyboard.nextInt();
					System.out.println("With stuffed crust? (true/false) ");
					bolStuffed = keyboard.nextBoolean();
					
					todaysPizzas[x] = new DeluxePizza(strSize,intCheese,intPep,intMushroom,intVeggie,bolStuffed);
				}
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
				
				System.out.println("Which pizza would you like to change? (index)");
				int intUserInputTwo = keyboard.nextInt();
				if(todaysPizzas[intUserInputTwo] == null)
				{
					System.out.println("No Pizza Exists for that entry yet.\n\n\n");
					break;
				}
				else
				{
					boolean bolStopEditing = false;
					do
					{
						System.out.println("Pizza: " + intUserInputTwo + "\n" + 
								todaysPizzas[intUserInputTwo] + "\n\n");
						do
						{
							System.out.println(strAttribute);
							intMainMenuChoice = keyboard.nextInt();
						}while(intMainMenuChoice <= 0 && intMainMenuChoice > 7);
						
						String strSize;
						int intPep, intCheese, intMushroom, intVeggie;
						boolean bolStuffed;
						switch(intMainMenuChoice)
						{				
						case 1: // size
							System.out.println("What is the new size? (s/m/l) ");
							strSize = keyboard.next();
							todaysPizzas[intUserInputTwo].setPizzaSize(strSize);
							break;
						case 2://stuffed
							System.out.println("With stuffed crust? (0/1) ");
							bolStuffed = keyboard.nextBoolean();
							todaysPizzas[intUserInputTwo].setStuffedCrust(bolStuffed);
							break;
						case 3://cheese
							System.out.println("how much Cheese? (#) ");
							intCheese = keyboard.nextInt();
							todaysPizzas[intUserInputTwo].setCheeseToppings(intCheese);
							break;
						case 4://pep
							System.out.println("How much Pepperoni? (#) ");
							intPep = keyboard.nextInt();
							todaysPizzas[intUserInputTwo].setPepperoniToppings(intPep);
							break;
						case 5://much
							System.out.println("How much Mushrooms? (#) ");
							intMushroom = keyboard.nextInt();
							todaysPizzas[intUserInputTwo].setMushroomToppings(intMushroom);
							break;
						case 6://veggie
							System.out.println("How much Veggies? (#) ");
							intVeggie = keyboard.nextInt();
							todaysPizzas[intUserInputTwo].setVeggieToppings(intVeggie);
							break;
						case 7://quit
							bolStopEditing = true;
							break;
						}
					}while(!bolStopEditing);
				}			
				break;
			case 3://of size
				System.out.println("What pizza size do you want to search for? (s/m/l)");
				String strSize = keyboard.next();
				pizzasOfSize(strSize, todaysPizzas);
				break;
			case 4: //information
				boolean bolStopStats = false;
				do
				{
					do
					{
						System.out.println(strStatistics);
						intMainMenuChoice = keyboard.nextInt();
					}while(intMainMenuChoice <= 0 && intMainMenuChoice > 6);
					
					switch(intMainMenuChoice)
					{
					case 1:
						int intCheapest = lowestPrice(todaysPizzas);
						System.out.println(todaysPizzas[intCheapest]);
						break;
					case 2:
						int intExpensive = lowestPrice(todaysPizzas);
						System.out.println(todaysPizzas[intExpensive]);
						break;
					case 3:
						System.out.println("The number of pizzas sold today is: " + DeluxePizza.getNumberOfPizzas());
						break;
					case 4:
						System.out.print("What are are you looking for? (s/m/l)");
						strSize = keyboard.next();
						int intPizzasOfSize = numberOfPizzasOfSize(strSize, todaysPizzas);
						System.out.println("There are " + intPizzasOfSize + " of size " + strSize + ".");
						break;
					case 5:
						int intSumCosts = 0;
						for(int x = 0; x < DeluxePizza.getNumberOfPizzas()-1; x+=1)
						{
							intSumCosts += todaysPizzas[x].calcCost(todaysPizzas[x]);
						}
						int intAvgCost = intSumCosts / DeluxePizza.getNumberOfPizzas();
						System.out.printf("The average cost of a pizza is $%.2f.%n", intAvgCost);
						break;
					case 6:
						bolStopStats = true;
						break;							
					}
				}while(!bolStopStats);
				break;
			case 5:
				System.out.println("Good bye, is was a pleasure to have you use me!");
				System.exit(0);
				break;
			}
		}while(true);
	}

	static final public String strMenu = "Mama Nancia, what do you want to do?\n" +
			"  1. Enter a new pizza order (password required)\n" +
			"  2. Change information of a specific order (password required)\n" +
			"  3. Display details for all pizzas of a specific size (s/m/l)\n" +
			"  4. Statistics on today’s pizzas\n" +
			"  5. Quit\n" +
			"Please enter your choice: ";
	
	static final public String strAttribute =  "Mama Nancia, what would you like to change?\n" +
			"  1. Size\n" +
			"  2. Cheese filled or not\n" +
			"  3. Number of cheese toppings\n" +
			"  4. Number of pepperoni toppings\n" +
			"  5. Number of mushroom toppings\n" +
			"  6. Number of vegetable toppings\n" +
			"  7. Quit\n" +
			"Enter choice: ";
	static final public String strStatistics = "Mama Nancia, what information would you like?\n" +
			"1. Cost and details of cheapest pizza\n" +
			"2. Cost and details of most costly pizza\n" +
			"3. Number of pizzas sold today\n" +
			"4. Number of pizzas of a specific size\n" +
			"5. Average cost of pizzas\n" +
			"6. Quit\n" +
			"Enter your choice >";

	static public boolean PasswordCheck()
	{
		String strPassword = "deluxepizza";
		System.out.println("\nEnter your password: ");
		String strUserInput = keyboard.next();
		
		if(strUserInput.equals(strPassword))
			return true;
		else 
			return false;	
	}
	
	static public void pizzasOfSize(String strSize, DeluxePizza[] pizzaSearch)
	{
		int counter=0;
		for(int x = 0; x < DeluxePizza.getNumberOfPizzas(); x += 1)
		{
			if(pizzaSearch[x].getPizzaSize().equals(strSize))
			{
				counter+=1;
				System.out.println("Pizza " + x + "\n" + pizzaSearch[x]);
			}
		}
		System.out.println("There are " + counter + " pizzas of size " + strSize + ".");
	}
	
	static public void cheaperThan(double dblCheaper, DeluxePizza[] pizzaSearch)
	{
		System.out.printf("The pizzas less than $%.2f are: ", dblCheaper);
		for(int x = 0; x < DeluxePizza.getNumberOfPizzas(); x += 1)
		{
			if(pizzaSearch[x].calcCost(pizzaSearch[x]) < dblCheaper)
			{
				System.out.print(" " + x);
			}
		}
		System.out.println();
	}
	
	static public int lowestPrice(DeluxePizza[] pizzaSearch)
	{
		int intIndex = 0;
		for(int x = 1; x < DeluxePizza.getNumberOfPizzas(); x += 1)
		{
			if(pizzaSearch[x].calcCost(pizzaSearch[x]) < pizzaSearch[intIndex].calcCost(pizzaSearch[intIndex]))
			{
				intIndex = x;
			}
		}
		return intIndex;
	}
	
	static public int highestPrice(DeluxePizza[] pizzaSearch)
	{
		int intIndex = 0;
		for(int x = 1; x < DeluxePizza.getNumberOfPizzas(); x += 1)
		{
			if(pizzaSearch[x].calcCost(pizzaSearch[x]) > pizzaSearch[intIndex].calcCost(pizzaSearch[intIndex]))
			{
				intIndex = x;
			}
		}
		return intIndex;
}
	
	static public int numberOfPizzasOfSize(String strSize, DeluxePizza[] pizzaSearch)
	{
		int counter=0;
		for(int x = 0; x < DeluxePizza.getNumberOfPizzas(); x += 1)
		{
			if(pizzaSearch[x].getPizzaSize().equals(strSize))
			{
				counter+=1;
			}
		}
		return counter;
	}
}

