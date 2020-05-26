package Strings;
import java.util.*;
/*
 * https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
 * Time Complexity: O(n)
 */
public class S003_PrintAllDuplicatesInaString {

	public HashMap<Character, Integer> printDuplicateCharWithCount(String s){
		int  i = 0;
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		
		while(i < s.length()){
		
			char c = s.charAt(i);
			if(h.containsKey(c)){
				int value = h.get(c);
				h.put(c, ++value);
			}
			else {
				h.put(c, 1);
			}
			
			i++;
		}
		return h;
	}
	
	public static void main(String[] args) {
		S003_PrintAllDuplicatesInaString obj = new S003_PrintAllDuplicatesInaString();
		String s = "geeksforgeeks";
		HashMap<Character, Integer> mp = obj.printDuplicateCharWithCount(s);
		Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
}
