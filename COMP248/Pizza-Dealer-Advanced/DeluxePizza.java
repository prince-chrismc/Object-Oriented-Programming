public class DeluxePizza 
{
	static private int intNumberOfPizzas = 0;
	private String strPizzaSize;
	private int intCheeseToppings, intPepperoniToppings, intMushroomToppings, 
	intVeggieToppings;
	private boolean bolStuffedCrust;
	
	//default initializer
	public DeluxePizza()
	{
		intNumberOfPizzas += 1;
		strPizzaSize = "";
		intCheeseToppings =  0;
		intPepperoniToppings = 0;
		intMushroomToppings = 0;
		intVeggieToppings = 0;
		bolStuffedCrust = false;
	}
		
	//costume initializer
	public DeluxePizza(String strPizzaSize, int intCheeseToppings, 
			int intPepperoniToppings, int intMushroomToppings, int intVeggieToppings,
			boolean bolStuffedCrust)
	{
		intNumberOfPizzas += 1;
		this.strPizzaSize = strPizzaSize;
		this.intCheeseToppings =  intCheeseToppings;
		this.intPepperoniToppings = intPepperoniToppings;
		this.intMushroomToppings = intMushroomToppings;
		this.intVeggieToppings = intVeggieToppings;
		this.bolStuffedCrust = bolStuffedCrust;
	}
	
	public DeluxePizza(DeluxePizza pizzaCopyable)
	{
		intNumberOfPizzas += 1;
		this.strPizzaSize = pizzaCopyable.getPizzaSize();
		this.intCheeseToppings =  pizzaCopyable.getCheeseToppings();
		this.intPepperoniToppings = pizzaCopyable.getPepperoniToppings();
		this.intMushroomToppings = pizzaCopyable.getMushroomToppings();
		this.intVeggieToppings = pizzaCopyable.getVeggieToppings();
		this.bolStuffedCrust = pizzaCopyable.isStuffedCrust();
	}

	public static int getNumberOfPizzas() {
		return intNumberOfPizzas;
	}

	public String getPizzaSize() {
		return strPizzaSize;
	}

	public void setPizzaSize(String strPizzaSize) {
		this.strPizzaSize = strPizzaSize;
	}

	public int getCheeseToppings() {
		return intCheeseToppings;
	}

	public void setCheeseToppings(int intCheeseToppings) {
		this.intCheeseToppings = intCheeseToppings;
	}

	public int getPepperoniToppings() {
		return intPepperoniToppings;
	}

	public void setPepperoniToppings(int intPepperoniToppings) {
		this.intPepperoniToppings = intPepperoniToppings;
	}

	public int getMushroomToppings() {
		return intMushroomToppings;
	}

	public void setMushroomToppings(int intMushroomToppings) {
		this.intMushroomToppings = intMushroomToppings;
	}

	public int getVeggieToppings() {
		return intVeggieToppings;
	}

	public void setVeggieToppings(int intVeggieToppings) {
		this.intVeggieToppings = intVeggieToppings;
	}

	public boolean isStuffedCrust() {
		return bolStuffedCrust;
	}

	public void setStuffedCrust(boolean bolStuffedCrust) {
		this.bolStuffedCrust = bolStuffedCrust;
	}
	
	public double calcCost(DeluxePizza pizzaCost)
	{
		double dblCost = 0;
		switch(pizzaCost.getPizzaSize())
		{
		case "s":
			dblCost = 10.00 + 2.00*(pizzaCost.getCheeseToppings() + pizzaCost.getMushroomToppings() + pizzaCost.getPepperoniToppings()) + 3.00*pizzaCost.getVeggieToppings();
			if(pizzaCost.isStuffedCrust()) dblCost += 2.00;
			break;
		case "m":
			dblCost = 12.00 + 2.25*(pizzaCost.getCheeseToppings() + pizzaCost.getMushroomToppings() + pizzaCost.getPepperoniToppings()) + 3.00*pizzaCost.getVeggieToppings();
			if(pizzaCost.isStuffedCrust()) dblCost += 2.00;
			break;
		case "l":
			dblCost = 14.00 + 2.50*(pizzaCost.getCheeseToppings() + pizzaCost.getMushroomToppings() + pizzaCost.getPepperoniToppings()) + 3.00*pizzaCost.getVeggieToppings();
			if(pizzaCost.isStuffedCrust()) dblCost += 2.00;
			break;
		}
		return dblCost;
	}

	public boolean equals(DeluxePizza other) {
		if (bolStuffedCrust != other.bolStuffedCrust)
			return false;
		if (intCheeseToppings != other.intCheeseToppings)
			return false;
		if (intMushroomToppings != other.intMushroomToppings)
			return false;
		if (intPepperoniToppings != other.intPepperoniToppings)
			return false;
		if (intVeggieToppings != other.intVeggieToppings)
			return false;
		if (!strPizzaSize.equals(other.strPizzaSize))
			return false;
		return true;
	}
	
	@Override  //output pizza
	public String toString() {
		return "  Pizza size is: " + strPizzaSize + 
				"\n  With Stuffed Crust: " + bolStuffedCrust +
				"\n  Number of Cheese Topping(s) is: " + intCheeseToppings + 
				"\n  Number of Pepperoni Topping(s) is: " + intPepperoniToppings + 
				"\n  Number of Mushroom Topping(s) is: " + intMushroomToppings + 
				"\n  Number of Veggie Topping(s) is: " + intVeggieToppings + 
				"\n  The cost is: $" + String.format("%.2f", calcCost(this));
	}
}

