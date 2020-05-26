package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/print-all-permutations-with-repetition-of-characters/
 * 
 */
public class S014_PrintAllPermutationsWithRepetitionOfCharacters {
	
	public Set<String> permute(String str){
		Set<String> resultSet = new HashSet<String>();
		int len = str.length();
		// convert input string to char array so we can sort the char in Lexicographic order
		char[] inputArr = str.toCharArray();
		// Sort the input string so that we get all output strings in lexicographically sorted order
		Arrays.sort(inputArr);
		// Create a temp array that will be used by helper method
		char[] tempArr = new char[str.length()];
		helper(inputArr, tempArr, 0, len-1, resultSet);
		return resultSet;
	}

	public void helper(char[] inputArr, char[] tempArr, int start, int last, Set<String> resultSet){
		int i, len = inputArr.length;
		// One by one fix all characters at the given index and recur for the subsequent indexes
		for (i = 0; i < len; i++){
			// Fix the ith character at index and if this is not the last index then recursively call for higher indexes
			tempArr[start] = inputArr[i];
			// If this is the last index then print the string stored in data[]
			if (start == last){
				resultSet.add(new String(tempArr));
			}
			else {
				// Recur for higher indexes
				helper(inputArr, tempArr, start+1, last, resultSet);
			}
		}
	}
	
	public static void main(String[] args) {
		S014_PrintAllPermutationsWithRepetitionOfCharacters obj = new S014_PrintAllPermutationsWithRepetitionOfCharacters();
		String text = "AB";
		System.out.println("Permutations are: "+obj.permute(text));
	}
}
