package A3;

public class OrderOffer extends Order
{

	/**
	 * @param nameID
	 * @param price
	 * @param volume
	 */
	public OrderOffer(String nameID, double price, int volume) 
	{
		super(nameID, price, volume);
	}

	@Override
	public String toString() 
	{
		return "Order Offer by " + getNameID() + " at Price: $" + getPrice() + " for " + getVolume()
				+ " stocks";
	}
	
	
}
