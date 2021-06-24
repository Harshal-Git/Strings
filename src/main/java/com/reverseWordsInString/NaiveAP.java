/**
 * 
 */
package com.reverseWordsInString;

import java.util.Arrays;

/**
 * @author Harshal-Git
 * 
 *	-> reverse the words given in a string. 
 *
 *	ex:
 *		i/p: welcome to home	=> o/p: home to welcome
 *
 *		i/p: i like coding	=> o/p: coding like i
 *
 *		i/p: abc	=> o/p: abc
 *
 *	-> really no need to calculate time / space complexity
 */
public class NaiveAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String data = null;

		// case 1
		data ="I am home"; 
		printReversedWords(data);
		
		// case 2
		data ="i like coding"; 
		printReversedWords(data);
		
		// case 3
		data ="java"; 
		printReversedWords(data);
		
		// case 4
		data ="welcome to home"; 
		printReversedWords(data);
	}

	/**
	 * @param data
	 */
	private static void printReversedWords(String data) {
		if(data != null) {
			char [] charData = data.toCharArray();
			int size = charData.length;
			System.out.println("\nString : "+Arrays.toString(charData));
			// reverse the whole array
			reverse(charData, 0, (size-1));		
			// reverse words in place
			reverseWords(charData, size);
		} else {
			System.out.println("Invalid input.");
		}
	}

	/**
	 * @param charData
	 * @param size 
	 */
	private static void reverseWords(char[] charData, int size) {
		// reverse words in place
		int start = 0; 
		int end = 0; 
		int index = 0;
		boolean multiWords = false;
		// iterate till the start reaches end of the array
		while(index != (size-1)) {
			if(charData[index] == ' ') {
				multiWords = true;
				end = (index-1);
				reverse(charData, start, end);
				end = (index+1);
				start = (index+1);
			}
			index++;
		}
		// reverse remaining words
		if((start != index) && (multiWords)) {
			reverse(charData, start, (size-1));
		}
		// if single word exist in the string
		if(!multiWords) {
			reverse(charData, 0, (size-1));
		}
		System.out.println("Reversed words string : "+Arrays.toString(charData));		
	}

	/**
	 * @param data
	 * @param start
	 * @param end
	 */
	private static void reverse(char[] data, int start, int end) {
		char tempChar;
		while(start <= end) {
			tempChar = data[start];
			data[start] = data[end];
			data[end] = tempChar;
			start++;
			end--;
		}
	}
}
