package com;

import java.io.IOException;

public class PalindromeMain {

	public static void main(String[] args) throws IOException {

		if( args.length != 1){
			System.out.println( "usage: PalindromeMain <word>" );
			return;
		}
		
		checkWord(args[0]);
	}
	
	private static void checkWord(String word){
		boolean result = true;
		char[] charArray = word.toCharArray();
		int fromEnd = (charArray.length / 2 );
		for( int i=0; i < fromEnd ; i++){
			if( charArray[i] == charArray[charArray.length -1 - i] ) continue;
			else{
				result = false;
				break;
			}
		}
		
		System.out.println("Result of checking is word " + word + " palindrome = " + result);
	}
}
