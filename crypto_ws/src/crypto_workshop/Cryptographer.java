package crypto_workshop;

import java.util.ArrayList;
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
	 * Encodes one character with the specified ROT method
	 * @param ch Character to encode
	 * @param rot Value of ROT method
	 * @return encoded character
	 */
	public static char encodeChar(char ch, int rot){
		int chValue = ch;
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
		System.out.println(countsInOrder);
	}
}
