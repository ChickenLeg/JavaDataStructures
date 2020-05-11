import java.util.LinkedList;
import java.util.Scanner;

public class Lab6Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String expression = "";

		do {
			System.out.print("Enter an expression (or exit to terminate): ");
			expression = input.nextLine().trim();
			if (expression.equalsIgnoreCase("Exit")) {
				System.out.println("\nExiting...\n");
				System.exit(-1);
			} else {
				if (checkBalanced(expression))
					System.out.println("The expression is balanced.");
				else
					System.out.println("The expression is NOT balanced.");
			}
			System.out.println();
		} while (!expression.equalsIgnoreCase("Exit"));
	}

	private static boolean bracketsPair(char char1, char char2) {
		if (char1 == '(' && char2 == ')') {
			return true;
		} else if (char1 == '{' && char2 == '}') {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkBalanced(String exp) {
		LinkedList<String> braces = new LinkedList<>();

		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '(' || exp.charAt(i) == '{') {
				braces.addFirst(exp.charAt(i) + "");
				continue;
			}

			else if (exp.charAt(i) == ')' || exp.charAt(i) == '}') {
				if (braces.isEmpty())
					return false;
				else if (!bracketsPair(braces.removeFirst().charAt(0), exp.charAt(i)))
					return false;
			}
		}

		if (braces.isEmpty())
			return true;
		else
			return false;
	}
}
