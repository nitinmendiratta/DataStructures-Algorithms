package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/check-String-follows-order-characters-defined-pattern-not/
 * http://www.geeksforgeeks.org/check-if-String-follows-order-of-characters-defined-by-a-pattern-or-not-set-2/
 * http://www.geeksforgeeks.org/check-if-string-follows-order-of-characters-defined-by-a-pattern-or-not-set-3/
 */
public class S092_97_98_CheckIfStringFollowsOrderOfCharactersDefinedByaPattern {
	
	// Assume there won’t be any duplicate characters in the pattern.
	public static boolean checkPatternApproach1(String str, String pattern){
	    // len stores length of the given pattern 
	    int len = pattern.length();
	      
	    // if length of pattern is more than length of 
	    // input String, return false;
	    if (str.length() < len)
	        return false;
	      
	    for (int i = 0; i < len - 1; i++){
	        // x, y are two adjacent characters in pattern
	        char x = pattern.charAt(i);
	        char y = pattern.charAt(i+1);
	         
	        // find index of last occurrence of character x in the input String
	        int last = str.lastIndexOf(x);
	          
	        // find index of first occurrence of character y in the input String
	        int first = str.indexOf(y);
	          
	        // return false if x or y are not present in the 
	        // input String OR last occurrence of x is after 
	        // the first occurrence of y in the input String
	        if (last == -1 || first == -1 || last > first)    
	        	return false;
	    }
	      
	    // return true if String matches the pattern
	    return true;
	}
	/* BEST APPROACH
	 * Time Complexity: Time complexity of above implementations is actually O(mn + n^2) as we use 
	 * deleteCharAt() to remove characters. 
	 * We can optimize above solution to work in linear time. Instead of using deleteCharAr(), 
	 * we can create an empty String and add only required characters to it.
	 * 
	 * StringBuilder is used to operate on input String.
	 * This is because StringBuilder is mutable, while String is immutable object. 
	 * To create a new String takes O(n) space, so extra space is O(n).
	*/
	public static boolean checkPatternApproach2(String str, String pattern){
        // Insert all characters of pattern in a hash set,
        Set<Character> patternSet = new HashSet<>();
        for (int i=0; i<pattern.length(); i++)
            patternSet.add(pattern.charAt(i));
 
        // Build modified String (String with characters only from
        // pattern are taken)
        StringBuilder modifiedString = new StringBuilder(str);
        for (int i=str.length()-1; i>=0; i--)
            if (!patternSet.contains(modifiedString.charAt(i)))
                modifiedString.deleteCharAt(i);
 
        // Remove more than one consecutive occurrences of pattern
        // characters from modified String.
        for (int i=modifiedString.length()-1; i>0; i--)
            if (modifiedString.charAt(i) == modifiedString.charAt(i-1))
                modifiedString.deleteCharAt(i);
 
        // After above modifications, the length of modified String
        // must be same as pattern length
        if (pattern.length() != modifiedString.length())
            return false;
 
        // And pattern characters must also be same as modified String
        // characters
        for (int i=0; i<pattern.length(); i++)
            if (pattern.charAt(i) != modifiedString.charAt(i))
                return false;
 
        return true;
    }
	
	// Returns true if characters of str follow order defined by a given ptr.
	// Assume there won’t be any duplicate characters in the pattern.
	// Time Complexity of this program is O(n)
	public static boolean checkPatternApproach3(String str, String pat){
	    // Initialize all orders as -1
	    HashMap<Character, Integer> label = new HashMap<Character, Integer>();
	 
	    // Assign an order to pattern characters
	    // according to their appearance in pattern
	    int order = 1;
	    for (int i = 0; i < pat.length() ; i++){
	    	// if pat char is not present in the string
	    	if(str.indexOf(pat.charAt(i)) == -1){
	    		return false;
	    	}
	        // give the pattern characters order
	        label.put(pat.charAt(i),order);
	 
	        // increment the order
	        order++;
	    }
	 
	    //  Now one by check if String characters follow above order
	    int last_order = -1;
	    for (int i = 0; i < str.length(); i++){
	        if (label.get(str.charAt(i)) != null){
	            // If order of this character is less
	            // than order of previous, return false.
	            if (label.get(str.charAt(i)) < last_order)
	                return false;
	 
	            // Update last_order for next iteration
	            last_order =  label.get(str.charAt(i));
	        }
	    }
	 
	    // return that str followed pat
	    return true;
	}
	public static void main(String[] args) {
		
		System.out.println("Approach 1");
	  
		String str = "engineers rock";
	    String pattern = "xy";
	    System.out.println("Expected: false, Actual: " + checkPatternApproach1(str, pattern));
	    
	    str = "engineers rock";
        pattern = "er";
        System.out.println("Expected: true, Actual: " + checkPatternApproach1(str, pattern));
 
        str = "engineers rock";
        pattern = "egr";
        System.out.println("Expected: false, Actual: " +checkPatternApproach1(str, pattern));
 
        str = "engineers rock";
        pattern = "gsr";
        System.out.println("Expected: false, Actual: " +checkPatternApproach1(str, pattern));
 
//        str = "engineers rock";
//        pattern = "eger";
//        System.out.println("Expected: true, Actual: " +checkPatternApproach1(str, pattern));
        
	    System.out.println("Approach 2");
	    
	    str = "engineers rock";
	    pattern = "xy";
	    System.out.println("Expected: false, Actual: " + checkPatternApproach2(str, pattern));
	    
	    str = "engineers rock";
        pattern = "er";
        System.out.println("Expected: true, Actual: " + checkPatternApproach2(str, pattern));
 
        str = "engineers rock";
        pattern = "egr";
        System.out.println("Expected: false, Actual: " +checkPatternApproach2(str, pattern));
 
        str = "engineers rock";
        pattern = "gsr";
        System.out.println("Expected: false, Actual: " +checkPatternApproach2(str, pattern));
 
        str = "engineers rock";
        pattern = "eger";
        System.out.println("Expected: true, Actual: " +checkPatternApproach2(str, pattern));
        
        System.out.println("Approach 3");
        
        str = "engineers rock";
	    pattern = "xy";
	    System.out.println("Expected: false, Actual: " + checkPatternApproach3(str, pattern));
	    

	    str = "engineers rock";
        pattern = "er";
        System.out.println("Expected: true, Actual: " + checkPatternApproach3(str, pattern));
 
        str = "engineers rock";
        pattern = "egr";
        System.out.println("Expected: false, Actual: " +checkPatternApproach3(str, pattern));
 
        str = "engineers rock";
        pattern = "gsr";
        System.out.println("Expected: false, Actual: " +checkPatternApproach3(str, pattern));
 
//        str = "engineers rock";
//        pattern = "eger";
//        System.out.println("Expected: true, Actual: " +checkPatternApproach3(str, pattern));
	}
}
