/**
 * 
 */
package com.leftmostNonRepeatingChar;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Find the left most OR the first most character which does not repeat in given string. The string index starts from 0.
 *	
 *	-> Efficient approach 2 : initialize an index array for which all elements are initially -1. then following steps needs to be
 *								performed.
 *
 *			1. for any char index; array value is -1, then it appeared first time. so set it's proper index.
 *
 *			2. for any char index; array value is not -1; that means it's repeated. so set it's value to -2.
 *
 *  		3. for any char index; if it's value is -2; don't process such element.
 *
 *			4. at last; iterate through the index array and find the lowest positive value. 
 *
 * 	ex:
 * 		i/p : geeksforgeeks	=> o/p : 5	['f' is the first ever character which is non repeated]
 * 
 * 		i/p : abcabc	=> o/p : -1	[all are repeated]
 * 
 * 		i/p : apple	=> o/p : 0	[a's occurrence : left most non repeating]
 * 
 * -> Time complexity:	O(1) [array filler] + 0(n) [preparing frequency array] + O(1) [finding lowest +ve index] ~ O(n)
 * -> Space complexity:	0(1)
 * -> Auxiliary space: 0(1)
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
		// index array; initialized with -1
		int [] indexArr = new int[256];
		Arrays.fill(indexArr, -1);
		
		// iterate through the string data
		for(int index = 0; index < data.length(); index++) {
			// appearing first time
			if(indexArr[data.charAt(index)] == -1) {
				indexArr[data.charAt(index)] = index;
			} else {
				// appearing second OR more time
				indexArr[data.charAt(index)] = -2;
			}
		}
		// iterate over the given array now and find lowest positive index
		// index can be also 0
		int lowestIndex = Integer.MAX_VALUE;
		for(int index = 0; index < 256; index++) {
			if(indexArr[index] >= 0) {
				lowestIndex = findMin(lowestIndex, indexArr[index]);
			}
		}
		// return the lowest index (if present)
		return ((lowestIndex == Integer.MAX_VALUE) ? (-1) : (lowestIndex));
	}

	/**
	 * @param num1
	 * @param num2
	 * @return
	 */
	private static int findMin(int num1, int num2) {
		return ((num1 < num2) ? (num1) : (num2));
	}
}
