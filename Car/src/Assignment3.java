// Assignment #: 3
// Name: Ong Hong Xiang
// StudentID: 405530028
// Lecture:
// Description: Assignment 3 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.
// Time spent:

import java.io.*;    //to use InputStreamReader and BufferedReader
import java.util.*;

public class Assignment3
 {
  public static void main (String[] args)
   {
       // local variables, can be accessed anywhere from the main method
       char input1 = 'Z';
       //String name, type, place; String ct, manufac, brand;
      // int date, month, year; 
       String line = new String();

       // instantiate a Make object
       Makes make1 = new Makes();
       Car car1 = new Car();
       printMenu();

       //Create a Scanner object to read user input
       Scanner scan = new Scanner(System.in);

       do  // will ask for user input
        {
         System.out.println("Which action would you like to perform?");
         line = scan.nextLine();

         if (line.length() == 1)
          {
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           // matches one of the case statement
           switch (input1)
            {
             case 'A':   //Add Car
               System.out.print("Please enter the car information:\n");
               System.out.print("What is the car's manufacturer?\n");
               String nManufac = scan.nextLine();
               make1.setManufac(nManufac);
               System.out.print("What is the car brand?\n");
               String nBrand = scan.nextLine();
               make1.setBrand(nBrand);
               System.out.print("Which country is the car made?\n");
               String nCountry = scan.nextLine();
               make1.setCountry(nCountry);
               System.out.print("What year was the car made?\n");
               String nYear = scan.nextLine();
               car1.setYear(nYear);
               System.out.print("What color is the car?\n");
               String nColor = scan.nextLine();
               car1.setColor(nColor);
               System.out.print("How much was the car's price?\n");
               Double nPrice = scan.nextDouble();
               car1.setPrice(nPrice);
             	break;
             case 'D':   //Display Car
               System.out.print(make1.toString() + car1.toString());
               break;
             case 'Q':   //Quit
            	 
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
          }else
          {
        	  System.out.print("Unknown action\n");
             }
         
        } while(input1 != 'Q' || line.length() != 1);
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd Car\n" +
                        "D\t\tDisplay Car\n" +
                        "Q\t\tQuit\n" +
                        "?\t\tDisplay Help\n\n");
  }
}