/**
 * 
 */
package com.checkRotation;

/**
 * @author Harshal-Git
 *
 *	-> Given 2 string (S1 & S2)and we need to find whether S2 can be achieved from S1 via performing 'X' number of 
 *		rotations OR not. 
 *
 *	-> These rotations can be either left OR right for 'X' number of times. 'X' is not to be found here. 
 *
 * 	ex:
 * 
 * 		i/p : S1 = ABCD & S2 = CDAB	=> o/p : Yes (ABCD -> BCDA -> CDAB) [perform left rotation 3 times]
 * 
 * 		i/p : S1 = ABAAA & S2 = BAAAA	=> o/p : Yes (ABAAA -> BAAAA) [perform left rotation once]
 * 
 * 		i/p : S1 = ABAB & S2 = ABBA	=> o/p : No 
 * 
 * 	-> contact S1 with itself. If the resulting string contains S2 then they are in rotation. Otherwise they are not.
 * 
 * 	-> To be in rotation of each other; length of both strings needs to be same. 
 * 
 * -> Time complexity:	O(n) [Concatenation] + O(n) [index of function] ~ O(n) [n - length of S1]
 * -> Space complexity:	O(n) [S1] + O(n) [S2] ~ O(n) 
 * -> Auxiliary space: O(n) [resulting Concatenation]
 */
public class EfficientAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = null, s2 = null;
		
		// case 1
		s1 = "ABCD";
		s2 = "CDAB";
		printMessage(s1, s2);

		// case 2
		s1 = "ABAAA";
		s2 = "BAAAA";
		printMessage(s1, s2);
		
		// case 3
		s1 = "ABAB";
		s2 = "ABBA";
		printMessage(s1, s2);
	}

	/**
	 * @param s1
	 * @param s2
	 */
	private static void printMessage(String s1, String s2) {
		// validation
		if(s1 == null || s2 == null) {
			System.out.println("Invalid input.");
		}
		System.out.println("\nIf S1="+s1+" & S2="+s2+" are in rotation? "+findRotation(s1, s2));
	}

	/**
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean findRotation(String s1, String s2) {
		// if length doesn't match
		if(s1.length() != s2.length()) {
			return false;
		} 
		return (s1.concat(s1).indexOf(s2) >= 0);
	}

}
