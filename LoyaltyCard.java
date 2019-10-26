/**
 * @(#)LoyaltyCard.java
 * This is a Loyalty card system, the user is prompted to enter hardcoded
 * usernames and passwords. They are then given the options to 
 * 1: View Gifts, 2:Buy Gifts, 3:Add points, 4:Change the Pin and 5:Exit the program
 * @author Kevin Donovan
 * @version 1.00 2014/1/15
 */

import java.util.Scanner;
public class LoyaltyCard {

    public static void main (String args[]) {

    	Scanner input = new Scanner(System.in);

    	//declare variables
    	String username[]={"kevinbdonovan","harrykane","nabilbentaleb","ryanmason","jonbellion"};
    	int balance[]={10000,9000,5000,8000,8250}; 
    	String pincode[]={"1111","2222","3333","4444","5555"};
    	String gifts[]={"1. Season Ticket", "\n2. Signed Spurs Jersey ", "\n3. Signature Boots", "\n4. Spurs Scarf", "\n5. Spurs Hat"};
    	int giftcost[]={8000,2000,1200,400,250};
    	String login;
    	String user_name;
		String user_pin;
    	String menulist = "\t\t\n\n1: View Gifts \t\t\n2: Buy Gifts \t\t\n3: Add Points \t\t\n4: Change Pin \t\t\n5: Exit\n";
    	String user_input=""; //used for all user inputs, choice, lodgement, withdrawl and new pin
    	int addpoints=0;
		int viewgifts, buygifts=0, newpin;
    	int option1=0;
    	int option2=0;
    	int choice, giftchoice;
    	int flag=0; // when flag =0 incorrect login, when flag =1 correct login
    	int count=3;// counter to limit login attempts
    	int found=0;// variable to determine which user is logged in
    	String name, password="";
    	
    	//welcome greeting and login
    	System.out.println("*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^");
    	System.out.println("--------Welcome to the Tottenham Hotspur Loyalty Giftshop-------");
		System.out.println("*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^");
		System.out.println("\t\tPlease Choose An Option\n");
		System.out.println("\t\t1: Log in\n\t\t2: Exit");
		System.out.print("*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^\n");
		login=input.next();

		//check the number entered is 1-2 only
	    while(!login.matches("[1-2]")){
	    	System.out.println("Error, Please only use numbers 1-2\n");
	    	option1 = Integer.parseInt(user_input);
	    	if(option1==2){
	    		System.out.println("Thanks for using the Tottenham Hotspur Loyalty Card System, Goodbye");
	    		System.exit(0);
	    	}// end of option1 = 2

	    	//re-prompt the user
	    	System.out.println("Welcome, Please choose an option");
	    	login = input.next();
	   		// start count
			count --;
			//start of if
			if(count==0){
			System.out.println("You have 0 attempts left... Please try again later");
			System.exit(0);
			java.awt.Toolkit.getDefaultToolkit().beep();
			}// end of if statement
			else{
				System.exit(0);
				System.out.println("\t\tThanks for using the Tottenham Hotspur Loyalty Card System, Goodbye");
			}//end of else

	    }//end while
		
		// while loop to take in the username and password
    	while (flag==0){
			System.out.println("");
    		System.out.print("Please enter your Loyalty System username: ");
    		user_name = input.next();
    		System.out.println("");
    		System.out.print("Please enter your password: ");
    		user_pin = input.next();
    		System.out.println("");

			// start count
			count --;
			if(count==0){
				System.out.println("You have exceeded the maximum number of attempts, Goodbye!");
				System.exit(0);
			}// end of if statement
	
			// for loop to go through the arrays to check the username and password is correct
			for(int i=0; i<username.length; i++){// start of for loop to see if information given is correct
				if (user_name.matches(username[i])&& user_pin.matches(pincode[i])){
					System.out.print("\n*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^\n");
					System.out.println("Welcome "+"'"+ user_name +"'"+ " to the Tottenham Hotspur Loyalty Card System "+menulist);
					System.out.println("*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^");
					// change the value of the flag to stop the while loop
					flag=1;
					found=i;

				}// end of if statement

			}// end of for loop
			// if the username or pincode is incorrect
            if(flag==0){
            	System.out.println("ERROR, please try again. ");
            }// end of if

        }//end of while loop
        
    	//prompt user for their choice
	    user_input = input.next();// take in choice as a string
		//change user_input to an int choice
		choice = Integer.parseInt(user_input);
		
	    //check the number entered is 1-5
	    while(!user_input.matches("[1-5]")){
	    	//re-prompt the user
	    	System.out.println(menulist);
	    	user_input = input.next();
	    }//end while

        //change user_input to an int choice
		//choice = Integer.parseInt(user_input);

		//loop to keep the menu appearing
		while(choice!= 5){

        if (choice == 1){
    	// for loop to print out information
    	for(int i=0;i<=4;i++){
    		System.out.print(gifts[i]+" "+giftcost[i]+"\n");
    	}// end of for loop
    	
			}//end choice 1
			else if(choice == 2){
			
			for(int i=0;i<=4;i++){
    			System.out.print(gifts[i]+" "+giftcost[i]+"\n");
    		
    		}// end of for loop 
				System.out.print("Please choose the gift you would like to buy: ");
                user_input=input.next();

                //check that the gift purchase only contains digits
    	        while(!user_input.matches("\\d+")){
    	        	System.out.println("Error, numbers only");
    		        
    		for(int i=0;i<=4;i++){
    			System.out.print(gifts[i]+"\t\t"+giftcost[i]+"\t\t");
    		
    		}// end of for loop   		        
				//take in gift purchase as a string
    	      	user_input = input.next();

    		   }//end while
    		    //change user_input to an int gift choice
    	    	giftchoice = Integer.parseInt(user_input);
    	    	if(balance[found]<giftcost[giftchoice-1]){
					System.out.println("Insufficient points, please choose again");
				}
			    else{
				balance[found]=balance[found]-giftcost[giftchoice-1];
				System.out.println("\nYour remaining points are "+balance[found]+("\n\n"));
				found=1;
				}//end else
				
			}//end choice 2
			
			// choice 3
			else if(choice == 3){
				//ask the user how many points to add
				System.out.print("\t\tPlease type the amount you wish to add: ");
				//new amount is entered
				user_input=input.next();
    	      	addpoints= Integer.parseInt(user_input);
				balance[found]=balance[found]+addpoints;
				System.out.println("\nYou now have "+balance[found]+(" points.\n\n"));
				
				 //check add points only contains digits
    	        while(!user_input.matches("\\d+")){
    	        	System.out.println("Error, numbers only");
    		        System.out.print("|t\tPlease type the amount you wish to add: " );
 
					System.out.println("\nYou now have "+balance[found]+(" points.\n\n"));

    		    }//end while

				
				}//end choice 3
				

				else if(choice==4){
				//prompt the user to enter a new pin
				System.out.print("Enter new pin: ");
				//new pin is entered
				user_input=input.next();

				//check newpin only contains digits
    	        while(!user_input.matches("\\d+")){
    	        	System.out.println("Error, numbers only");
    		        System.out.print("Enter new pin: " );
    		        //take in newpin as a string
    	      	    user_input = input.next();

    		   }//end while
				newpin= Integer.parseInt(user_input);
				//prompt the user the pin has been changed
				System.out.println("Pin changed to "+newpin);
				
			}//end choice 4
			//prompt user
			System.out.print("\n*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^\n");
			System.out.println("Welcome to the Tottenham Hotspur Loyalty Card System");
			System.out.println( menulist);
			System.out.println("*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^*^");
	        user_input = input.next();

	       //check the number entered is 1-5
	        while(!user_input.matches("[1-5]")){
	        	System.out.println("Error, numbers 1 - 5 only\n");
	    	    //re-prompt the user
	    	    System.out.println(menulist);
	    	    user_input = input.next();
	        }//end while
	   	 }//end while

        System.out.println("Thanks for using the Tottenham Hotspur Loyalty System, Goodbye");


 }//end main method
}//end class
