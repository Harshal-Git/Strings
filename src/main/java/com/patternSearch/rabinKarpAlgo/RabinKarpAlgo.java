/**
 * 
 */
package com.patternSearch.rabinKarpAlgo;

/**
 * @author Harshal-Git
 *
 *	-> Given 2 strings as input : data & a pattern. Find the position of the pattern from given data.
 *
 *	-> base line: if lengths of data is (n) & length of pattern is (m); then 1 <= m <= n.
 *
 *	-> algo : same as naive approach but comparison will be done of the source window using rolling hash. if hash matches; then individual
 *			characters will be compared.
 *
 *	-> rolling hash function : 
 *	
 *		current window hash = (previous window hash) + (last element of current window) - (first element of previous window)
 *
 * -> Time complexity:	O(m) * O(n) [m - source data length, n - pattern data length] (ignoring the hash computation 
 * 							during initialization & rolling hash computation takes constant time)
 * 
 * -> Space complexity:	0(m)+0(n) [string storage]
 * -> Auxiliary space: 0(1)
 */
public class RabinKarpAlgo {

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
		data = "ABABCD";
		pattern = "AB";
		printMessage(data, pattern);

		// case 4
		data = "ABCABCD";
		pattern = "ABCD";
		printMessage(data, pattern);

		// case 5
		data = "AAAAA";
		pattern = "AAA";
		printMessage(data, pattern);
		
		// case 6
		data = "ZZZZZZZZ";
		pattern = "ZZ";
		printMessage(data, pattern);

		// case 7
		data = "ABABABCD";
		pattern = "ABAB";
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

		// find hash value of pattern
		long patternHash = getHash(pattern, 0, (pattern.length()-1));

		// find hash value of first window from source
		long windowHash = getHash(data, 0, (pattern.length()-1));

		// iterate over source 
		int index = 0, pIndex = 0;
		boolean hashMatched = false, patternFound = false;
		while((index+(patSize-1)) <= (dataSize-1)) {
			// reset hash match
			hashMatched = false;
			// if hash matches for pattern and source window
			if(patternHash == windowHash) {
				hashMatched = true;
				// compare elements if hash matched
				for(pIndex = 0; pIndex < patSize; pIndex++) {
					if(data.charAt(index+pIndex) != pattern.charAt(pIndex)) {
						hashMatched = false;
						break;
					}
				}
			}
			// if hash matched & pattern also matched
			if(hashMatched) {
				System.out.print(index+" ");
				patternFound = true;
			} 
			// use roll-over hash to compute new window hash
			if(index < (dataSize-patSize)) {
				windowHash = getNewHash(windowHash, data.charAt(index), data.charAt(index+patSize));
			}
			// move next 
			index++;
		}
		// if no pattern ever found
		if(!patternFound) {
			System.out.print("Pattern not present.");
		}
	}

	/**
	 * method to calculate hashcode from given string in certain boundary
	 * @param data - string data
	 * @param start - start point
	 * @param end - end point
	 * @return hashcode from given string from start to end
	 */
	private static long getHash(String data, int start, int end) {
		long hashVal = 0;
		for(int index = start; index <= end; index++) {
			hashVal = hashVal+getCharHash((data.charAt(index)));
		}
		return hashVal;
	}
	
	/*
	 * method to calculate hash code for given character
	 * supposed to be weighted hash code calculation; but till 
	 * the code works OK, not changing it.
	 */
	private static long getCharHash(int charASCII) {
		return (charASCII);
	}

	/**
	 * method to calculate rolling hash code 
	 * @param currentHash 
	 * @param currWindowFirstVal - first character of current window
	 * @param newWindowLastVal - last character of new window
	 * @return - updated hash code 
	 */
	private static long getNewHash(long currentHash, char currWindowFirstVal, char newWindowLastVal) {
		return(currentHash - (getCharHash(currWindowFirstVal)) + (getCharHash(newWindowLastVal)));
	}
}
