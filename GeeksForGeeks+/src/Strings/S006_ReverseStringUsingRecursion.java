package Strings;
/*
 * http://www.geeksforgeeks.org/reverse-a-string-using-recursion/
 * Time Complexity: O(n)
 */
public class S006_ReverseStringUsingRecursion {

	public static void main(String[] args) {
		String s="nitinrahul";
		System.out.println(reverse(s));
	}
	
	public static String reverse(String s){
		if(s == null || s.length() == 0) return "";
		if(s.length() == 1) return s;
		String temp = reverse(s.substring(1));
		temp = temp+s.charAt(0);
		return temp;
	}
}
