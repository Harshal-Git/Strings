/**
 * 
 */
package com.patternSearching;

/**
 * @author Harshal-Git
 *
 *	-> Given 2 strings as input : data & a pattern. Find the position of the pattern from given data.
 *
 *	-> base line: if lengths of data is (n) & length of pattern is (m); then 1 <= m <= n.
 *
 * 	-> naive approach : window matching of pattern with given data.
 * 
 * 	ex:
 * 		i/p : data = GEEKSFORGEEKS & pattern = EKS	=> o/p : 2 10 (starting position of pattern in data)
 * 
 * -> Time complexity:	O(m) * O(n) [m - source data length, n - pattern data length] 
 * -> Space complexity:	0(m)+0(n)
 * -> Auxiliary space: 0(1)
 */
public class NaiveAP1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String data = null, pattern = null;

		// case 1
		data = "GEEKSFORGEEKS";
		pattern = "EKS";
		printMessage(data, pattern);

		// case 2
		data = "AAAAA";
		pattern = "AAA";
		printMessage(data, pattern);
		
		// case 3
		data = "ZZZZZZZZ";
		pattern = "ZZ";
		printMessage(data, pattern);
		
		// case 4
		data = "ABCABCD";
		pattern = "ABD";
		printMessage(data, pattern);
		
		// case 5
		data = "ABABABCD";
		pattern = "ABAB";
		printMessage(data, pattern);
		
		// case 6
		data = "ABCABCD";
		pattern = "ABCD";
		printMessage(data, pattern);
	}

	/**
	 * @param data
	 * @param pattern
	 */
	private static void printMessage(String data, String pattern) {
		if(data == null || pattern == null) {
			System.out.println("Invalid inputs.");
			return;
		} 
		System.out.println("\n\nData = "+data+" => Pattern = "+pattern);
		System.out.print("Matching positions = ");
		findPattern(data, pattern);
	}

	/**
	 * method to find positions of the pattern
	 * @param data - source data
	 * @param pattern - pattern to be found from source data
	 */
	private static void findPattern(String data, String pattern) {
		// size
		int dataSize = data.length();
		int patSize = pattern.length();

		// iterate over all elements 
		int index = 0;
		boolean patternFound = false;
		while((index+(patSize-1)) <= (dataSize-1)) {
			// match the string window
			if(matchDataWindow(data, pattern, index, (index+(patSize-1)))) {
				patternFound = true;
				System.out.print(index+" ");
			}
			index++;
		}
		// if no pattern is found ever
		if(!patternFound) {
			System.out.print("Pattern not present.");
		}
	}

	/**
	 * method to match window of source with pattern data
	 * @param data - source data
	 * @param pattern - pattern data
	 * @param start - start position of the source data window
	 * @param end - end position of the source data window
	 * @return - true : if in given window complete pattern matches. false otherwise 
	 */
	private static boolean matchDataWindow(String data, String pattern, int start, int end) {
		int patternIndex = 0;
		// iterate over complete window to find whether characters matches
		for(int index = start; index <= end; index++) {
			if(data.charAt(index) != pattern.charAt(patternIndex)) {
				return false;
			} 
			patternIndex++;
		}
		// all characters in given window matches
		return true;
	}

}
