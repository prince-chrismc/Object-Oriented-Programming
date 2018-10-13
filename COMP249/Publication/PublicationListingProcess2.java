/**
 * 
 */
package A2;

/**
 * @author Christopher McArthur and Dave Bhardwaj
 * @id 40004257 and 40000679 respectively
 */

import java.io.*;
import java.util.Scanner;

public class PublicationListingProcess2 
{
	static int bIterations  = 0;
    static int sIterations = 0;
	static Publication PublicationArray[];
	public enum PublicationType 
	{
		 PUBLICATIONCODE, PUBLICATIONNAME, PUBLICATIONYEAR, PUBLICATIONAUTHORNAME,
	     PUBLICATIONCOST, PUBLICATIONNBPAGES;
	}
	
	public static Scanner key = new Scanner(System.in);
	
	/**
	 * add new items to file
	 * @param pw file to write within
	 */
	public static void insertRowsToFile(PrintWriter pw )
	{
		boolean runInput = true;
		
		while(runInput){
			System.out.print("Please enter a new item: ");
			
			//Takes user input and stores it
			long newCode = key.nextLong();
			String newName = key.next();
			int newYear = key.nextInt();
			String newAuthor = key.next();
			double newPrice = key.nextDouble();
			int newPages = key.nextInt();
			
			//add line and writes item to text file
			BufferedWriter br = new BufferedWriter(pw);
			try 
			{
				br.write("\r\n"+newCode+" "+newName+" "+newYear+" "+newAuthor+" "+newPrice+" "+newPages);
			} 
			catch (IOException e1) 
			{
				System.out.println("Unable to write to file.");
			}
			
			System.out.println("Add another item? (yes or no)");
			
			try
			{
				String newItemAdd = key.next();
				if(newItemAdd.equalsIgnoreCase("yes"))
				{
					runInput = true;
				}
				else if(newItemAdd.equalsIgnoreCase("No"))
				{
					runInput = false;
				}
			}
			catch(Exception e)
			{
				System.out.println("There seems to be a problem with your answer bud.");
			}	
		}
	}
	
	/** 
	 * @param arrayPub array to look through
	 * @param stIndex start index
	 * @param fnIndex finish index
	 * @param pubCode code to look for
	 * @return the index at which the code was found at or -1 for not found
	 */
	public static int binaryPublicationSearch(Publication arrayPub[], int stIndex, int fnIndex, long pubCode){
		int center = (stIndex + fnIndex)/2;
		int x = 0;
		if(stIndex > fnIndex)
		{
			 x = -1;
		}
		else
		{
			if(pubCode == arrayPub[center].getPublication_code())
			{
				x = center;
			}
			else if(pubCode > arrayPub[center-1].getPublication_code() && 
					pubCode < arrayPub[center+1].getPublication_code())
			{
				x = -1;
			}
			else if(pubCode > arrayPub[center].getPublication_code())
			{
				bIterations++;
				x = binaryPublicationSearch(arrayPub, stIndex, center - 1, pubCode);
			}
			else if(pubCode < arrayPub[center].getPublication_code())
			{
				bIterations++;
				x = binaryPublicationSearch(arrayPub, center + 1, fnIndex, pubCode);
			}
		}
		return x;
	}
	
	/**
	 * @param arrayPub array to look through
	 * @param strIndex start index
	 * @param fnIndex finish index
	 * @param pubCode code to look for
	 * @return the index at which code was found of -1 for not found
	 */
	public static int sequentialPublicationSearch(Publication arrayPub[], int strIndex, int fnIndex, long pubCode)
	{
		int x = 0;
		
		if(strIndex > fnIndex)
		{
			x = -1;
		}
		for(int i = strIndex; i <= fnIndex; i += 1)
		{
			if(pubCode == arrayPub[i].getPublication_code())
			{
				x = i; // found at index
			}
			else if(pubCode > arrayPub[i].getPublication_code())
			{
				sIterations++; //no found go to next
			}
			else if(pubCode <  arrayPub[i].getPublication_code())
			{
				x = -1; //passed it therefore not in list
			}
		}
		return x;
	}
	
	/**
	 * @param read
	 * @return number of items in the file
	 */
	private static int getArraySize(BufferedReader read)
	{
		int size=0;
		try
		{
			while(read.readLine()!=null)
			{
				 size++;
			}
			throw new IOException("error when reading the file oh no!");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		return size;
	}
	
	/**
	 * method that sets array object values from file
	 * @param value
	 * @return the inputed array with updated values from file
	 */
	public static Publication[] addArrayValues(Publication[] value)
	{
		Scanner input = null;
		try
		{
			input = new Scanner(new FileInputStream("PublicationData_Ouput.txt"));
			throw new FileNotFoundException("That file does not exist.");
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			input.close();
		}
		
		//will go through each array index and set values to what has been read by Scanner stream
		while(input.hasNext()){
			for(int i = 0; i < value.length; i++)
			{
				if(value[i] == null) //no object at needed index so let's make one
				{
					value[i] = new Publication(input.nextLong(), input.next(), input.nextInt(),
									input.next(),input.nextDouble(),  input.nextInt());
				}
				else //set values as needed
				{
					value[i].setPublication_code(input.nextLong());
					value[i].setPublication_name(input.next());
					value[i].setPublication_year(input.nextInt());
					value[i].setPublication_authorname(input.next());
					value[i].setPublication_cost(input.nextDouble());
					value[i].setPublication_nbpages(input.nextInt());
				}
			}
		}
		input.close();
		return value;
	}
	
	/**
	 * print all the items in the file
	 * @param br what to be reading
	 * @throws IOException
	 */
	public static void  printFileItems(BufferedReader br) throws IOException
	{
		for(String line; (line = br.readLine()) != null; ) {
			System.out.println(line);
	    }
	}
	
	public static void main(String[] args) 
	{		
		//Hello Message
		System.out.println("Welcome to Chris and Dave's Publication list application!\n\n");
		
		//establish writer that appends text
		PrintWriter writer=null;
		try
		{
			writer = new PrintWriter(new FileOutputStream("PublicationData_Ouput.txt",true));
		}
		catch(FileNotFoundException e)
		{
			e.getMessage();
		}
		
		//reset user to input new entry and output to file
		insertRowsToFile(writer);
		
		//output items in file
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("PublicationData_Ouput.txt"));
			
			//out putting items
			printFileItems(br);
			br.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("That file does not exist.");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("Unable to read file.");
			System.exit(0);
		}
		
		//read how many lines and create new array of that size
		try
		{
			BufferedReader inputStream2 = new BufferedReader(new FileReader("PublicationData_Output.txt"));
			PublicationArray = new Publication[getArraySize(inputStream2)];
			inputStream2.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("That file does not exist.");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("Unable to read file.");
			System.exit(0);
		}
		
		//file array with the values of reader
		addArrayValues(PublicationArray);
		for(int i = 0;i < PublicationArray.length; i++)
		{
			System.out.println(PublicationArray[i]);
		}
		
		//prompt for code to search for to test search methods
		System.out.println("Please enter a record code to search using binary search method:");
		long userCode;
		if(key.hasNextLong())
			userCode = key.nextLong();
		else
		{
			System.out.println("invalid input, using 123456789");
			userCode = 123456789;
		}
		
		//binary search
		if(binaryPublicationSearch(PublicationArray, 0, PublicationArray.length-1, userCode) == -1)
			System.out.println("Code "+ userCode +" is not in the PublicationArray.");
		else
		{
			System.out.println("Code "+userCode+" is in the array at index " + binaryPublicationSearch(PublicationArray, 0, PublicationArray.length-1, userCode));
			System.out.println("It took "+bIterations+" iterations to find the requested code using recursion method.");
		}
						
		//sequential search
		if(sequentialPublicationSearch(PublicationArray, 0, PublicationArray.length-1, userCode)==-1)
			System.out.println("Code " + userCode + " is not in the PublicationArray.");
		
		else
		{
			System.out.println("Code " + userCode + " is in the array at index " + sequentialPublicationSearch(PublicationArray, 0, PublicationArray.length-1, userCode));
			System.out.println("It took " + sIterations + " iterations to find the requested code using sequentiel method.");
		}

		try
		{
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Publications.dat"));
			for(int y=0;y<=PublicationArray.length;y++)
			{
				outputStream.writeObject(PublicationArray[y]);
			}
			outputStream.close();
		}
		catch(FileNotFoundException e){
			e.getMessage();
		}
		catch(IOException e){
			e.getMessage();
		}
		
		//closing message
		System.out.println("The program is exiting....");
		writer.close();
		key.close();
		System.exit(0);
		}
}
