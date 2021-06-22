/**
 * 
 */
package com.basics;

/**
 * @author Harshal-Git
 *
 *	-> how string references are being used 
 */
public class StringReferenceCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 ="hello";
		
		String s2 = "hello";
		
		System.out.println("S1 = "+s1+" & S2 = "+s2+" (literals)");
		
		if(s1 == s2) {
			System.out.println("S1 & S2 has same addresses.");
		} else {
			System.out.println("S1 & S2 has different addresses.");
		}
		
		String s3 = new String("hello");
		System.out.println("\nS3 (new) = "+s3);
		if(s1 == s3) {
			System.out.println("S1 & S3 has same addresses.");
		} else {
			System.out.println("S1 & S3 has different addresses.");
		}
		
	}

}
