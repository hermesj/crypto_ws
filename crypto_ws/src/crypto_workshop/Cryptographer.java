package crypto_workshop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/** A collection of basic encryption methods in Java.
 * Implemented for the CryptoWorkshop of the SSK-Stiftung
 * 2015-09-05
 * @author jhermes
 */
public class Cryptographer {
	
	/**
	 * Lower cases text and replaces umlauts with ASCII/128 chars
	 * @param text to process
	 * @return lower case text without umlauts 
	 */
	public static String normalize(String text){
		text = text.toLowerCase();
		text = text.replaceAll("ä", "ae");
		text = text.replaceAll("ö", "oe");
		text = text.replaceAll("ü", "ue");
		text = text.replaceAll("ß", "ss");		
		return text;
		
	}
	
	/**
	 * Encodes one character with the specified ROT method
	 * @param ch Character to encode
	 * @param rot Value of ROT method
	 * @return encoded character
	 */
	public static char encodeChar(char ch, int rot){
		
		int chValue = ch;
		
		if(chValue<'a'||chValue>'z'){
			return ch;
		}
		
		chValue = chValue +rot;
		if(chValue>'z'){
			chValue = chValue - 26;
		}
		
		return (char) chValue;
	}
	
	/**
	 * Decodes one character with the specified ROT method
	 * @param ch Character to decode
	 * @param rot Value of ROT method
	 * @return decoded character
	 */
	public static char decodeChar(char ch, int rot){
		
		int chValue = ch;
		
		if(chValue<'a'||chValue>'z'){
			return ch;
		}	
		
		chValue = chValue -rot;
		if(chValue<'a'){
			chValue = chValue + 26;
		}
		return (char) chValue;
	}
	
	public static void countLetters(String text){
		Map<Character, Integer> counts = new HashMap<Character,Integer>();
		
		for(int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			Integer count = counts.get(ch);
			if(count==null){
				count = 0;
			}
			counts.put(ch, count+1);			
		}
		Map<Integer, List<Character>> countsInOrder = new TreeMap<Integer, List<Character>>();
		Set<Character> keySet = counts.keySet();
		for (Character ch : keySet) {
			Integer count = counts.get(ch);
			List<Character> list = countsInOrder.get(count);
			if(list==null){
				list = new ArrayList<Character>();
			}
			list.add(ch);
			countsInOrder.put(count, list);
		}		
		List<Integer> result = new ArrayList<Integer>(countsInOrder.keySet());
		Collections.reverse(result);
		for (Integer integer : result) {
			System.out.println(integer + ":\t" + countsInOrder.get(integer));
		}
		System.out.println();
	}
	
	public static void countTwins(String text){
		Map<String, Integer> counts = new HashMap<String,Integer>();
			
		for(int i=0; i<text.length()-1; i++){
			String bigram = text.substring(i, i+2);
			if(bigram.charAt(0)==bigram.charAt(1)){
				Integer count = counts.get(bigram);
				
				if(count==null){
					count = 0;
				}
				counts.put(bigram, count+1);	
			}
			
					
		}
		Map<Integer, List<String>> countsInOrder = new TreeMap<Integer, List<String>>();
		Set<String> keySet = counts.keySet();
		for (String s : keySet) {
			Integer count = counts.get(s);
			List<String> list = countsInOrder.get(count);
			if(list==null){
				list = new ArrayList<String>();
			}
			list.add(s);
			countsInOrder.put(count, list);
		}		
		List<Integer> result = new ArrayList<Integer>(countsInOrder.keySet());
		Collections.reverse(result);
		System.out.println("Doppelbuchstaben nach Häufigkeit: ");
		for (Integer integer : result) {
			System.out.println(integer + ":\t" + countsInOrder.get(integer));
		}
		System.out.println();
	}
	
	public static void countBigrams(String text){
		Map<String, Integer> counts = new HashMap<String,Integer>();
				
		for(int i=0; i<text.length()-1; i++){
			String bigram = text.substring(i, i+2);
			
			Integer count = counts.get(bigram);
			if(count==null){
				count = 0;
			}
			counts.put(bigram, count+1);			
		}
		Map<Integer, List<String>> countsInOrder = new TreeMap<Integer, List<String>>();
		Set<String> keySet = counts.keySet();
		for (String s : keySet) {
			Integer count = counts.get(s);
			List<String> list = countsInOrder.get(count);
			if(list==null){
				list = new ArrayList<String>();
			}
			list.add(s);
			countsInOrder.put(count, list);
		}		
		List<Integer> result = new ArrayList<Integer>(countsInOrder.keySet());
		Collections.reverse(result);
		System.out.println("Bigramme nach Häufigkeit: ");
		for (Integer integer : result) {
			System.out.println(integer + ":\t" + countsInOrder.get(integer));
		}
		System.out.println();
	}
}
