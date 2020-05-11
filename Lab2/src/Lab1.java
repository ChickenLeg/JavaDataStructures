import java.util.Scanner;
import java.lang.*;

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

public class Lab1 {
	/**
	 * @param args
	 */
	public static void displayMainMenu() {
		System.out.println("1. Initialize a default array");
		System.out.println("2. To specify the max size of the array");
		System.out.println("3. Add value to the array");
		System.out.println("4. Display values in the array");
		System.out.println("5. Display the average of the values");
		System.out.println("6. To Exit");
		System.out.print("> ");

	}

	public static void main(String[] args) {

		Numbers num = new Numbers();

		int choice = 0;
		Scanner src = new Scanner(System.in);
		Scanner src1 = new Scanner(System.in);
		Scanner src3 = new Scanner(System.in);
		
//		if (choice > 6 || choice < 1) {
//			System.err.println("Invalid input!");
//			System.out.println("Please select one of the following: ");
//			displayMainMenu();
//			choice = src.nextInt();
//			
//		} else {
		do {
			System.out.println("Please select one of the following: ");
			displayMainMenu();
			try {
				choice = Integer.parseInt(src.nextLine());
				if (choice < 1 || choice >6) {
					System.err.println("Invalid Input!");
					System.out.println("Please select one of the following: ");
					displayMainMenu();
					choice = src.nextInt();}
			} catch (Exception e) {
				System.err.println("Invalid! Again: ");
			}
			switch (choice) {
			case 1:
				num = new Numbers();
				break;
			case 2:
				System.out.println("Enter new size of array: ");
				num = new Numbers(src1.nextInt());
				break;
			case 3:
				num.addValue(src3);
				break;
			case 4:
				System.out.println("Numbers are: \n" + num.toString());
				break;
			case 5:
				System.out.println("Average is " + num.calcAverage());
				break;
			case 6:
				System.out.println("Exiting...");
				break;
			default:
				break;
			}
		}while(choice != 6);
	}
}
