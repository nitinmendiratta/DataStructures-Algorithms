package Strings;
/*
 * https://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
 * Time Complexity: O(n)
 * Space Complexity: O(1) Because we are using fixed space (Hash array) irrespective of input string size.
 */
public class S001_ReturnMaximumOccurringCharacterInaString {

	public char max(String str){
		int[] count  = new int[256];
		int max = 0;

		for(int i=0; i<str.length(); i++){
			int index = (int)str.charAt(i);
			count[index]++;
			if(count[max] < count[index]){
				max = index;
			}
		}
		return (char)max;
	}

	public static void main(String[] args) {
		S001_ReturnMaximumOccurringCharacterInaString obj = new S001_ReturnMaximumOccurringCharacterInaString();
		String s = "nitin";
		System.out.println("Max char is:"+obj.max(s));
	}
}
