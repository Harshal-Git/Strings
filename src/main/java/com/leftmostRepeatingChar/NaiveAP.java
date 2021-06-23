/**
 * 
 */
package com.leftmostRepeatingChar;

/**
 * @author Harshal-Git
 *
 *	-> Find the left most OR the first most character which is repeated. The string index starts from 0.
 *
 * 	ex:
 * 
 * 		i/p : geeksforgeeks	=> o/p : 0	
 * 		[e repeated twice consecutively but 'g' is having first occurrence; hence index of first 'g' = 0]
 * 
 * 		i/p : abbcc	=> o/p : 1	[b's occurrence]
 * 
 * 		i/p : abcd	=> o/p : -1	[no repeating character in the whole string]
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
		data = "abbcc";
		printMessage(data);

		// case 3
		data = "abcd";
		printMessage(data);

		// case 4
		data = "abccbd";
		printMessage(data);
	}

	/**
	 * @param data
	 */
	private static void printMessage(String data) {
		System.out.println("\nLeft most repeating character in '"+data+"' => "+findLeftMostRepeatingIndex(data));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findLeftMostRepeatingIndex(String data) {
		// if data is NULL
		if(data == null) {
			return -1;
		}
		// outer loop
		for(int outerI = 0; outerI < data.length(); outerI++) {
			// inner loop
			for(int innerI = (outerI+1); innerI < data.length(); innerI++) {
				// when characters for both loop becomes same; 
				// return the first ever occurrence
				if(data.charAt(outerI) == data.charAt(innerI)) {
					return outerI;
				}
			}
		}
		// no repeating characters
		return -1;
	}

}
