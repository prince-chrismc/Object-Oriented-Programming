// -------------------------------------------------------------------------------
// Assignment (2)
// Questions: (1)
// Written by: Christopher McArthur(40004257) and Dave Bhardwaj(40000679)
// For COMP249 Section: (PP)
// ------------------------------------------------------------------------------

package A2;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Random;
import java.util.Scanner;


public class PublicationListingProcess1 
{
	/* the general purpose of this project is to
	 * read the publications saved by a store in a .txt and than 
	 * Prompt the user to correct any dupicated codes
	 */
	
	static Scanner keyboard = new Scanner(System.in);
	public static Publication publicationArray[] = new Publication[100];
	enum PublicationTypes
	{
		PUBLICATIONCODE, PUBLICATIONNAME,
		PUBLICATIONYEAR, PUBLICATIONAUTHORNAME, PUBLICATIONCOST,
		PUBLICATIONNBPAGES
	}
	
	public static void main(String[] args) 
	{
		//Hello Message
		System.out.println("Welcome to Chris and Dave's Publication list application!\n\n");
		
		boolean bolOutputFileIsIncorrect = false;
		File outputFile = null;
		String strFileOutName;
		
		
		do  //get a correct output file name
		{
			bolOutputFileIsIncorrect = false;
			System.out.print("Dear user, please enter the name for an output file: ");
			strFileOutName = keyboard.next();
			if (strFileOutName.length() <= 4)
				strFileOutName += ".txt";
			else if (!strFileOutName.substring(strFileOutName.length() - 4, strFileOutName.length() - 1).equals(".txt"))
			{
				strFileOutName += ".txt"; //add file extension
			}
			
			try 
			{
				outputFile = new File(strFileOutName);
				if(outputFile.exists()) //check existence
					throw new FileAlreadyExistsException("File already exists, its size is " + outputFile.length());
				else
				{
					try 
					{
						outputFile.createNewFile(); //create the file
					} 
					catch (IOException e) 
					{
						System.out.println("File could not be created, try again!");
						bolOutputFileIsIncorrect = true;
						e.printStackTrace();
					}
				}
			}
			catch(FileAlreadyExistsException e)
			{
				bolOutputFileIsIncorrect = true;
				System.out.println(e.getMessage() + ", try again!");
			}
		}while(bolOutputFileIsIncorrect);
		
		//establish reader
		FileReader readingFile = null;
		File inputFile = new File("PublicationData_Input.txt");
		try {
			readingFile = new FileReader(inputFile);
		} catch (FileNotFoundException e) {
			System.out.print("can not reach input file.. any ideas?");
			System.exit(0);
		}
		
		//establish writer
		FileWriter writingFile = null;
		try 
		{
			writingFile = new FileWriter(outputFile);
		} 
		catch (IOException e) 
		{
			System.out.print("can not reach output file.. any ideas?");
			System.exit(0);
		}
		
		
		try 
		{
			//correct duplicated codes
			correctListOfItems(readingFile, writingFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			FileReader fr = new FileReader(outputFile);
			printFileItems(fr);
		}
		catch (FileNotFoundException e)
		{
			System.out.print("can not reach input file.. any ideas?");
			System.exit(0);
		} 
		catch(IOException e) 
		{
			System.out.print("can not read your file.. any ideas?");
			e.printStackTrace();
		}
		
		
		//Goodbye message
		System.out.print("\n\nThank you for using me!");
		System.exit(0);
	}
	
	
	/**
	 * @return correct publication .txt and save to new .txt
	 */
	public static void correctListOfItems(FileReader fr, FileWriter fw) throws IOException
	{
		//objects for opperations
		BufferedReader buffedReader = new BufferedReader(fr);
		int intNumberOfLines = 0;
		String strLineText = "";
		
		//determine the number of lines
		do
		{
			strLineText = buffedReader.readLine();
			//System.out.println(strLineText); debug output
			
			if(strLineText == null)
				break;	
			else if(strLineText != null)
			{
				//temp variables for value to be put into constructor
				long pubCode;
				String pubName;
				int pubYear;
				String pubAuthor;
				double pubPrice;
				int pubPages;
				
				//get values
				Scanner strText = new Scanner(strLineText);
				pubCode = strText.nextLong();
				//System.out.print(pubCode + ",");  debug output
				pubName = strText.next();
				//System.out.print(pubName + ",");  debug output
				pubYear = strText.nextInt();
				//System.out.print(pubYear + ",");  debug output
				pubAuthor = strText.next();
				//System.out.print(pubAuthor + ",");  debug output
				pubPrice = strText.nextDouble();
				//System.out.print(pubPrice + ",");  debug output
				pubPages = strText.nextInt();
				//System.out.println(pubPages);  debug output
				strText.close();
				
				//put into array
				//System.out.println("--> " + intNumberOfLines + " <--");  debug output
				publicationArray[intNumberOfLines] = new Publication(pubCode, pubName, pubYear, pubAuthor, 
						pubPrice, pubPages);
				//System.out.println(publicationArray[intNumberOfLines].toString());  debug output
				intNumberOfLines +=1;
			}
		}while(!strLineText.equals(null));
		//System.out.println(intNumberOfLines);
		
		//close reader when method completes
		buffedReader.close();
		
		
		if(intNumberOfLines <= 1) //check if its possible for conflict
		{
			System.out.println("Input File has no lines");
			return;
		}
		if(intNumberOfLines >= 100) //check if lines exceeds array size
			System.out.println("Input File had too many lines");
			intNumberOfLines = 99;
		
			
		Scanner kb = new Scanner(System.in);	
		for(int i = 0; i < intNumberOfLines; i += 1) //original that wont b changed
		{
			for(int j = 0; j < intNumberOfLines; j += 1) //conflicting to b modified
			{
				
				if( i == j) // if they are the same skip
					continue;
				if(publicationArray[i] == null || publicationArray[j] == null) //in case a null got created by accident
					break;
				
				/*     debugging output
				System.out.println("i: " + i + ".    j: " + j);
				System.out.println("code i: " + publicationArray[i].getPublication_code());
				System.out.println("code j: " + publicationArray[j].getPublication_code());
				System.out.println();*/
				
				//check if 2 publications have the same code and correct the conflict
				if(publicationArray[i].getPublication_code() == publicationArray[j].getPublication_code())
				{
					//show conflicting publications
					System.out.println("Conflict in publication list.");
					System.out.println("original: " + publicationArray[i] + "\nconflict: " + publicationArray[j]);
					
					//prompt user for new code
					System.out.print("Enter new publication code for conflict: ");
					long correctedCode;
					if(kb.hasNextLong()) //if user puts in a new code
					{
						correctedCode = kb.nextLong();
						for(int k = 0; k < intNumberOfLines; k += 1)
						{
							//in case a null got created by accident
							if(publicationArray[k] == null) 
								break;
							
							//check if pub code already exists
							if(correctedCode == publicationArray[k].getPublication_code())
							{
								//makes up a random number
								System.out.println("Invalid input random number assigned");
								Random rand = new Random();
								correctedCode = rand.nextInt((999999999 - 100000000) + 1) + 100000000;
							}
						}
					}
					else //if not randomly generate a code (assuming this doesnt make a double which is # of lines in 10million)
					{
						System.out.println("Invalid input random number assigned");
						Random rand = new Random();
						correctedCode = rand.nextInt((999999999 - 100000000) + 1) + 100000000;
					}
					publicationArray[j].setPublication_code(correctedCode); //corrects the conflict
					
					//shows no more conflict
					System.out.println("original: " + publicationArray[i] + "\ncorrected: " + publicationArray[j]);
				}
			}
		}
		kb.close(); //close canner since its no longer needed
		
		//establish writer
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i < intNumberOfLines-1; i += 1)
		{
			//in case of any nulls
			if(publicationArray[i] == null)
				break;
			
			//write to file and slap a return and new line at the end
			bw.write(publicationArray[i].getPublication_code() + " " +
					publicationArray[i].getPublication_name() + " " +
					publicationArray[i].getPublication_year() + " " +
					publicationArray[i].getPublication_authorname() + " " +
					publicationArray[i].getPublication_cost() + " " +
					publicationArray[i].getPublication_nbpages() + "\r\n");
		}
		//close up shop on the writer
		bw.flush();
		bw.close();
	}
	
	/**
	 * @return println of each line in .txt
	 */
	public static void  printFileItems(FileReader fr) throws IOException
	{
		//open reader, grab each line while its not null and println that line
		BufferedReader br = new BufferedReader(fr);
		for(String line; (line = br.readLine()) != null; ) {
			System.out.println(line);
	    }
		br.close();
	}
	
	

}
