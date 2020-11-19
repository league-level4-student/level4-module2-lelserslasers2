package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.


HINT:  Here are some String methods you might find useful
contains
replace
trim
length
getBytes
endsWith
split
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length())
		{
			return s1;
		}
		return s2;
	}


	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {

		char[] sList = s.toCharArray();


		if (s.contains("underscores"))
		{
			System.out.println("AHAHH");
			for (int i = 0; i < s.length(); i++) {

				if (sList[i] == ' ') {
					System.out.println("YOS");
					sList[i] = '_';

				}
			}
		}
		String output = "";
		for (int i = 0; i < sList.length; i++) {
			output = output + sList[i];


		}
		System.out.println(output);
		return output;
	}


	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();
		
		char[] s1List = s1.toCharArray();
		char[] s2List = s2.toCharArray();
		char[] s3List = s3.toCharArray();

		char s1Let = ' ';
		char s2Let = ' ';
		char s3Let = ' ';

		for (int i = 0; i < s1.length(); i++) {
			if (s1List[i] == ' '){
				System.out.println(i);
				s1Let = s1.charAt(i + 1);
				System.out.println("AHHHHHHHo");
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (s2List[i] == ' '){
				s2Let = s2.charAt(i + 1);
			}
		}
		for (int i = 0; i < s3.length(); i++) {
			if (s3List[i] == ' '){
				s3Let = s3.charAt(i + 1);
			}
		}

		if (s1Let < s2Let){
			if (s1Let < s3Let){
				return s1;
			}
			else {
				return s3;
			}
		}
		else 
			if (s2Let < s3Let){
				return s2;
			}
			else {
				return s3;
			}

	}


	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			try {
				sum = sum +  Integer.parseInt(String.valueOf(s.charAt(i)));
			}
			catch(Exception e) {
				
			}
		}
		
		return sum;
	}


	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		
		System.out.println("substringCount");
		
		int count = 0;
		int a = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			boolean flag = true;
			
			for (int j = 0; j < substring.length(); j++) {
				
				a = i;
				
				if (s.charAt(i) != substring.charAt(j)) {
					flag = false;
				}
				else {
					i = i + 1;
				}
			}
			
			i = a;
			
			if (flag) {
				count = count + 1;
				System.out.println(i);
				System.out.println(a);
			}
			
			
			
		}
		
		
		return count;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return Utilities.encrypt(s.getBytes(), (byte)key);
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return Utilities.decrypt(s, (byte)key);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int count = 0;
		int a = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			boolean flag = true;
			
			for (int j = 0; j < substring.length(); j++) {
				
				a = i;
				
				if (s.charAt(i) != substring.charAt(j)) {
					flag = false;
				}
				else {
					i = i + 1;
				}
				
				
			}
			
			i = a;
			
			if (flag && s.charAt(i + 1) == ' ') {
				count = count + 1;
				System.out.println(i);
				System.out.println(a);
			}
			
			
			
		}
		
		
		return count;
	}


	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		
		
		return 0;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		
		String s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '.' && s.charAt(i) != ',' && s.charAt(i) != ':' && s.charAt(i) != '?' && s.charAt(i) != ' ') {
				s2 = s2 + s.charAt(i);
			}

		}
		
		s = s2.toLowerCase();
		
		System.out.println("---------------------------------");
		
		int counte = 1;
		while (0 < (s.length() - counte)) {	
			System.out.println(s.charAt(counte - 1));
			System.out.println(s.charAt(s.length() - counte));
			if (s.charAt(counte - 1) != s.charAt(s.length() - counte)){
				return false;
			}
			counte = counte + 1;
		}
		
		
		return true;
	}

}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
