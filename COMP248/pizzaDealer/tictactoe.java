package pizzaDealer;
//-------------------------------------------------------	
//Assignment 3
//Written by: Christopher McArthur 40004257
//For COMP 248 Section EEEC – Fall 2015
//--------------------------------------------------------
import java.util.Scanner;

public class tictactoe {
	public static void printBoard(char[] boardInputs)
	{
		for(int x = 1; x < 10; x++)
		{
			System.out.printf("%-2c", boardInputs[x-1]);
		    if(x % 3 == 0) System.out.println();
		}
	} 
	public static boolean checkBoard(char[] boardInputs){
		boolean bolGameContinue = false;
		boolean bolTieCheck = true;
		for(int y = 0; y < 9; y++)
		{
			switch(boardInputs[y])
		    {
		    	case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
		    		bolTieCheck = false;
		        case 'X': case 'O':
		            break;
		         default:
		        	 System.out.println("Issue with board inputs despite me validating ur inputs...\nProgram Terminated.");
		             bolGameContinue = false;
		             System.exit(0);
		             break;
		     }
		 }
		             
		        //check each line position  012, 345, 678, 036, 147, 258, 048, 642
		        //for player X
		        if(boardInputs[0] == 'X' && boardInputs[1] == 'X' && boardInputs[2] == 'X')
		        {
		            System.out.println("\n\nPlayer X wins!!");
		            bolGameContinue = false;
		        }   
		        else if(boardInputs[3] == 'X' && boardInputs[4] == 'X' && boardInputs[5] == 'X')
		        {
		            System.out.println("\n\nPlayer X wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[6] == 'X' && boardInputs[7] == 'X' && boardInputs[8] == 'X')
		        {
		            System.out.println("\n\nPlayer X wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[0] == 'X' && boardInputs[3] == 'X' && boardInputs[6] == 'X')
		        {
		            System.out.println("\n\nPlayer X wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[1] == 'X' && boardInputs[4] == 'X' && boardInputs[7] == 'X')
		        {
		            System.out.println("\n\nPlayer X wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[2] == 'X' && boardInputs[5] == 'X' && boardInputs[8] == 'X')
		        {
		            System.out.println("\n\nPlayer X wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[0] == 'X' && boardInputs[4] == 'X' && boardInputs[8] == 'X')
		        {
		            System.out.println("\n\nPlayer X wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[6] == 'X' && boardInputs[4] == 'X' && boardInputs[2] == 'X')
		        {
		            System.out.println("\n\nPlayer X wins!!");
		            bolGameContinue = false;
		        }   
		         //for player O
		         else if(boardInputs[0] == 'O' && boardInputs[1] == 'O' && boardInputs[2] == 'O')
		         {
		            System.out.println("\n\nPlayer O wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[3] == 'O' && boardInputs[4] == 'O' && boardInputs[5] == 'O')
		        {
		            System.out.println("\n\nPlayer O wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[6] == 'O' && boardInputs[7] == 'O' && boardInputs[8] == 'O')
		        {
		            System.out.println("\n\nPlayer O wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[0] == 'O' && boardInputs[3] == 'O' && boardInputs[6] == 'O')
		        {
		            System.out.println("\n\nPlayer O wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[1] == 'O' && boardInputs[4] == 'O' && boardInputs[7] == 'O')
		        {
		            System.out.println("\n\nPlayer O wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[2] == 'O' && boardInputs[5] == 'O' && boardInputs[8] == 'O')
		        {
		            System.out.println("\n\nPlayer O wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[0] == 'O' && boardInputs[4] == 'O' && boardInputs[8] == 'O')
		        {
		            System.out.println("\n\nPlayer O wins!!");
		            bolGameContinue = false;
		        }
		        else if(boardInputs[6] == 'O' && boardInputs[4] == 'O' && boardInputs[2] == 'O')
		        {
		            System.out.println("\n\nPlayer O wins!!");
		            bolGameContinue = false;
		        }
		        else
		        {
		            bolGameContinue = true;
		        }
		         
		        if(bolTieCheck)
		        {
		            System.out.println("\n\nGame Ends in Draw!!");
		            bolGameContinue = false;
		        }
		        return bolGameContinue;
		    }
		     
	public static void addToken(char chrPlayerPiece, char[] chrBoardInputs, char chrPosition)
	{
		switch(chrPosition)
		{
			case '1':
				chrBoardInputs[0] = chrPlayerPiece;
		        break;
		    case '2': 
		         chrBoardInputs[1] = chrPlayerPiece;
		         break;
		    case '3':
		         chrBoardInputs[2] = chrPlayerPiece;
		         break;
		    case '4':
	            chrBoardInputs[3] = chrPlayerPiece;
	            break;
		    case '5': 
		    	chrBoardInputs[4] = chrPlayerPiece;
		        break;
		    case '6':
		    	chrBoardInputs[5] = chrPlayerPiece;
		        break;
		    case '7': 
		        chrBoardInputs[6] = chrPlayerPiece;
		        break;
		    case '8': 
		        chrBoardInputs[7] = chrPlayerPiece;
		        break;
		    case '9':
		        chrBoardInputs[8] = chrPlayerPiece;
		        break;
		    }
		}
		 
		    public static void main(String[] args) {
		        System.out.println("Welcome to Tic Tac Toe!\n");
		        boolean bolNextGame = true;
		        do
		        {
		        	Scanner keyboard = new Scanner(System.in);
				    boolean bolGameActive = true;
				    
				    String strUserInput;
				    char chrUserInput = '-';
				    boolean bolUserInput = false;
		            char[] chrBoardValues = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		            /* char[][] chrBoardValues = {'1','2','3'},{'4','5','6'},{'7','8','9'}
		             * im sorry but a 2D array is just not worth my while to implement so 
		             * theres some comments for you to use*/
		            bolGameActive = checkBoard(chrBoardValues); //validate board
		            printBoard(chrBoardValues); //print board
		             
		            while(bolGameActive == true)
		            {
		                //Player X
		                do
		                {
		                    System.out.print("Player X, which position would you like to play? "); //promte for position
		                    strUserInput = keyboard.nextLine(); //store input
		                    if(strUserInput.length() != 1) //validate length 
		                    {
		                        System.out.println("Invalid Position");
		                        bolUserInput = false;
		                        continue;                   
		                    }
		                    chrUserInput = strUserInput.charAt(0); //convert to char
		                    switch(chrUserInput)
		                    {
		                    case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': //validate inputs is a position 
		                        for(int x = 0; x < 9; x +=1)
		                        {
		                            if(chrBoardValues[x] == chrUserInput) //check if position is still availble
		                            {
		                                bolUserInput = true; //if everything checks allow to exit loop
		                                break;
		                            }
		                            else
		                            {
		                                bolUserInput = false;
		                            }
		                        }
		                        break;
		                    default:
		                        System.out.println("Invalid Position");
		                        bolUserInput = false;
		                        break;
		                    }
		                }while(!bolUserInput); 
		                addToken('X', chrBoardValues, chrUserInput); //validated position gets plays token put on board
		                 
		                 
		                bolGameActive = checkBoard(chrBoardValues); //validate date board for possible winner
		                printBoard(chrBoardValues); //print updated board
		                if(!bolGameActive) break; //is winner break before O can play
		                 
		                //player O
		                do
		                {
		                    System.out.print("Player O, which position would you like to play? ");
		                    strUserInput = keyboard.next().toUpperCase();
		                    if(strUserInput.length() != 1)
		                    {
		                        System.out.println("Invalid Position");
		                        bolUserInput = false;
		                        continue;                   
		                    }
		                    chrUserInput = strUserInput.charAt(0);
		                    switch(chrUserInput)
		                    {
		                    case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
		                        for(int x = 0; x < 9; x +=1)
		                        {
		                            if(chrBoardValues[x] == chrUserInput)
		                            {
		                                bolUserInput = true;
		                                break;
		                            }
		                            else
		                            {
		                                bolUserInput = false;
		                            }
		                        }
		                        break;
		                    default:
		                        System.out.println("Invalid Position");
		                        bolUserInput = false;
		                        break;
		                    }
		                }while(!bolUserInput);
		                addToken('O', chrBoardValues, chrUserInput);
		                 
		                bolGameActive = checkBoard(chrBoardValues); //validate date board for possible winner
		                printBoard(chrBoardValues); //print updated board
		            }
		            Scanner kb = new Scanner(System.in);
		            String strUserInputTwo = "y";
		            System.out.print("\n\nWould you like to play another game?? (y/n)");
		            strUserInputTwo = kb.nextLine();
		            
		            if(strUserInputTwo.equalsIgnoreCase("y"))
		                bolNextGame = true;
		            else
		                bolNextGame = false;
		        }while(bolNextGame);
		        
		    } 
}
