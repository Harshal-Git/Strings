/**
 * 
 */
package com.leftmostRepeatingChar;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Find the left most OR the first most character which is repeated. The string index starts from 0.
 *	
 *	-> Efficient approach 2 : set the index of current character in an array of index which has all initial indexes as -1.
 *							keep iterating through all elements and find the lowest value of the index occurring till now.
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
 * -> Time complexity:	0(256) [for filling the array] + 0(n) [iterating through all characters] ~ 0(n)
 * -> Space complexity:	O(1)
 * -> Auxiliary space: O(1)
 */
public class EfficientAP2 {

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
		// initialize index array & fill all indexes as -1 initially
		int [] indexArr = new int[256];
		Arrays.fill(indexArr, -1);

		// iterate through all characters and set it's index 
		// in index array using character value as index
		int lowestIndex = Integer.MAX_VALUE;
		for(int index = 0; index < data.length(); index++) {
			// if current character index doesn't exist in the array; fill it
			if(indexArr[data.charAt(index)] == -1) {
				indexArr[data.charAt(index)] = index;
			} else {
				// if current element index exist in the array; find the lowest most index
				lowestIndex = findMin(lowestIndex, indexArr[data.charAt(index)]);
			}
		}
		// if lowest index is still MAX_VALUE; means all elements are distinct
		return ((lowestIndex == Integer.MAX_VALUE) ? (-1) : (lowestIndex));
	}

	/**
	 * @param lowestIndex
	 * @param i
	 * @return
	 */
	private static int findMin(int num1, int num2) {
		return ((num1 > num2) ? (num2) : (num1));
	}
}
