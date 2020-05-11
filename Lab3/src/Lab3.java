import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Yanni Li Student Number: 040914267 Course: CST8130 - Data
 * Structures
 * 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 *
 */

public class Lab3 {
	/**
	 * @param args
	 */
	public static void displayMainMenu() {
		System.out.println("1. Initialize a default array");
		System.out.println("2. To specify the max size of the array");
		System.out.println("3. Add value to the array");
		System.out.println("4. Display values in the array");
		System.out.println("5. Display the average of the values");
		System.out.println("6. Enter multiple values");
		System.out.println("7. Read values from file");
		System.out.println("8. Save values to file");
		System.out.println("9. Sort the array.");
		System.out.println("10. To Exit");
		System.out.print("> ");

	}

	public static void main(String[] args) {
		
		//create an object
		Numbers num = new Numbers();
		//string path to the file
		String name ="c:\\temp\\";
		//initialize choice
		int choice = 0;
		Scanner src = new Scanner(System.in);
		Scanner src1 = new Scanner(System.in);
		Scanner src3 = new Scanner(System.in);
		Scanner src4 = new Scanner(System.in);
		Scanner src5 = new Scanner(System.in);
		
		//loop until user input 9 to exit
		do {
			System.out.println("Please select one of the following: ");
			displayMainMenu();
			//check user input of menu
			//if it is not an integer or choice is not in 1 to 9
			//ask for user input again
			try {
				choice = Integer.parseInt(src.nextLine());
				if (choice < 1 || choice >9) {
					System.err.println("Invalid Input!");
					System.out.println("Please select one of the following: ");
					displayMainMenu();
					choice = src.nextInt();}
			} catch (Exception e) {
				System.err.println("Invalid! Again: ");
			}
			
			switch (choice) {
			case 1:
				//Initialize array
				num = new Numbers();
				break;
			case 2:
				//define the size of array
				System.out.println("Enter new size of array: ");
				num = new Numbers(src1.nextInt());
				break;
			case 3:
				//add one value at a time
				num.addValue(src3);
				break;
			case 4:
				//display array
				System.out.println("Numbers are: \n" + num.toString());
				break;
			case 5:
				System.out.println("Average is " + num.calcAverage());
				break;
			case 6:
				//add multivalues into array
				num.addValues(src4);
				break;
			case 7:
				//invoke method
				num.readFile();
				break;
			case 8:
				System.out.println("Name of the file to save to: \n");
				//take user input to save file
				String str = src5.next();
				//text name + path
				Path path = Paths.get(name + str);
				try {
					Numbers.toTextFile(path);
				} catch (IOException e) {
					e.printStackTrace();
				}	
				break;
			case 9:
				num.sortArray();
				System.out.println("Numbers are: \n" + num.toString());
				break;
			case 10:
				System.out.println("Exiting...");
				break;
			default:
				break;
			}
		}while(choice != 9);
	}
}
