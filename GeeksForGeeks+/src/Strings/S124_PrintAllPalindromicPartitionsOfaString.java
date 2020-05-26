package Strings;
import java.util.Vector;
/*
 * http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/
 * http://www.geeksforgeeks.org/print-palindromic-partitions-String/
 * TODO: MOSTLY WORKING
 */
public class S124_PrintAllPalindromicPartitionsOfaString {

	// Returns true if str is palindrome, else false
	public static boolean checkPalindrome(String str){
	    int len = str.length();
	    len--;
	    for (int i=0; i<len; i++){
	        if (str.charAt(i) != str.charAt(len))
	            return false;
	        len--;
	    }
	    return true;
	}
	 
	static void printSolution(Vector<Vector<String> > partitions){
	    for (int i = 0; i < partitions.size(); ++i){
	        for(int j = 0; j < partitions.get(i).size(); ++j)
	            System.out.print(partitions.get(i).get(j)+" ");
	        System.out.println();
	    }
	    return;
	}
	 
	// Goes through all indexes and recursively add remaining
	// partitions if current String is palindrome.
	static void addStrings(Vector<Vector<String> > v, String s, Vector<String> temp, int index){
	    int len = s.length();
	    String str = "";
	    Vector<String> current = new Vector<String>(temp);
	    if (index == 0)
	        temp.clear();
	    for (int i = index; i < len; ++i){
	        str = str + s.charAt(i);
	        if (checkPalindrome(str)){
	            temp.add(str);
	            if (i+1 < len)
	                addStrings(v,s,temp,i+1);
	            else
	                v.add(temp);
	            temp = current;
	        }
	    }
	    return;
	}
	 
	// Generates all palindromic partitions of 's' and stores the result in 'v'.
	public static void partition(String s, Vector<Vector<String> > v){
	    Vector<String> temp = new Vector<String>();
	    addStrings(v, s, temp, 0);
	    printSolution(v);
	    return;
	}
	
	public static void main(String[] args) {
		String s = "geeks";
	    Vector<Vector<String> > partitions = new Vector<Vector<String> >();
	    partition(s, partitions);
	}
}
