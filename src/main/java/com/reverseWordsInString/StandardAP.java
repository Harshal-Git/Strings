/**
 * 
 */
package com.reverseWordsInString;

/**
 * @author Harshal-Git
 * 
 *	-> reverse the words given in a string. 
 *
 *	-> approach : Reverse each word of the string & then reverse the whole string.
 *
 *	-> base line : words are separated by single space. and given string has no leading / trailing spaces.
 *
 *	ex:
 *		i/p: welcome to home	=> o/p: home to welcome
 *
 *		i/p: i like coding	=> o/p: coding like i
 *
 *		i/p: abc	=> o/p: abc
 *
 * -> Time complexity:	O(n) [reverse whole string] + O(n) [reverse each word] ~ O(n)  
 * -> Space complexity: 0(n) [string to char array conversion; can be avoided if input is char array itself]	
 * -> Auxiliary space: 0(1) [string to char array conversion; can be avoided if input is char array itself]
 */
public class StandardAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String data = null;

		// case 1
		data ="I am at home."; 
		printReversedWords(data);

		// case 2
		data ="I like coding."; 
		printReversedWords(data);

		// case 3
		data ="Java"; 
		printReversedWords(data);

		// case 4
		data ="Welcome to home."; 
		printReversedWords(data);
	}

	/**
	 * @param data
	 */
	private static void printReversedWords(String data) {
		char [] charData = data.toCharArray();
		int size = charData.length;
		System.out.println("\nString : "+String.valueOf(charData));
		
		// reverse words in place
		reverseWords(charData, (size-1));
		
		// reverse the whole array
		reverse(charData, 0, (size-1));		

		// print reversed data
		System.out.println("Reversed words string : "+String.valueOf(charData));		
	}

	/**
	 * method to reverse words; delimited by a space
	 * @param charData - string in char array format
	 * @param size - length of the string
	 */
	private static void reverseWords(char[] charData, int size) {
		// reverse words in place
		int start = 0; 
		int index = 0;
		// iterate till the last word
		while(index != size) {
			if(charData[index] == ' ') {
				reverse(charData, start, (index-1));
				start = (index+1);
			}
			index++;
		}
		// reverse remaining words
		reverse(charData, start, size);
	}

	/**
	 * method to reverse the characters from given array based
	 * on given position
	 * @param data - string data
	 * @param start - start position
	 * @param end - end position
	 */
	private static void reverse(char[] data, int start, int end) {
		char tempChar = '\0';
		while(start <= end) {
			tempChar = data[start];
			data[start] = data[end];
			data[end] = tempChar;
			start++;
			end--;
		}
	}
}
