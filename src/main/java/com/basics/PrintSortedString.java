/**
 * 
 */
package com.basics;

/**
 * @author Harshal-Git
 *
 *	-> print given string in sorted manner of it's characters
 *
 * -> Time complexity:	O(n) [to process characters for string length] + O(n^2) [print characters as per the frequency] 
 * 						~ O(n^2)
 * 
 * -> Space complexity:	0(1)
 * -> Auxiliary space: 0(1) - constant size storage in the array
 */
public class PrintSortedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "geeksforgeeks";
		System.out.println("String: "+s);
		// this makes default frequencies 0
		int [] count = new int[26];

		// re-index each character and set the difference 
		// in the array by incrementing default frequency
		System.out.print("Sorted string based on characters: ");
		for(int index = 0; index < s.length(); index++) {
			// here the conversion from 'char' to 'int' happens automatically
			count[s.charAt(index) - 'a']++;	
		}
		// printing frequency with character value
		int loopIndex = -1;
		for(int index = 0; index < 26; index++) {
			loopIndex = 0;
			while(loopIndex < count[index]) {
				System.out.print((char)(index+'a'));
				loopIndex++;
			}
		}
	}
}