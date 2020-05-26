package Strings;
/*
 * http://www.geeksforgeeks.org/print-consecutive-characters-together-line/
 */
public class S142_PrintConsecutiveCharactersTogetherInaLine {

	public static void print(String str){
		
	    System.out.print(str.charAt(0));
	    for (int i=1; i<str.length(); i++){
	        if ((str.charAt(i) == str.charAt(i-1)+1) || (str.charAt(i) == str.charAt(i-1)-1))
	            System.out.print(str.charAt(i));
	        else{
	        	System.out.println();
	            System.out.print(str.charAt(i));
	        }
	    }
	}
	public static void main(String[] args) {
	    print("ABCXYZACCD");
	}
}
