
public class Palindrome {
	
	public static boolean isPalindrome(String input) {
		if (input==null) {
			return false;
		}
		String reserved = reverse(input);
		
		return input.equals(reserved);
	}

	public static String reverse(String str) {
		if (str==null) {
			return null;
		}
		if(str.length()<=1) {
			return str;
		}
		
		return reverse(str.substring(1)) + str.charAt(0);
	}
	
	public static boolean checkPalindrome(String text) { 
		
		StringBuilder sb = new StringBuilder(text); 
		char[] contents = text.toCharArray(); 
		
		for(int i = text.length() -1; i>=0 ; i--) { 
			sb.append(contents[i]); 
			} 
		
		String reversed = sb.toString(); 
		
		return text.equals(reversed); 
		}
}
