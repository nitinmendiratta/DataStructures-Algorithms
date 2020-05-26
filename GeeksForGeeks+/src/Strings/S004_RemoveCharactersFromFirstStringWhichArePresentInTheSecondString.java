package Strings;
import java.util.*;
/*
 * https://www.geeksforgeeks.org/remove-characters-from-the-first-string-which-are-present-in-the-second-string/ * Time Complexity: O(m+n) 
 */
public class S004_RemoveCharactersFromFirstStringWhichArePresentInTheSecondString {

	static void removeDirtyChars(String str1, String str2){
		
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();

		int n1=str1.length();
		int n2=str2.length();
		for(int  i=0;i<n2;i++){
			map.put(str2.charAt(i),1);
		}
		
		StringBuilder sb=new StringBuilder();
		for(int  i=0;i<n1;i++){
			if(!map.containsKey(str1.charAt(i))){
	            sb.append(str1.charAt(i));
			}
		}
		System.out.println("The string1 after removing string2 characters is "+sb.toString());		
	}
	
	public static void main(String[] args) {
		removeDirtyChars("geeksforgeeks", "mask");
	}
}
