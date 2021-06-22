/**
 * 
 */
package com.palindrome;

/**
 * @author Harshal-Git
 *
 *	-> check whether given string is palindrome OR not
 *
 * -> Time complexity: O(n/2) ~ O(n)  [while iteration ; can be terminated at any interval; hence it's BigOh] 
 * -> Space complexity:	0(1)
 * -> Auxiliary space: 0(1)
 */
public class StandardAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String data = null;
		
		// case 1
		data = "ABCDEDCBA";
		printMessage(data);
		
		// case 2
		data = "abba";
		printMessage(data);

		// case 3
		data = "GEEK";
		printMessage(data);
		
		// case 4
		data = "pqp";
		printMessage(data);
		
		// case 5
		data = "abab";
		printMessage(data);
	}

	/**
	 * @param data
	 */
	private static void printMessage(String data) {
		if(isPalindrome(data)) {
			System.out.println("String: "+data+" is palindrome.");
		} else {
			System.out.println("String: "+data+" is not palindrome.");
		}
	}

	/**
	 * @param data
	 * @return
	 */
	private static boolean isPalindrome(String data) {
		// input validation
		if(data == null || data.length() == 1) {
			return false;
		}
		int start = 0;
		int end = (data.length()-1);
		while(start < end) {
			if(data.charAt(start) != data.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
