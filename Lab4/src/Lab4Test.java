import java.util.Scanner;

public class Lab4Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
// asdfdsa
//		String value = "exit";
//		System.out.println("\nPlease enter a palindrome or exit to terminate the program: ");
//		String value = input.next();
//		boolean b = Boolean.parseBoolean(value);
		boolean b = false;

		do {
			System.out.println("\nPlease enter a palindrome or exit to terminate the program: ");
			String str;
			str = input.next();
			if (str.equals("exit")) {
				System.out.println("Exit...");
				b = true;
				//break;
				}
			else if (Palindrome.isPalindrome(str)) {
				System.out.println("The word " + str + " IS a palindrome.");
			} else {
				System.out.println("The word " + str + " IS NOT a palindrome.");
			}

		} while (!b);
	}

}
