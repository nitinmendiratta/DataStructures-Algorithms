package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/group-shifted-String/
 */
public class S098_GroupShiftedString {

	static int ALPHA = 26;   // Total lowercase letter
	
	// Method to a difference String for a given String.
	// If String is "adf" then difference String will be
	// "cb" (first difference 3 then difference 2)
	public static String getDiffString(String str){
	    String shift = "";
	    for (int i = 1; i < str.length(); i++){
	        int dif = str.charAt(i) - str.charAt(i-1);
	        if (dif < 0)
	            dif += ALPHA;
	 
	        // Representing the difference as char
	        shift += (dif + 'a');
	    }
	 
	    // This String will be 1 less length than str
	    return shift;
	}
	 
	// Method for grouping shifted String
	public static void groupShiftedString(String str[], int n){
	    // map for storing indices of String which are
	    // in same group
	    HashMap<String, Vector<Integer> > groupMap =  new HashMap<String, Vector<Integer>>();
	    for (int i = 0; i < n; i++){
	        String diffStr = getDiffString(str[i]);
	        
	        if(groupMap.get(diffStr) != null){
	        	groupMap.get(diffStr).add(i);
	        }else{
	        	Vector<Integer> v = new Vector<Integer>();
	        	v.add(i);
	        	groupMap.put(diffStr, v);
	        }
	    }
	 
	    
	    // iterating through map to print group
	    Iterator it = groupMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Vector<Integer> v = (Vector<Integer>) pair.getValue();
	        for (int i = 0; i < v.size(); i++)
	            System.out.print(str[v.get(i)]+" ");
	        System.out.println();
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    
	}
	public static void main(String[] args) {
		String str[] = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};
		int n = str.length;
		groupShiftedString(str, n);
	}
}
