package com;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Comparator;



public class UniqueParser {

	HashMap< String, Integer> words = new HashMap< String, Integer>();
	Map<String, Integer> sortedMap = null;
	
	public UniqueParser(String path)  throws IOException{
		String text = readDtringFromFile(path);
		String[] wordsRaw = text.split("[ ,.\\n]");
		
		buildWords(wordsRaw);
		sortedMap = 
				words.entrySet().stream()
			    .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                              (e1, e2) -> e1, LinkedHashMap::new));
	}
	 public void print(int top)
	    {
		 int count = 0;
	        for (Entry<String, Integer> entry : sortedMap.entrySet())
	        {
	        	if( count == top) return;
	            System.out.println(entry.getKey() + "="+ entry.getValue());
	            count++;
	        }
	    }

	private String readDtringFromFile(String path) throws IOException{
		String lines = "";
		String line;
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			while( (line = br.readLine() ) != null) {
				lines += line;
			}
		} finally {
		    br.close();
		}
		return lines; 
	}

	private void buildWords(String[] wordsRaw){
		for( int i=0; i<wordsRaw.length; i++ ){
			String tmp = wordsRaw[i].trim();
			if( tmp.length() == 0 ) continue;
			if( !words. containsKey(tmp) ) {
				words.put(tmp, new Integer(1));
			}else{
				Integer count = words.get(tmp);
				count++;
				words.put(tmp, new Integer(count));
			}
		}
	}
	
	 
	
}
