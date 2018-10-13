package pizzaDealer;

public class Pizza {
	
	private String strPizzaSize;
	private int intCheeseToppings, intPepperoniToppings, intMushroomToppings;
	
	/**
	 * @return the chrPizzaSize
	 */
	public String getPizzaSize() {
		return strPizzaSize;
	}
	/**
	 * @param chrPizzaSize the chrPizzaSize to set
	 */
	public void setPizzaSize(String strPizzaSize) {
		this.strPizzaSize = strPizzaSize;
	}
	/**
	 * @return the intCheeseToppings
	 */
	public int getCheeseToppings() {
		return intCheeseToppings;
	}
	/**
	 * @param intCheeseToppings the intCheeseToppings to set
	 */
	public void setCheeseToppings(int intCheeseToppings) {
		this.intCheeseToppings = intCheeseToppings;
	}
	/**
	 * @return the intPepperoniToppings
	 */
	public int getPepperoniToppings() {
		return intPepperoniToppings;
	}
	/**
	 * @param intPepperoniToppings the intPepperoniToppings to set
	 */
	public void setPepperoniToppings(int intPepperoniToppings) {
		this.intPepperoniToppings = intPepperoniToppings;
	}
	/**
	 * @return the intMushroomToppings
	 */
	public int getMushroomToppings() {
		return intMushroomToppings;
	}
	/**
	 * @param intMushroomToppings the intMushroomToppings to set
	 */
	public void setMushroomToppings(int intMushroomToppings) {
		this.intMushroomToppings = intMushroomToppings;
	}
	
	//default initializer
	public Pizza(){
		strPizzaSize = "";
		intCheeseToppings =  0;
		intPepperoniToppings = 0;
		intMushroomToppings = 0;
	}
	
	//costume initializer
	public Pizza(String strPizzaSize, int intCheeseToppings, int intPepperoniToppings, int intMushroomToppings){
		this.strPizzaSize = strPizzaSize;
		this.intCheeseToppings =  intCheeseToppings;
		this.intPepperoniToppings = intPepperoniToppings;
		this.intMushroomToppings = intMushroomToppings;
	}

	@Override  //output pizza
	public String toString() {
		return "Pizza size is: " + strPizzaSize + ", Cheese Topping(s) = "
				+ intCheeseToppings + ", Pepperoni Topping(s) = "
				+ intPepperoniToppings + ", Mushroom Topping(s) = "
				+ intMushroomToppings + ", costs: $" + String.format("%.2f", calcCost(this));
	}
	
	//compare pizzas
	public boolean eqauls(Pizza pizzaComparable)
	{
		return (this.strPizzaSize == pizzaComparable.getPizzaSize() &&
		this.intCheeseToppings ==  pizzaComparable.getCheeseToppings() &&
		this.intPepperoniToppings == pizzaComparable.getCheeseToppings() &&
		this.intMushroomToppings == pizzaComparable.getMushroomToppings());
	}
	
	public double calcCost(Pizza pizzaCost)
	{
		double dblCost = 0;
		switch(pizzaCost.getPizzaSize())
		{
		case "small":
			dblCost = 10.00 + 2.00*(pizzaCost.getCheeseToppings() + pizzaCost.getMushroomToppings() + pizzaCost.getPepperoniToppings());
			break;
		case "medium":
			dblCost = 12.00 + 2.25*(pizzaCost.getCheeseToppings() + pizzaCost.getMushroomToppings() + pizzaCost.getPepperoniToppings());
			break;
		case "large":
			dblCost = 14.00 + 2.50*(pizzaCost.getCheeseToppings() + pizzaCost.getMushroomToppings() + pizzaCost.getPepperoniToppings());
			break;
		}
		return dblCost;
	}
}
