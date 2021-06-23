/**
 * 
 */
package com.basics;

/**
 * @author Harshal-Git
 *
 *	-> frequency count from string
 *	
 *	-> base line : if all characters are either lower case OR upper case & they are contiguous (without space / extra characters), 
 *					then only this approach should be used.  
 *
 * -> Time complexity:	O(n) [to process characters for string length] + 0(1) [to iterate the frequency array] 
 * 						~ O(n)
 * 
 * -> Space complexity:	0(1)
 * -> Auxiliary space: 0(1) - constant size storage in the array
 * 
 * 	-> using character ASCII value difference as an index of the array.
 */
public class CharFrequencyInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "geeksforgeeks";
		System.out.println("String: "+s+"\nCharacters frequency: ");
		// this makes default frequencies 0
		int [] count = new int[26];

		// re-index each character and set the difference 
		// in the array by incrementing default frequency  
		for(int index = 0; index < s.length(); index++) {
			// here the conversion from 'char' to 'int' happens automatically
			count[s.charAt(index) - 'a']++;	
		}
		// printing frequency with character value
		for(int index = 0; index < 26; index++) { 
			if(count[index] > 0) {
				System.out.println((char)(index+'a')+" -> "+count[index]); 
			} 
		}
	}
}