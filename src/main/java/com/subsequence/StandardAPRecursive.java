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
 * -> Space complexity:	O(m+n)
 * -> Auxiliary space: O(m+n)
 */
public class StandardAPRecursive {

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
		if((s1 != null && s2 != null) && isSubsequence(s1, s1.length(), s2, s2.length())) {
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
	private static boolean isSubsequence(String s1, int len1, String s2, int len2) {
		// input validation
		if(len1 < len2) {
			return false;
		}
		// if s2 has been exhausted; all characters has been processed
		if(len2 == 0) {
			return true;
		}
		// if s1 has been exhausted; s2 is not subsequence
		if(len1 == 0) {
			return false;
		}
		// start from last characters and move ahead
		// the case when both characters in both strings match
		if(s1.charAt(len1-1) == s2.charAt(len2-1)) {
			return isSubsequence(s1, (len1-1), s2, (len2-1));
		} else {
			// otherwise only s1 elements to be processed further 
			return isSubsequence(s1, (len1-1), s2, len2);
		}
	}

}
