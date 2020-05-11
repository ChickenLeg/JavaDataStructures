import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab5Test {
	
	public static void displayMenu() {
		System.out.println("1. Add Item.");
		System.out.println("2. Search for Item.");
		System.out.println("3. Display List.");
		System.out.println("4. Exit.");
	}
//	public static int binarySearch() {
//		
//	}
	public static void main(String[] args) {
		//declaring an array list size of 10
		int n = 10;
		ArrayList<Integer> arrli = new ArrayList<Integer>(n);
		int choice = 0;
		do {
			
			Scanner src = new Scanner(System.in);
			System.out.println("Please select one of the following: ");
			displayMenu();
			try {
				choice = Integer.parseInt(src.nextLine());
				if (choice < 1 || choice > 4) {
					System.err.println("Invalid Input!");
					System.out.println("Please select one of the following: ");
					displayMenu();
					choice = src.nextInt();}
			} catch (Exception e) {
				System.err.println("Invalid! Again: ");
			}
			
			switch (choice) {
			case 1:
				System.out.println("Please specify an Integer: ");
				Scanner src1 = new Scanner(System.in);
				arrli.add(src1.nextInt());
				break;
			case 2:
				System.out.println("Please specify an Integer: ");
				Scanner src2 = new Scanner(System.in);
				int pos = Collections.binarySearch(arrli,src2.nextInt());
				if (pos == -1) {
					System.out.println("Index of Integer is : Not Found!");
				}else {
					System.out.println("Index of Integer is : " + pos);
				}
				break;
			case 3:
				Collections.sort(arrli);
				System.out.println(arrli);
				break;
			case 4:
				System.out.println("Existing...");
				break;
			default:
				break;
			}
		}while(choice != 4);
		
		
	}
}
