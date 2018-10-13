package A2;

public class Publication 
{
	private long publication_code;
	private String publication_name; 
	private int publication_year;
	private String publication_authorname;
	private double publication_cost;
	private int publication_nbpages;
	
	/**
	 * @param publication_code
	 * @param publication_name
	 * @param publication_year
	 * @param publication_authorname
	 * @param publication_cost
	 * @param publication_nbpages
	 */
	public Publication(long publication_code, String publication_name, int publication_year,
			String publication_authorname, double publication_cost, int publication_nbpages) {
		super();
		this.publication_code = publication_code;
		this.publication_name = publication_name;
		this.publication_year = publication_year;
		this.publication_authorname = publication_authorname;
		this.publication_cost = publication_cost;
		this.publication_nbpages = publication_nbpages;
	}
	public Publication() 
	{
		super();
		this.publication_code = 0;
		this.publication_name = "";
		this.publication_year = 0;
		this.publication_authorname = "";
		this.publication_cost = 0.0;
		this.publication_nbpages = 0;
	}
	/**
	 * @return the publication_code
	 */
	public long getPublication_code() {
		return publication_code;
	}
	/**
	 * @param publication_code the publication_code to set
	 */
	public void setPublication_code(long publication_code) {
		this.publication_code = publication_code;
	}
	/**
	 * @return the publication_name
	 */
	public String getPublication_name() {
		return publication_name;
	}
	/**
	 * @param publication_name the publication_name to set
	 */
	public void setPublication_name(String publication_name) {
		this.publication_name = publication_name;
	}
	/**
	 * @return the publication_year
	 */
	public int getPublication_year() {
		return publication_year;
	}
	/**
	 * @param publication_year the publication_year to set
	 */
	public void setPublication_year(int publication_year) {
		this.publication_year = publication_year;
	}
	/**
	 * @return the publication_authorname
	 */
	public String getPublication_authorname() {
		return publication_authorname;
	}
	/**
	 * @param publication_authorname the publication_authorname to set
	 */
	public void setPublication_authorname(String publication_authorname) {
		this.publication_authorname = publication_authorname;
	}
	/**
	 * @return the publication_cost
	 */
	public double getPublication_cost() {
		return publication_cost;
	}
	/**
	 * @param publication_cost the publication_cost to set
	 */
	public void setPublication_cost(double publication_cost) {
		this.publication_cost = publication_cost;
	}
	/**
	 * @return the publication_nbpages
	 */
	public int getPublication_nbpages() {
		return publication_nbpages;
	}
	/**
	 * @param publication_nbpages the publication_nbpages to set
	 */
	public void setPublication_nbpages(int publication_nbpages) {
		this.publication_nbpages = publication_nbpages;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() //costume to string to read outputs
	{
		return "Publication Code: " + publication_code + "\n" + publication_name
				+ " published in " + publication_year + " by author:" + publication_authorname
				+ " for cost of $" + publication_cost + " with " + publication_nbpages + " pages\n";
	}
	
	
}
