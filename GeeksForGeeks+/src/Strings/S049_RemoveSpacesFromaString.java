package Strings;
/*
 * http://www.geeksforgeeks.org/remove-spaces-from-a-given-string/
 * Time complexity of above solution is O(n) and it does only one traversal of string.
 */
public class S049_RemoveSpacesFromaString {

	// Function to remove all spaces from a given string
	public void removeSpaces(String str){
		char[] arr = str.toCharArray();
		int spaceCount=0;
		for(int i=0;i<arr.length;i++){
			if(Character.isWhitespace(arr[i])){
				spaceCount++;
			}else{
				arr[i-spaceCount]=arr[i];
			}
		}
		// Returns the string representation of the char array argument.
		String res = String.valueOf(arr);
		res = res.substring(0, arr.length-spaceCount);
		System.out.println(res);
	}
	public static void main(String[] args) {
		S049_RemoveSpacesFromaString obj = new S049_RemoveSpacesFromaString();
		String str = "g  eeks   for ge  eeks  ";
	    obj.removeSpaces(str);
	}
}
