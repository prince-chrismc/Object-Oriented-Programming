//-------------------------------------------------------
//Assignment (1)
//Written by: (Christopher McArthur 40004257)
//For COMP 249 Section (P) – Winter 2016
//--------------------------------------------------------
package A1;

//didnt use a driver --> winner! <--
public class OldSweedCurrency {
	// 1 riksdaler was divided into 48 skillings and 1 skilling was 
	// divided into 16 runstyckens
	private int riksdaler;
	private int skilling;		// less than 48
	private int runstycken; 	// less than 16
	
	public OldSweedCurrency() // default constructor
	{
		riksdaler = 0;
		skilling = 0;
		runstycken = 0;
	}
	public OldSweedCurrency(int riksdaler, int skilling, int runstycken) //Constructor
	{
		if(riksdaler < 0 || skilling < 0 || runstycken < 0) //if any negative set zero
		{
			riksdaler = 0;
			skilling = 0;
			runstycken = 0;
		}
		else //is positive set to parameters
		{
			this.riksdaler = riksdaler;
			this.skilling = skilling; 
			this.runstycken = runstycken;
		}
	}
	public void Copy(OldSweedCurrency copying) //set instances as copied
	{
		this.riksdaler = copying.getRiksdaler();
		this.skilling = copying.getSkilling();
		this.runstycken = copying.getRunstycken();
	}
	
	//the 6 getters/setters
	public int getRiksdaler() {
		return riksdaler;
	}
	public void setRiksdaler(int riksdaler) {
		this.riksdaler = riksdaler;
	}
	public int getSkilling() {
		return skilling;
	}
	public void setSkilling(int skilling) {
		this.skilling = skilling;
	}
	public int getRunstycken() {
		return runstycken;
	}
	public void setRunstycken(int runstycken) {
		this.runstycken = runstycken;
	}
	
	public boolean equals(OldSweedCurrency other) {
		if (this.riksdaler != other.getRiksdaler()) //check riks
			return false;
		if (this.skilling != other.getSkilling()) //check skill
			return false;
		if (this.runstycken != other.getRunstycken()) //check runs
			return false;
		return true; // when all 3 pass as not != aka equal
	}
	
	public int compareTo(OldSweedCurrency other)
	{
		if (this.riksdaler > other.getRiksdaler() && this.skilling > other.getSkilling()
				&& this.runstycken > other.getRunstycken()) //check if greater
			return 1;
		else if (this.riksdaler == other.getRiksdaler() && this.skilling == other.getSkilling()
				&& this.runstycken == other.getRunstycken()) //check if equals
			return 0;
		else  //its less
			return -1;
	}
	
	public static OldSweedCurrency normalize(OldSweedCurrency other)
	{
		//normalizing function
		return new OldSweedCurrency(
				other.getRiksdaler() + other.getSkilling() / 48 , 
				other.getSkilling() % 48 + other.getRunstycken() / 16, 
				other.getRunstycken() % 16);
	}
	public OldSweedCurrency add(OldSweedCurrency other)
	{
		//add each value than normalize
		OldSweedCurrency result = new OldSweedCurrency(this.riksdaler + other.getRiksdaler(),
				this.skilling + other.getSkilling(),this.runstycken + other.getRunstycken());
		result = OldSweedCurrency.normalize(result);
		return result;
	}
	public OldSweedCurrency subract(OldSweedCurrency other)
	{
		//subtract each value than normalize
		OldSweedCurrency result = new OldSweedCurrency(this.riksdaler - other.getRiksdaler(),
				this.skilling - other.getSkilling(),this.runstycken - other.getRunstycken());
		result = OldSweedCurrency.normalize(result);
		return result;
	}
	public int convertToRunstycken()
	{
		//riks to skill .. total to runs
		return (((this.getRiksdaler() * 48) + this.getSkilling()) * 16);
	}
	static public OldSweedCurrency convertFromRunstycken(int other)
	{
		//im guessing this one from experience =p
		return new OldSweedCurrency( (other / 16) / 48, (other/16)%48, other % 16 );
	}
	
	@Override
	public String toString() {
		return "riksdaler: " + riksdaler + ", skilling: " + skilling + ", runstycken: " + runstycken;
	}
}
