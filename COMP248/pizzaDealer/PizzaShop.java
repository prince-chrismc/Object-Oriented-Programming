package pizzaDealer;
import java.util.Scanner;
//-------------------------------------------------------	
//Assignment 3
//Written by: Christopher McArthur 40004257
//For COMP 248 Section EEEC – Fall 2015
//--------------------------------------------------------
public class PizzaShop {
	
	public static void main(String[] args) {
		System.out.println("---------------------------------------------------------\n" +
				   "           Chris' Homestlye PizzaShop Program\n" +
				   "---------------------------------------------------------\n\n");
		Scanner keyboard = new Scanner(System.in);
		Pizza pizzaOne = new Pizza(); //deafult pizza
		System.out.println("Pizza one set to default, no size no toppings");
		
		System.out.print("What size of pizza would you like? (s/m/l) ");
		String strUserInput = keyboard.nextLine();
		System.out.print("How many cheese, pepperoni, and mushrooom toopings would you like? (# # #)");
		int intUserCheeseToppings = keyboard.nextInt();
		int intUserPepperoniToppings = keyboard.nextInt();
		int intUserMushroomToppings = keyboard.nextInt();
		Pizza pizzaTwo = new Pizza(strUserInput, intUserCheeseToppings, intUserPepperoniToppings, intUserMushroomToppings);
		
		//keyboard.next();
		System.out.print("What size of pizza would you like? (s/m/l) ");
		String strUserInputTwo = keyboard.next();
		System.out.print("How many cheese, pepperoni, and mushrooom toopings would you like? (# # #)");
		intUserCheeseToppings = keyboard.nextInt();
		intUserPepperoniToppings = keyboard.nextInt();
		intUserMushroomToppings = keyboard.nextInt();
		Pizza pizzaThree = new Pizza(strUserInputTwo, intUserCheeseToppings, intUserPepperoniToppings, intUserMushroomToppings);
		
		System.out.println("\nHere are your three pizzas:\nPizzaOne: " + pizzaOne.toString() + "\nPizzaTwo: " + pizzaTwo.toString() +
				"\nPizzaThree: " + pizzaThree.toString() + "\n");
		
		System.out.println("Pizza Comparison: ");
		if(pizzaOne.eqauls(pizzaTwo) && pizzaOne.eqauls(pizzaThree))
		{
			System.out.println("All three pizzas are the same!");
		}
		else if(pizzaOne.eqauls(pizzaTwo))
		{
			System.out.println("Pizzas one and two are the same!");
		}
		else if(pizzaOne.equals(pizzaThree))
		{
			System.out.println("Pizzas one and three are the same!");
		}
		else if(pizzaTwo.eqauls(pizzaThree))
		{
			System.out.println("Pizzas two and three are the same!");
		}
		else
		{
			System.out.println("no pizza are the same");
		}
		
		pizzaOne = pizzaTwo;
		System.out.println("Pizza Comparison with pizza two set to pizza 1: ");
		if(pizzaOne.eqauls(pizzaTwo) && pizzaOne.eqauls(pizzaThree))
		{
			System.out.println("All three pizzas are the same!");
		}
		else if(pizzaOne.eqauls(pizzaTwo))
		{
			System.out.println("Pizzas one and two are the same!");
		}
		else if(pizzaOne.equals(pizzaThree))
		{
			System.out.println("Pizzas one and three are the same!");
		}
		else if(pizzaTwo.eqauls(pizzaThree))
		{
			System.out.println("Pizzas two and three are the same!");
		}
		else
		{
			System.out.println("no pizza are the same");
		}
	}

}
