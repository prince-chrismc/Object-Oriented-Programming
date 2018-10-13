//-------------------------------------------------------
//Assignment (1)
//Written by: (Christopher McArthur 40004257)
//For COMP 249 Section (P) – Winter 2016
//--------------------------------------------------------
package A1;

public class HouseholdGoods 
{
	private String strType;  // Electronics, Appliance, Furniture
	private String strDescription;
	private OldSweedCurrency oscPrice;
	private static int intGoodsCreated = 0;
	
	public HouseholdGoods() //default constructor
	{
		this.strType = "";
		this.strDescription = "";
		this.oscPrice = new OldSweedCurrency();
		intGoodsCreated += 1;
	}
	
	//constructor
	public HouseholdGoods(String strType, String strDescription, OldSweedCurrency oscPrice)
	{
		this.strType = strType;
		this.strDescription = strDescription;
		this.oscPrice = oscPrice;
		intGoodsCreated += 1;
	}

	//6 getters/setters + get for static
	public String getType() {
		return strType;
	}
	public void setType(String strType) {
		this.strType = strType;
	}
	public String getDescription() {
		return strDescription;
	}
	public void setDescription(String strDescription) {
		this.strDescription = strDescription;
	}
	public OldSweedCurrency getPrice() {
		return oscPrice;
	}
	public void setPrice(OldSweedCurrency oscPrice) {
		this.oscPrice = oscPrice;
	}
	public static int getGoodsCreated() {
		return intGoodsCreated;
	}
	
	public boolean equals(HouseholdGoods other) {
		if (!oscPrice.equals(other.oscPrice)) //check price
			return false;
		else if (!strDescription.equals(other.strDescription))//check description
			return false;
		else if (!strType.equals(other.strType))//check type
			return false;
		return true;	//they are equal!! =o
	}
	
	@Override
	public String toString() //popping string =D
	{
		return "HouseholdGood of Type: " + strType + ", Described as: " 
	+ strDescription + ", Price " + oscPrice;
	}
}
