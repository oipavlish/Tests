package com;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;



public class UniqueParser {

	HashMap< String, Integer> words = new HashMap< String, Integer>();
	ArrayList<String> list = new ArrayList<String>();
	
	public UniqueParser(String path)  throws IOException{
		String text = readDtringFromFile(path);
		String[] wordsRaw = text.split(" ");
		
		buildWords(wordsRaw);
	}
	
	public void print(int topNumber){
		int count = (topNumber < list.size() ) ? topNumber:list.size(); 
		for( int i=0; i<count; i++) {
			System.out.println(list.get(i));
		}
	}
	
	private String readDtringFromFile(String path) throws IOException{
		String line;
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
		    line = br.readLine();
		} finally {
		    br.close();
		}
		return line; 
	}

	private void buildWords(String[] wordsRaw){
		for( int i=0; i<wordsRaw.length; i++ ){
			String tmp = wordsRaw[i].trim();
			if( tmp.length() == 0 ) continue;
			if( !words. containsKey(tmp) ) {
				words.put(tmp, new Integer(1));
				list.add(tmp);
			}
		}
		words = null;
	}
	
}
