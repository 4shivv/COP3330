/* Shivaganesh Nagamandla
 * COP 3330
 * Assignment 1
 */

package assignment1;

import java.util.Scanner; 
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Nagamandla_Shivaganesh {

	public static void main(String[] args) {

		//Create scanner object 
		Scanner scan = new Scanner(System.in);
	
		//Create random generator object 
		Random rand = new Random();
		
		//Generate random receipt number between 1000 and 2000 (exclusive)
		int receiptNumber = rand.nextInt(1000) + 1000; 
		
		//Generate random values for these components
		int year = rand.nextInt(200) + 1900;
		int month = rand.nextInt(12) + 1;
		int day = rand.nextInt(28) + 1; 
		
		//Local date object using the aforementioned values
		LocalDate randomDate = LocalDate.of(year, month, day);
		
		//Creates dateFormatter object for formatting date
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
		
		//Stores randomDate with the format of the dateFormatter in the String formattedDate
		String formattedDate = randomDate.format(dateFormatter);
				
		//print header 
		System.out.println("******************************");
        System.out.println("****** S store ***************");
        System.out.println("******************************");
        System.out.println("receipt number      " + receiptNumber);
        System.out.println(formattedDate);
		
		//Input handling & item processing
        
        int itemCount = 0;
        double totalSum = 0.0;
        String itemName = "";
        boolean DONE = false;
        double taxRate;

        while (!DONE) {
            System.out.print("Write item name ");
            itemName = scan.nextLine();
            
            if (itemName.equals("DONE")) {
                DONE = true;
            } else {
                System.out.print("Write Price ");
                double price = scan.nextDouble();
                scan.nextLine(); // removes Excess NewLine Character
                
                itemCount++; 
                
                String capitalizedItemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1).toLowerCase();
                
                if (capitalizedItemName.equalsIgnoreCase("Food"))
                {
                	taxRate = 0.0;
                }
                else {
                	taxRate = 0.3;
                }
                double finalPrice = price * (1 + taxRate);
                finalPrice = Math.round(finalPrice);
                totalSum += finalPrice;

                System.out.printf("item number %d %s  %.1f\n", itemCount, capitalizedItemName, finalPrice);
            }//end of else 
        }//end of while 
        
    //rounding final sum 
    totalSum = Math.round(totalSum * 10.0) / 10.0;
    System.out.printf("%d items total %.1f\n", itemCount, totalSum);
    System.out.println("******************************");
    System.out.println("******************************");
    System.out.println("******************************");

    scan.close();
		
	}// end of main 

}// end of Nagamandla_Shivaganesh class
