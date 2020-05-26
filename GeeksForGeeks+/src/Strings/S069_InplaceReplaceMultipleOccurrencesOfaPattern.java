package Strings;
/*
 * http://www.geeksforgeeks.org/place-replace-multiple-occurrences-pattern/
 * The time complexity of above algorithm is O(n*m), where n is length of string and m is length of the pattern.
 */
public class S069_InplaceReplaceMultipleOccurrencesOfaPattern {

	// returns true if pattern is prefix of str
	boolean compare(char[] str, String pattern, int index){
		
	    for (int i = 0; i<pattern.length() && index < str.length; i++, index++){
	        if (str[index] != pattern.charAt(i)){
	        	return false;
	        }
	        return true;   
	    }
	    return false;
	}
	 
	// Function to in-place replace multiple, occurrences of a pattern by character ‘X’
	public String replacePattern(String str, String pattern){
		// If pattern is null or empty string,
	    // nothing needs to be done
	    if (pattern == null || pattern.length() == 0)
	        return "Invalid pattern";
	 
	 
	    int i = 0, j = 0;
	    int count;
	    char[] strArr = str.toCharArray();
	    StringBuilder sb = new StringBuilder();
	    // for each character
	    while (j<strArr.length){
	        count = 0;
	        
	        // compare str[j..j+len] with pattern
	        while (compare(strArr, pattern, j)){
	            // increment j by length of pattern
	            j = j + pattern.length();
	            count++;
	        }
	        //System.out.println("compairing j:"+j+" with strArr.length"+strArr.length+" char is: "+strArr[j]);
	        // If single or multiple occurrences of pattern
	        // is found, replace it by character 'X'
	        if (count > 0){
	        	sb.append('X');
	        	//strArr[i++] = 'X';
	        }
	        	
	 
	        // copy character at current position j
	        // to position i and i
	        if (j<strArr.length){
	        	sb.append(strArr[j++]);
	        	//strArr[i++] = strArr[j++];
	        }
	    }
	 
	    // add a null character to terminate string
	    //strArr[i] = '\0';
	    //String result = new String(strArr);
	    //return result.substring(0,i);
	    return sb.toString();
	}
	public static void main(String[] args) {
		S069_InplaceReplaceMultipleOccurrencesOfaPattern obj = new S069_InplaceReplaceMultipleOccurrencesOfaPattern();
		String str = "geeksforgeeks";
		String pattern = "geeks";
		System.out.println(obj.replacePattern(str , pattern));
	}
}
