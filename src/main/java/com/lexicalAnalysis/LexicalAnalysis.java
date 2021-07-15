/**
 * 
 */
package com.lexicalAnalysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Harshal-Git
 *
 *	-> given string of different parenthesis and needs to be evaluated whether 
 *		those strings are balanced OR not.
 *
 *	-> Valid balance: all opened parenthesis needs to be ended.
 *	-> Invalid balance: all / some parenthesis are not properly ended.
 *
 *	Ex: 
 *
 *	i/p: {()({})[({})]}		=> Valid 
 *
 *	i/p: {()({))[({})]}		=> Invalid
 *
 * -> Time complexity:	0(1) - for hashmap preparation + 0(n) - iterating through all symbols in given string ~ 0(n)
 * -> Space complexity:	O(n/2) - max half length string can be saved into stack ~ O(n)
 * -> Auxiliary space: O(n/2) ~ O(n)
 */
public class LexicalAnalysis {

	public static Map<Character, Character> openMap = new HashMap<>();
	static {
		openMap.put('{', '}');
		openMap.put('[', ']');
		openMap.put('(', ')');
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String input = null; 

		// case 1
		input = "{()({})[({})]}";
		System.out.println("\nInput string: "+input+" is balanced? "+isBalanced(input));

		// case 2
		input = "{()({))[({})]}";
		System.out.println("\nInput string: "+input+" is balanced? "+isBalanced(input));
	}

	/**
	 * @param input
	 * @return
	 */
	private static boolean isBalanced(String input) {
		// input validation
		if(input == null) {
			return false;
		}
		// prepare stack to register all opening symbols
		Stack<Character> dataStack = new Stack<>();
		Character currentChar = null;
		// iterate over string for each symbol
		for(int i = 0; i < input.length(); i++) {
			currentChar = input.charAt(i);
			// for opening symbol: push into stack
			if(openMap.containsKey(currentChar)) {
				dataStack.push(currentChar);
			} else {
				// for closing symbol : check whether it can close the stack top symbol
				// then pop that symbol
				if(openMap.get(dataStack.peek()) == currentChar) { 
					dataStack.pop();
				}
			}
		}
		// if stack gets empty : string is balanced
		return (dataStack.isEmpty());
	}
}
