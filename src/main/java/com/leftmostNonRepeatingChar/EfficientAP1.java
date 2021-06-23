/**
 * 
 */
package com.leftmostNonRepeatingChar;

/**
 * @author Harshal-Git
 *
 *	-> Find the left most OR the first most character which does not repeat in given string. The string index starts from 0.
 *	
 *	-> Efficient approach 1 : find the frequency of character & store it as index of the array. later iterate over the given array 
 *							and find first ever element whose index is equal to 1.
 *
 * 	ex:
 * 		i/p : geeksforgeeks	=> o/p : 5	['f' is the first ever character which is non repeated]
 * 
 * 		i/p : abcabc	=> o/p : -1	[all are repeated]
 * 
 * 		i/p : apple	=> o/p : 0	[a's occurrence : left most non repeating]
 * 
 * -> Time complexity:	0(n) [preparing frequency array] + 0(n) [finding first occurring element] ~ 0(n)
 * -> Space complexity:	0(1)
 * -> Auxiliary space: 0(1)
 */
public class EfficientAP1 {

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
		System.out.println("\nLeft most non-repeating character in '"+data+"' => "
					+findLeftMostRepeatingIndex(data));
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
		// prepare frequency array
		int [] freq = new int[256]; 
		for(int index = 0; index < data.length(); index++) {
			freq[data.charAt(index)]++;
		}
		// find first ever element from string which has frequency is equal to 1
		for(int index = 0; index < data.length(); index++) {
			if(freq[data.charAt(index)] == 1) {
				return index;
			}
		}
		// if characters are repeated
		return -1;
	}
}
