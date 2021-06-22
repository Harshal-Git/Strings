/**
 * 
 */
package com.subsequence;

/**
 * @author Harshal-Git
 *
 *	-> checking whether given strings is a subsequence of another string OR not.
 *
 * 	-> Subsequences of any string (ABC) = ["", A, B, C, AB, AC, BC, ABC]
 * 		If string is of length 'n', then total number of subsequences are (2^n). 
 *
 *	-> ex:
 *
 *		i/p:  s1 = ABCD & s2 = AD 	==>  o/p:  true
 *
 *		i/p:  s1 = ABCDE & s2 = AED ==>  o/p:  false
 *
 * -> Time complexity:	O(n) [s1 length] + O(n) [s2 length] ~ O(m+n)
 * -> Space complexity:	0(1)
 * -> Auxiliary space: 0(1)
 */
public class StandardAPIterative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = null, s2 = null;

		// case 1
		s1 = "ABCD";
		s2 = "AD";
		printMessage(s1, s2);

		// case 2
		s1 = "ABCDE";
		s2 = "AED";
		printMessage(s1, s2);

		// case 3
		s1 = "GEEKSFORGEEKS";
		s2 = "GRGES";
		printMessage(s1, s2);
		
		// case 4
		s1 = "GEEKSFORGEEKS";
		s2 = "GRGESK";
		printMessage(s1, s2);
	}

	/**
	 * @param s1
	 * @param s2
	 */
	private static void printMessage(String s1, String s2) {
		if(isSubsequence(s1, s2)) {
			System.out.println("\nString - "+s2+" is subsequence of String - "+s1);
		} else {
			System.out.println("\nString - "+s2+" is not a subsequence of String - "+s1);
		}
	}

	/**
	 * method to check whether s2 is a subsequence of s1 OR not
	 * @param s1
	 * @param s2
	 * @return - true if s2 subsequence of s1; false otherwise
	 */
	private static boolean isSubsequence(String s1, String s2) {
		// input validation
		if(s1 == null || s2 == null) {
			return false;
		}
		// check inputs order is correct
		if(s1.length() < s2.length()) {
			return false;
		}
		// initializations
		int index1 = 0, index2 = 0;
		int len1 = (s1.length()-1), len2 = (s2.length()-1);
		// iterate until either of the string is processed
		while(index1 <= len1 && index2 <= len2) {
			if(s1.charAt(index1) == s2.charAt(index2)) {
				index2++;
			} 
			index1++;
		}
		// if both indexes becomes same as length; all characters 
		// are successfully processed; return TRUE
		return (index1 == s1.length() && index2 == s2.length());
	}

}
