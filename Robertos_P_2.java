/***************************************************************   
***************************************************************    
***************************************************************    
                                                         			    		   	          
                   			ID INFORMATION                         		          
                                                        			    		                      
   		Programmer			:		Cardenas Roberto                
   		Assignment #		:   	Program #2                     	
   		Assignment Name   :	   File IO IO 
   		Course # and Title:	   CISC 190 - Java    	
   		Class Meeting Time:	   TTH 1:00 – 4:05	
  		   Instructor			:	   Professor Forman 
  		   Hours			   	:	   1:30
   		Difficulty			:	   1/10			
   		Completion Date	:	   04/11/2017 	
   		File Name			:  	Robertos_P_2

***************************************************************
***************************************************************

                   	PROGRAM DESCRIPTION   
   Prompts the user to either create a file containing 
   their favorite movies or to read from a similar file
   and when done the user can exit through the interface.   


***************************************************************
***************************************************************

                 CUSTOM-DEFINED METHODS LIST
                 
    closeProgram()
    createFile()
    decapitalize()
    farewell()
    readFile()
    showDocumentation()
    showMainMenu()

***************************************************************
***************************************************************

                         CREDITS	                          		

   	Acknowledge those who helped you and whom you helped  	
      Remember the “triangle of learning”:        		
      
   	Thanks for assistance and inspiration from:           			
         www.tutorialspoint.com/java 
         www.stackoverflow.com 
         Professor Forman, Yvan
      
      Thanks for the opportunity to assist and inspire:
         Yvan
           
***************************************************************
***************************************************************
                        
                           MEDIA
None

***************************************************************
***************************************************************/

import javax.swing.*;      //Needed for JOptionPane
import java.util.Scanner;	//Needed for Scanner
import java.io.*;				//Needed for IOException, PrintWriter, File
public class Robertos_P_2
{

////////////////////////////////////////////////////////////////////

//Instance variable declarations and definitions

////////////////////////////////////////////////////////////////////

   final String MY_NAME = "Roberto";
   
///////////////////////////////////////////////////////////////////

   public static void main(String[] args)throws IOException
   {
   /////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   ////////////////////////////////////////////////////////
   
      Robertos_P_2 object = new Robertos_P_2();
   
   ////////////////////////////////////////////////////////
   
      object.showMainMenu();
      
   }
 /******************************************************************************
*******************************************************************************

							START METHOD DECLARATIONS AND DEFINITIONS
								 (Best to appear alphabetically)

*******************************************************************************
******************************************************************************/

/******************************************************************************

	NAME:          showMainMenu
	DESCRIPTION:    Show the Main Menu where the user will interact with the program
   allowing them to either create a new file or read from an existing one until they decide
   to exit through the interface
   
******************************************************************************/
   public void showMainMenu()throws IOException
   {
   /////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable declarations and definitions
   
   //////////////////////////////////////////////////////////////////////////////////////////////////
   
      String strInput = "  ";
      char input;
      String text = "Enter C/c to create a new file\nEnter R/r to read from"
                     +" an existing file\nEnter Q/q to exit the Program:";
                     
   ///////////////////////////////////////////////////////////////////////////////////////////////////
   
      while(true)
      {
         while(true)
         {
            strInput = JOptionPane.showInputDialog(null,text);
            if (strInput.length()==1) //Checks if the input is the correct size
               break;
            JOptionPane.showMessageDialog(null,"Insert ONE character only. Try again...");
         }
         input = decapitalize(strInput.charAt(0));
         if(input == 'c')
         {
            createFile();
         }
         else if(input == 'r')
         {
            readFile();
         }
         else if(input == 'q')
         {
            closeProgram();
            break;
         }
         else
         {
            JOptionPane.showMessageDialog(null,strInput + " is not a valid key. Try again...");
         }
      }
      System.exit(0);
   }  
/******************************************************************************

	NAME:          createFile
	DESCRIPTION:    Creates a new text file and prints to it using the information
   entered by the user through JOptionPane until the user enters the sentinel to 
   indicate they are done inputing data.
   
******************************************************************************/
   public void createFile()throws IOException
   {
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      int counter = 0;
      String input;
      JOptionPane.showMessageDialog(null,"The file RobertosFavoriteMovies is about to be created."
      +" Enter x to stop writing to Disk.",
      "Create File",JOptionPane.INFORMATION_MESSAGE);
      PrintWriter printer = new PrintWriter("RobertosFavoriteMovies.txt");
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      while(true)
      {
         input = JOptionPane.showInputDialog(null,"Type in the tile of a Movie:","Add Movie to List", JOptionPane.INFORMATION_MESSAGE);
         if (input.length()==1 && input.charAt(0)=='x')//Checks if the user has inputed the sentinel and if so breaks out of the loop
         {
            break;
         }
         printer.println(input);
         counter ++;
         JOptionPane.showMessageDialog(null,"Disk Writing Item #"+counter+": "+input,"Confirm Movie",JOptionPane.INFORMATION_MESSAGE);
      }
      printer.close();
      JOptionPane.showMessageDialog(null,"Disk Writing is complete","Closing Disk",JOptionPane.INFORMATION_MESSAGE);  
   }
/******************************************************************************

	NAME:          readFile
	DESCRIPTION:    Opens a preexisting file and display all the information contained
   by the file using JOptionPane.
   
******************************************************************************/
   public void readFile()throws IOException
   {
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable/object declarations and definitions
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      String output;
      int counter = 0;
      Scanner fileScanner = new Scanner(new File("RobertosFavoriteMovies.txt"));
      
   //////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      JOptionPane.showMessageDialog(null,"Only read a file until after user has written to it",
      "Warning",JOptionPane.WARNING_MESSAGE);
      
      JOptionPane.showMessageDialog(null,"Disk file RobertosFavoriteMovies is about to be read...",
      "Read File",JOptionPane.INFORMATION_MESSAGE);
      
      while(fileScanner.hasNext())
      {
         counter ++;
         output = fileScanner.nextLine();
         JOptionPane.showMessageDialog(null,"Disk Reading Item #"+counter+": "+output,"Reading Disk",JOptionPane.INFORMATION_MESSAGE);
      }
      fileScanner.close();
      JOptionPane.showMessageDialog(null,"Disk Reading complete");
   }
   /******************************************************************************

	NAME:          closeProgram
	DESCRIPTION:    Warns the user the program is about to close, displays documentation
   and a farewell message.
   
   ******************************************************************************/
   public void closeProgram()
   {
      JOptionPane.showMessageDialog(null,"The program is about to close...","Exit Program",JOptionPane.INFORMATION_MESSAGE);
      showDocumentation();
      farewell();
      
   }
   /******************************************************************************

	NAME:          showDocumentation
	DESCRIPTION:   Displays the ID Information, Credits, Media and Stars by using JOptionPane
   
   ******************************************************************************/
   public void showDocumentation()
   {
   ////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Local variable declarations and definitions
   
   ////////////////////////////////////////////////////////////////////////////////////////////////
   
      String strIDInfo = "                 ID INFO\n"
                        +"Programmer          :  Cardenas Roberto \n"               
   		               +"Assignment#         :  Program #2       \n"              	
   		               +"Assignment Name     :  File IO IO       \n"
   		               +"Course # and Title  :  CISC 190 - Java  \n"  	
   		               +"Class Meeting Time  :  TTH 1:00 – 4:05  \n"
  		                  +"Instructor          :  Professor Forman \n"
  		                  +"Hours               :  01:30            \n"
   		               +"Difficulty          :  1/10             \n"
   		               +"Completion Date     :  04/11/2017       \n"
   		               +"File Name           :  Robertos_P_2     ";
                        
      String strCredits = "                       Credits                             \n"
                         +"  Acknowledge those who helped you and whom you helped     \n"
                         +"    Remember the 'triangle of learning':                   \n"
                         +"    *Thanks for assistance and inspiration from:           \n"         			
                         +"     -www.tutorialspoint.com/java                          \n"
                         +"     -www.stackoverflow.com                                \n"
                         +"     -Professor Forman                                     \n"
                         +"    *Thanks for the opportunity to assist and inspire      \n"
                         +"     -Yvan";
                         

      String strStars =   "                           STARS\n"
                         +" 1.-  Make your program “crash-proof” so the program is\n"
                         +"      “robust” and hence, the user cannot do anything to make the\n"
                         +"      program “go bust”\n"
                         +" 2.-  Add a counter so we know how many items we have written to or read\n"
                         +"      from disk\n"
                         +"Total STARS = 2";
                         
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      //Display ID Information
      JOptionPane.showMessageDialog(null,strIDInfo,"ID Information",JOptionPane.INFORMATION_MESSAGE);
      
      //Display Credits 
      JOptionPane.showMessageDialog(null,strCredits,"Credits",JOptionPane.INFORMATION_MESSAGE);
      
       
      //Display STARS
      JOptionPane.showMessageDialog(null,strStars,"STARS",JOptionPane.INFORMATION_MESSAGE);
   }
   /******************************************************************************

	NAME:          farewell
	DESCRIPTION:    Displays a farewell message for the user
   
******************************************************************************/
   public void farewell()
   {
      JOptionPane.showMessageDialog(null,"Farewell from "+MY_NAME+"'s Program #2!","Farewell",JOptionPane.INFORMATION_MESSAGE);
   }
   /******************************************************************************

	NAME:          decapitalize
	DESCRIPTION:    Takes in a char variable and returns it in lowercase
   
******************************************************************************/
   public char decapitalize(char input)
   {
      return Character.toLowerCase(input);
   }
/******************************************************************************
*******************************************************************************

							END METHOD DECLARATIONS AND DEFINITIONS

*******************************************************************************
******************************************************************************/
}