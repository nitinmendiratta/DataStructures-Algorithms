package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/find-strings-formed-characters-mapped-digits-number/
 * http://ideone.com/xfacJ0
 * TODO: NOT WORKING
 */
public class S072_FindAllStringsFormedFromCharactersMappedToDigitsOfaNumber {


		public static List<String> printCombinationsIterative(String[][] matrix,String input) {
			
		    List<String> result = new ArrayList<String>();
		    //to store the last occurrence of the digit
		    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		    if(input == null || input.length() == 0)
		        return result;
		       
		    char[] digits = input.toCharArray();	    
		    List<String> temp = new ArrayList<>();
	        temp.add("");
	        int index=0;
		    for(char c:digits)
		    {	    	
		    	int dig = c-'1';
		    	if(!map.containsKey(dig))
		    	{
		    		map.put(dig, index);
		    	}
		    	temp.clear();
		    	//for each character that maps to the digit
		    	for(int j=0;j<matrix[dig].length;j++)
		    	{
		    		//for first digit: push all its mappings to the temp list
		    		if(index==0)
		    		{
		    			result.add(matrix[dig][j]);
		    		}
		    		//second digit onwards
		    		if(index>0)
		    		{
		    			//for each string in output list
		    			for(String str: result)
		    			{
		    				char s=matrix[dig][j].charAt(0);
		    				if(map.get(dig)!=index)//means it has occurred before
		    				{
		    					s=str.charAt(map.get(dig));
		    				}
		    				str=str+s;
		    				temp.add(str);
		    			}
		    			
		    			if(map.get(dig)!=index)
		    			{
		    				break;
		    			}
		    		}
		    	}
		    	if(index>0)
		    	{
		    		result=temp;
		    	}
		    	index++;
		    }
		    return result;
		}
		
		
	    private static void printCombinationsRecursive(String[][] matrix, int pos, HashMap<Integer,Character> map,String input,String result) {
	    	 
	        if(pos==input.length()) {
	            System.out.println(result);
	            return;
	        }
	 
	        int currentPosValue = Character.getNumericValue(input.charAt(pos));
	 
	        if(map.get(currentPosValue)!=null) {
	 
	            result += map.get(currentPosValue);
	            printCombinationsRecursive(matrix,pos+1,map,input,result);
	 
	        } else {
	 
	            for (int i=0;i<matrix[currentPosValue-1].length;i++) {
	                map.put(currentPosValue,matrix[currentPosValue-1][i].charAt(0));
	                result += map.get(currentPosValue);
	                printCombinationsRecursive(matrix,pos+1,map,input,result);
	                //Clear map after one iteration
	                map.remove(currentPosValue);
	                result = result.substring(0,result.length()-1);
	            }
	 
	        }
	 
	 
	    }
		public static void main(String[] args)
		{
	        String[][] matrix = new String[][]
	                {
	                        {"A","B","C"},
	                        {"D","E","F"},
	                        {"G","H","I"},
	                        {"J","K","L"},
	                        {"M","N","O"},
	                        {"P","Q","R"},
	                        {"S","T","U"},
	                        {"V","W","X"},
	                        {"Y","Z"}
	                };
	 
	        Integer n = 22;
	        String s = Integer.toString(n);
	 
	        //printCombinationsRecursive(matrix,0,new HashMap<>(),s, "");
	        List<String> res = printCombinationsIterative(matrix,s);
	        System.out.println(res);
	 
		    
		}
	// Function to find all strings formed from a given
	// number where each digit maps to given characters.
//	public Vector<String> findCombinations(String input, String[][] table){
//	    // vector of strings to store output
//		Vector<String> out = null, temp = null;
//	 
//	    // stores index of first occurrence of the digits in input
//	    HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
//	 
//	    // maintains index of current digit considered
//	    int index = 0;
//	 
//	    // for each digit
//	    for (int i=0;i<input.length();i++){
//	    	int d = input.charAt(i);
//	        // store index of first occurrence of the digit in the map
//	        if (mp.get(d)/* == mp.end()*/ != null)
//	            mp.put(d, index);
//	 
//	        // clear vector contents for future use
//	        temp.clear();
//	 
//	        // do for each character thats maps to the digit
//	        for (int i1 = 0; i1 < table[d - 1].length; i1++){
//	            // for first digit, simply push all its
//	            // mapped characters in the output list
//	            if (index == 0){
//	                String s = new String(table[d - 1][i1]);
//	                out.add(s);
//	            }
//	 
//	            // from second digit onwards
//	            if (index > 0){
//	                // for each String in output list
//	                // append current character to it.
//	                for(String str: out){
//	                    // convert current character to String
//	                	String s = new String(table[d - 1][i1]);
//	 
//	                    // Imp - If this is not the first occurrence
//	                    // of the digit, use same character as used
//	                    // in its first occurrence
//	                    if(mp.get(d) != index)
//	                        s = ""+str.charAt(mp.get(d));
//	 
//	                    str = str + s;
//	 
//	                    // store strings formed by current digit
//	                    temp.add(str);
//	                }
//	 
//	                // nothing more needed to be done if this
//	                // is not the first occurrence of the digit
//	                if(mp.get(d) != index)
//	                    break;
//	            }
//	        }
//	 
//	        // replace contents of output list with temp list
//	        if(index > 0)
//	            out = temp;
//	        index++;
//	    }
//	 
//	    return out;
//	}
//	public static void main(String[] args) {
//		S72_FindAllStringsFormedFromCharactersMappedToDigitsOfaNumber obj = new S72_FindAllStringsFormedFromCharactersMappedToDigitsOfaNumber();
//		// vector to store the mappings
//		String[][] table = new String[][]
//                {
//                        {"A","B","C"},
//                        {"D","E","F"},
//                        {"G","H","I"},
//                        {"J","K","L"},
//                        {"M","N","O"},
//                        {"P","Q","R"},
//                        {"S","T","U"},
//                        {"V","W","X"},
//                        {"Y","Z"}
//                };
//	 
//	    // vector to store input number
//	    String input = "121";
//	 
//	    Vector<String> out = obj.findCombinations(input, table);
//	 
//	    // print all possible strings
//	    for (String it: out)
//	        System.out.println(it);
//	}
}
