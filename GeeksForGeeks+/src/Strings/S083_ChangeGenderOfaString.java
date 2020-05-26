package Strings;
import java.util.HashMap;

/*
 * http://www.geeksforgeeks.org/change-gender-given-String/
 * 
 * Time Complexity: O(N^2), where N is the length of the string, 
 * as the ‘+’/ ‘append’ operator of the string can take upto O(N) time 
 * and assuming that lookup in the dictionary takes O(1) worse case time.
 * 
 * Auxiliary Space: Apart from the dictionary that maps all the words to its counterpart, 
 * we declare O(N) space for the new string, where N is the length of input string.
 */
public class S083_ChangeGenderOfaString {

	// A Funtion that returns the new String with gender changed
	public String changeGender(String str){
	    // A Dictionary to store the mapping of genders
	    // The user can add his words too.
	    HashMap <String, String> dictionary = new HashMap<String, String>() {{
	    	put("batwoman", "batman");
	    	put("batman", "batwoman");
	    	put("boy", "girl");
	    	put("girl", "boy");
	    	
	    	put("boyfriend", "girlfriend");
	    	put("girlfriend", "boyfriend");
	    	put("father", "mother");
	    	put("mother", "father");
	    	
	    	put("husband", "wife");
	    	put("wife", "husband");
	    	put("he", "she");
	    	put("she", "he");
	    	
	    	put("his", "her");
	    	put("her", "his");
	    	put("male", "female");
	    	put("female", "male");
	    	
	    	put("man", "woman");
	    	put("woman", "man");
	    	put("Mr", "Ms");
	    	put("Mr", "Ms");
	    	
	    	put("sir", "madam");
	    	put("madam", "sir");
	    	put("son", "daughter");
	    	put("daughter", "son");
	    	
	    	put("uncle", "aunt");
	    	put("aunt", "uncle");
    	}};

	 
	    str = str + ' '; // Append a space at the end
	 
	    int n = str.length();
	 
	    // 'temp' String will hold the intermediate words
	    // and 'ans' String will be our result
	    String temp = "", ans = "";
	 
	    for (int i=0; i<=n-1; i++){
	        if (str.charAt(i) != ' ')
	            temp += str.charAt(i);
	        else{
	            // If this is a 'male' or a 'female' word then
	            // swap this with its counterpart
	            if (dictionary.get(temp) != null)
	                temp = dictionary.get(temp);
	 
	            ans = ans + temp + ' ';
	            temp = "";
	        }
	    }
	 
	    return(ans);
	}
	public static void main(String[] args) {
		S083_ChangeGenderOfaString obj = new S083_ChangeGenderOfaString();
		String str = "she is going to watch movie with her boyfriend";
 
		System.out.println(obj.changeGender(str));
	}
}
