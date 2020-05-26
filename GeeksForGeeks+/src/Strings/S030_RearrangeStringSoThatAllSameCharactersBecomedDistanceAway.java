package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
 * Time Complexity: Time complexity of above implementation is O(n + mLog(MAX)).
 * Here n is the length of str, m is count of distinct characters in str[] and MAX is maximum possible different characters. 
 * MAX is typically 256 (a constant) and m is smaller than MAX. So the time complexity can be considered as O(n).
 */
class ArrNode{
	char data;
	int count;
	public ArrNode(char c){
		data = c;
		count = 0;
	}
}
public class S030_RearrangeStringSoThatAllSameCharactersBecomedDistanceAway {

	public String distribute(String s, int d){
		char[] arr = s.toCharArray();
		// Create an array to store all characters and their frequencies in str[]
		ArrNode[] freqArr = new ArrNode[256];
		int distinctChar = 0;
		int n = arr.length;
		
		// Traverse the input string and store frequencies of all characters in freq[] array.
		for(int i = 0; i < n; i++){
			int a = (int)arr[i];
			if(freqArr[a] == null){
				freqArr[a] = new ArrNode(arr[i]);
				distinctChar++;
			}
			freqArr[a].count++;
			arr[i] = '\0';
		}

		// Initialize heap
		Queue<ArrNode> q = new PriorityQueue<ArrNode>(n, new Comparator<ArrNode>(){
			public int compare(ArrNode a, ArrNode b){
				return b.count - a.count;
			}
		});	

		//Build a max heap of all characters
		for(int i = 0;i < freqArr.length;i++){
			if(freqArr[i] != null) q.add(freqArr[i]);
		}

		// Now one by one extract all distinct characters from max heap and put them back in str[] with the d distance constraint
		for (int i = 0; i < distinctChar; i++){
			int j = i;
			ArrNode node = q.poll();
			char data = node.data;
			int freq = node.count;
			// Find the first available position in str[]
			while(arr[j] != '\0') j++;
			// Fill node.data at j, j+d, j+2d, .. j+(f-1)d
	        for (int k = 0; k < freq; k++){
	            // If the index goes beyond size, then string cannot be rearranged.
	            if (j + d*k >= n){
	            	System.out.println("Cannot be rearranged");
	            	System.exit(0);
	            }
	            arr[j + d*k] = data;
	        }
//			for(;freq != 0;j = j+d){
//				if(j >= arr.length){
//					System.out.println("Cannot be rearranged");
//					System.exit(0);
//				}
//				if(arr[j] != '\0') j++;
//				arr[j] = c;
//				freq--;
//			}
		}
		return new String(arr);
	}


	public static void main(String[] args) {
		S030_RearrangeStringSoThatAllSameCharactersBecomedDistanceAway obj = new S030_RearrangeStringSoThatAllSameCharactersBecomedDistanceAway();
		System.out.println("After removing: "+obj.distribute("abb",2));
		System.out.println("After removing: "+obj.distribute("aacbbc",3));
		System.out.println("After removing: "+obj.distribute("geeksforgeeks",2));
		System.out.println("After removing: "+obj.distribute("aaa",2));
	}
}
