package com;

import java.io.IOException;

public class UniqueMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		if( args.length != 2){
			System.out.println( "usage: UniqueMain <path_to_file> TopNumber" );
			return;
		}
		
		UniqueParser parser = new UniqueParser(args[0]);
		parser.print(Integer.parseInt(args[1]));
		
		
	}

}
