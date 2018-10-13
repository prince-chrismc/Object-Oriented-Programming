package A3;

public class BidOrder extends Order
{

	/**
	 * @param nameID
	 * @param price
	 * @param volume
	 */
	public BidOrder(String nameID, double price, int volume) 
	{
		super(nameID, price, volume);
	}
	
	@Override
	public String toString() 
	{
		return "Order Bid by " + getNameID() + " at Price: $" + getPrice() + " for " 
				+ getVolume() + " stocks";
	}
	
}
