/**
 * 
 */
package com.leftmostNonRepeatingChar;

/**
 * @author Harshal-Git
 *
 *	-> Find the left most OR the first most character which does not repeat in given string. The string index starts from 0.
 *
 * 	ex:
 * 
 * 		i/p : geeksforgeeks	=> o/p : 5	['f' is the first ever character which is non repeated]
 * 
 * 		i/p : abcabc	=> o/p : -1	[all are repeated]
 * 
 * 		i/p : apple	=> o/p : 0	[a's occurrence : left most non repeating]
 * 
 * -> Time complexity:	O(n^2)
 * -> Space complexity:	0(1)
 * -> Auxiliary space: 0(1)
 */
public class NaiveAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String data= null;

		// case 1
		data = "geeksforgeeks";
		printMessage(data);

		// case 2
		data = "abcabc";
		printMessage(data);

		// case 3
		data = "apple";
		printMessage(data);

		// case 4
		data = "retreat";
		printMessage(data);
	}

	/**
	 * @param data
	 */
	private static void printMessage(String data) {
		System.out.println("\nLeft most non-repeating character in '"+data
				+"' => "+findLeftMostNonRepeatingIndex(data));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findLeftMostNonRepeatingIndex(String data) {
		// input validation
		if(data == null) {
			return -1;
		}
		// match flag
		boolean matchExist = false;
		// outer loop
		for(int outerI = 0; outerI < data.length(); outerI++) {
			matchExist = false;
			// inner loop
			for(int innerI = 0; innerI < data.length(); innerI++) {
				// if any character matches with existing character
				// not to make self comparison
				if((outerI != innerI) && (data.charAt(outerI) == data.charAt(innerI))) {
					matchExist = true;
					break;
				}
			}
			// if match doesn't exist, return the index
			if(!matchExist) {
				return outerI;
			}
		}
		// default return : elements matches
		return -1;
	}
}
