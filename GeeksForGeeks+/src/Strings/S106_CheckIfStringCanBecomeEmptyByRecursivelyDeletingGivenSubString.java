package Strings;
/*
 * http://www.geeksforgeeks.org/check-String-can-become-empty-recursively-deleting-given-sub-String/
 */
public class S106_CheckIfStringCanBecomeEmptyByRecursivelyDeletingGivenSubString {

	// Returns true if str can be made empty by recursively removing sub_str.
	public static boolean canBecomeEmpty(String str, String sub_str){
	    while (str.length() > 0){
	        // idx: to store starting index of sub-String found in the original String
	    	
	        int idx = str.indexOf(sub_str);
	        if (idx == -1)
	            break;
	 
	        // Erasing the found sub-String from the original String
	        str = str.replace(sub_str, "");
	    }
	 
	    return (str.length() == 0);
	}
	public static void main(String[] args) {
		 String str = "GEEGEEKSKS", sub_str = "GEEKS";
		    if (canBecomeEmpty(str, sub_str))
		        System.out.println("Yes");
		    else
		        System.out.println("No");
	}
}
