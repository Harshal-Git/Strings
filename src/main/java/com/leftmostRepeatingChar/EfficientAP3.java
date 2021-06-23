/**
 * 
 */
package com.leftmostRepeatingChar;

/**
 * @author Harshal-Git
 *
 *	-> Find the left most OR the first most character which is repeated. The string index starts from 0.
 *	
 *	-> Efficient approach 3 : iterate through the string characters from right -> left. maintain a boolean array which informs whether
 *							current array is visited OR not. If it's visited; the index should be used. 
 *	
 *	-> this approach is from right -> left; hence the first ever element visited will be identified at last when the string is 
 *		processed from right to left. 
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
 * -> Time complexity:	0(n) [iterating through all characters]
 * -> Space complexity:	O(1)
 * -> Auxiliary space: O(1)
 */
public class EfficientAP3 {

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
		// initialize visited array as FALSE 
		boolean [] visited = new boolean[256];
		int leftMostIndex = -1;

		// iterate through the string and prepare the visited element data
		for(int index = (data.length()-1); index >= 0; index--) {
			// if current element is not visited
			if(visited[data.charAt(index)] == false) {
				visited[data.charAt(index)] = true;
			} else {
				// if current element is visited; set OR updated index
				leftMostIndex = index;
			}
		}
		// return the left most index (iteration happens from right -> left)
		return leftMostIndex;
	}
}
