package cse360assignment02;

import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;

/** 
 * Will add two values together and display the result
 * @author David Rodriguez
 *
 */
public class AddingMachine {
	private int total;
	private int add;
	private int sub;
	private String str1;
	private String str2;
	
	private StringBuilder str = new StringBuilder("0");
    private String show = new String("");
	private ArrayList<Integer> history = new ArrayList<Integer>();
	
	/**
	 * Constructor for the class AddingMachine
	 */
	public AddingMachine () { 
		
	}
	
	/**
	 * Will get the total after the arithmetic operation
	 * @return total
	 */
	public int getTotal () { 
		return total;
	}
	
	/**
	 * Will add two values 
	 * @param value This AddingMachine value will be added
	 * 				
	 */
	public void add (int value) { 
		total += value; // add the value to total 
		history.add(0); // save value in array for identifying "+"
		history.add(value); // save value in arraylist
	}
	
	/**
	 * Will subtract two values 
	 * @param value This AddingMachine value will be subtracted
	 */
	public void subtract (int value) { 
		total -= value; // subtract value from the total
		history.add(1); // save value in array for identifying "-"
		history.add(value); // save value in arraylist
	}
	
	/**
	 * Will save all actions/operations
	 */
	public String toString () {
			
		// iterate through the array to get all the values from array list
		for(int i = 0; i < history.size(); i++) {
			
			if(history.get(i) == 0) { // check if the value is "+"
				i++; // Get the integer index
				add = history.get(i); // get the value
				str1 = String.valueOf(add); // convert to String
				str.append(" + ").append(str1); // append to the StringBuilder
			}
		
			if(history.get(i) == 1) { // check if value is "-"
				i++; // change index to get integer index
				sub = history.get(i); // get the value
				str2 = String.valueOf(sub); // convert to string
				str.append(" - ").append(str2); // append to StringBuilder
			}
		}
		 
		show = String.valueOf(str); // StringBuilder to String
		 
		return  show; // return string
	}
	
	/**
	 * Will clear memory 
	 */
	public void clear() { 
		System.gc();
	}

	public static void main(String[] args) {
		
			// Create object
			Scanner input = new Scanner(System.in);
			AddingMachine myCalculator = new AddingMachine();
			
			int choose = 1; // variable for choosing arithmetic operation
			int end = 0; // varuable for closing loop
			
			do {
				
				int integer = 0;
				
				// Print menu
				System.out.println("Enter 0: Add " + 
								   "Enter 1: Subtract");
				choose = input.nextInt(); // Get user input for choice
				
				// get integer for adding
				if(choose == 0) {
					System.out.println("Enter integer to add.");
					integer = input.nextInt();
					myCalculator.add(integer);
				}
				
				// get integer for subtraction
				else if(choose == 1) {
					System.out.println("Enter integer to subtract.");
					integer = input.nextInt();
					myCalculator.subtract(integer);
				}
				
				// otherwise tell the user of invalid input
				else {
					System.out.println("Invalid Input.....");
				}
				
				// prompt for continuation
				System.out.println("Press 0 to continue operations.\n"
								   + "Otherwise Press 1.");
				end = input.nextInt();
				
			}while(end == 0);
			
			// Print out equation
			System.out.println(myCalculator);
			
			// Print out total
			System.out.println("Total: " + myCalculator.getTotal());
			
			// Clear memory
			myCalculator.clear();
	}
}
