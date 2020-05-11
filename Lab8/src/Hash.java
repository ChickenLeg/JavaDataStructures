import java.util.*;
import java.io.*;

public class Hash {
	public static void main(String[] args) {
		//create an array list with the size 100
		ArrayList<String> dataitems = new ArrayList<String>(100);
		Scanner input = new Scanner(System.in);
		//add 100 items into an ArrayList
		for (int i = 1; i <= 100; ++i)
			dataitems.add("");
		char character;
		//display menu
		while (true) {
			System.out.println("1. Enter String ");
			System.out.println("2. Search a String ");
			System.out.println("3. Exit ");
			System.out.println(">");
			character = input.next().charAt(0);
			//Exit loop
			if (character == '3')
				break;
			
			switch (character) {
			//Hash Algorithm
			case '1':
				System.out.println("Enter your string :");
				String s = input.next();
				int a, b = 0;
				a = (int) (s.charAt(0));
				if (s.length() >= 2)
					b = (int) (s.charAt(1));
				int index = (a + b) % 100;
				if (dataitems.get(index) == "")
					dataitems.add(index, s);
				else {
					int f = 1;
					for (int i = index; i <= 99; ++i) {
						if (dataitems.get(i) == "") {
							dataitems.add(i, s);
							f = 0;
							break;
						}
					}
					if (f == 1)
						System.out.println("String cannot be added");
				}
				break;
			case '2':
				System.out.println("Enter String to be searched");
				String s1 = input.next();
				int a1, b1 = 0;
				a1 = (int) (s1.charAt(0));
				if (s1.length() >= 2)
					b1 = (int) (s1.charAt(1));

				int index1 = (a1 + b1) % 100;
				if (s1.equals(dataitems.get(index1)))
					System.out.println("String found at index " + index1 + ".");
				else {
					int f1 = 1;
					for (int i = index1; i <= 99; ++i) {
						if (s1.equals(dataitems.get(i))) {
							System.out.println("String found at index " + index1 + ".");
							f1 = 0;
							break;
						}
					}
					if (f1 == 1)
						System.out.println("String not found.");
				}
				break;
			default:
				System.out.println("Incorrect Choice ");
			}
		}
	}

}
