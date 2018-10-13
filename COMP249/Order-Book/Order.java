package A3;

public abstract class Order {
	private String nameID;
	private double price;
	private int volume;
	
	protected Order()
	{
		nameID = "";
		price = 0.0;
		volume = 0;
	}

	/**
	 * @param nameID
	 * @param price
	 * @param volume
	 */
	protected Order(String nameID, double price, int volume) 
	{
		super();
		this.nameID = nameID;
		this.price = price;
		this.volume = volume;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (nameID == null) {
			if (other.nameID != null)
				return false;
		} else if (!nameID.equals(other.nameID))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (volume != other.volume)
			return false;
		return true;
	}

	/**
	 * @return the nameID
	 */
	public String getNameID() 
	{
		return nameID;
	}

	/**
	 * @param nameID the nameID to set
	 */
	public void setNameID(String nameID) 
	{
		this.nameID = nameID;
	}

	/**
	 * @return the price
	 */
	public double getPrice() 
	{
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) 
	{
		this.price = price;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() 
	{
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) 
	{
		this.volume = volume;
	}
	
	abstract public String toString();
}
