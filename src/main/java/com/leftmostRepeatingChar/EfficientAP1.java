/**
 * 
 */
package com.leftmostRepeatingChar;

/**
 * @author Harshal-Git
 *
 *	-> Find the left most OR the first most character which is repeated. The string index starts from 0.
 *	
 *	-> Efficient approach 1 : find the frequency of character & store it as index of the array. later iterate over the given array 
 *							and find first ever element whose index is greater than 1.
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
		System.out.println("\nLeft most repeating character in '"+data+"' => "
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
		// find first ever element from string which has frequency greater than 1
		for(int index = 0; index < data.length(); index++) {
			if(freq[data.charAt(index)] > 1) {
				return index;
			}
		}
		// when all characters are distinct
		return -1;
	}
}
