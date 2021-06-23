/**
 * 
 */
package com.anagram;

/**
 * @author Harshal-Git
 *
 *	-> Check whether given strings are anagram OR not. 
 *		Anagram : Both string are permutation of each other having same frequency of characters.
 *
 *	-> Naive solution : sort both strings & if they become same; they are anagrams. Time complexity = O(n * log n)
 *
 *	-> anagram example
 *
 *		i/p : s1 = listen & s2 = silent => o/p : Yes
 *
 *		i/p : s1 = aaacb & s2 = cabaa => o/p : Yes
 *
 *		i/p : s1 = aab & s2 = bab => o/p : No
 * 
 * -> Time complexity:	0(n) [both string frequency preparation] + O(n) [count check] ~ O(n) 
 * -> Space complexity:	O(1) [count array constant space]
 * -> Auxiliary space: O(1) [count array constant space]
 */
public class StandardAP {

	public static final int CHAR_MAX = 256;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = null, s2 = null;

		// case 1
		s1 = "listen";
		s2 = "silent";
		printMessage(s1, s2);

		// case 2
		s1 = "aaacb";
		s2 = "cabaa";
		printMessage(s1, s2);

		// case 3
		s1 = "aab";
		s2 = "bab";
		printMessage(s1, s2);
	}

	/**
	 * @param s1
	 * @param s2
	 */
	private static void printMessage(String s1, String s2) {
		if(areAnagrams(s1, s2)) {
			System.out.println("\nString '"+s1+"' & '"+s2+"' are anagrams.");
		} else {
			System.out.println("\nString '"+s1+"' & '"+s2+"' are not anagrams.");
		}
	}

	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean areAnagrams(String s1, String s2) {
		// input validation
		if(s1 == null || s2 == null) {
			return false;
		}
		// length validation
		if(s1.length() != s2.length()) {
			return false;
		}
		// fixed size count array
		int count[] = new int[CHAR_MAX];
		// one string character will increment the count & 
		// second string character will decrement the count
		for(int index = 0; index < s1.length(); index++) {
			// auto conversion from 'char' to 'int' 
			count[s1.charAt(index)]++;	
			count[s2.charAt(index)]--;
		}
		// at the end, whole count array needs to be 0 for anagram strings
		for(int index = 0; index < count.length; index++) {
			if(count[index] != 0) {
				return false;
			}
		}
		// default return
		return true;
	}
}
