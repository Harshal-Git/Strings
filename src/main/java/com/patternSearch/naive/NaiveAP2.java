/**
 * 
 */
package com.patternSearch.naive;

/**
 * @author Harshal-Git
 *
 *	-> Given 2 strings as input : data & a pattern. Find the position of the pattern from given data. This pattern has all 
 *		distinct characters.
 *
 *	-> base line: if lengths of data is (n) & length of pattern is (m); then 1 <= m <= n.
 *
 * 	-> naive approach : window matching of pattern with given data.
 * 
 * 	ex:
 * 		i/p : data = GEEKSFORGEEKS & pattern = EKS	=> o/p : 2 10 (starting position of pattern in data)
 * 
 * -> Time complexity:	O(m) [m - source data length, n - pattern data length]
 * 		[internal loop iterates for 'X'; then outer loop will skip those 'X' iterations further. So overall it becomes of the full
 * 		length of the source data.]
 *  
 * -> Space complexity:	0(m)+0(n) [string storage]
 * -> Auxiliary space: 0(1)
 */
public class NaiveAP2 {

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
		data = "ABCABCD";
		pattern = "ABD";
		printMessage(data, pattern);
		
		// case 3
		data = "ABABABCD";
		pattern = "AB";
		printMessage(data, pattern);
		
		// case 4
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

		// iterate over source  
		int index = 0, pIndex = 0;
		boolean patternFound = false;
		while((index+(patSize-1)) <= (dataSize-1)) {
			// match the pattern in source window
			for(pIndex = 0; pIndex < patSize; pIndex++) {
				if(data.charAt(index+pIndex) != pattern.charAt(pIndex)) {
					break;
				}
			}
			// full pattern matched
			if(pIndex == patSize) {
				patternFound = true;
				System.out.print(index+" ");
			} 
			// not a single character matched
			if(pIndex == 0) {
				index++;
			} else {
				// few characters matched; so move ahead 
				// by that much position 
				index = (index+pIndex);
			}
		}
		// if no pattern matched
		if(!patternFound) {
			System.out.print("Pattern not present.");
		}
	}
}
