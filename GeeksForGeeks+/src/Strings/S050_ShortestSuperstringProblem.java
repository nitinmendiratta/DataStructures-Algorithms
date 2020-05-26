package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/shortest-superstring-problem/
 * http://www.geeksforgeeks.org/shortest-superstring-problem-set-2-using-set-cover/
 * https://abdulcode.wordpress.com/2013/05/18/shortest_common_superstring/
 */
public class S050_ShortestSuperstringProblem {

	// Function to calculate maximum overlap in two given strings
	public int findOverlappingPair(String str1, String str2, String str){
	    // max will store maximum overlap i.e maximum
	    // length of the matching prefix and suffix
	    int max = Integer.MIN_VALUE;
	    int len1 = str1.length();
	    int len2 = str2.length();
	 
	    // check suffix of str1 matches with prefix of str2
	    for (int i = 1; i <= Math.min(len1, len2); i++){
	        // compare last i characters in str1 with first i
	        // characters in str2
	    	
	        if (str1.substring(len1-i).compareTo(str2.substring(0, i)) == 0){
	            if (max < i){
	                //update max and str
	                max = i;
	                str = str1 + str2.substring(i);
	            }
	        }
	    }
	 
	    // check prefix of str1 matches with suffix of str2
	    for (int i = 1; i <= Math.min(len1, len2); i++){
	        // compare first i characters in str1 with last i characters in str2
	        if (str1.substring(0, i).compareTo(str2.substring(len1-i)) == 0){
	            if (max < i){
	                //update max and str
	                max = i;
	                str = str2 + str1.substring(i);
	            }
	        }
	    }
	 
	    return max;
	}
	 
	// Function to calculate smallest string that contains
	// each string in the given set as substring.
	String findShortestSuperstring(String arr[]){
		int len = arr.length;
	    // run len-1 times to consider every pair
	    while(len != 1){
	        int max = Integer.MIN_VALUE;  // to store  maximum overlap
	        int l = 0;
	        int r = 0;   // to store array index of strings
	        // involved in maximum overlap
	        String resStr = new String();  // to store resultant string after
	        // maximum overlap
	 
	        for (int i = 0; i < len; i++){
	            for (int j = i + 1; j < len; j++){
	                String str = new String();
	 
	                // res will store maximum length of the matching
	                // prefix and suffix str is passed by reference and
	                // will store the resultant string after maximum
	                // overlap of arr[i] and arr[j], if any.
	                int res = findOverlappingPair(arr[i], arr[j], str);
	 
	                // check for maximum overlap
	                if (max < res){
	                    max = res;
	                    resStr=str;
	                    l = i;
	                    r = j;
	                }
	            }
	        }
	 
	        len--;  //ignore last element in next cycle
	 
	        // if no overlap, append arr[len] to arr[0]
	        if (max == Integer.MIN_VALUE)
	            arr[0] += arr[len];
	        else{
	            arr[l] = resStr;   // copy resultant string to index l
	            arr[r] = arr[len];  // copy string at last index to index r
	        }
	    }
	    return arr[0];
	}
	
	public static void main(String[] args) {
		S050_ShortestSuperstringProblem obj = new S050_ShortestSuperstringProblem();
		String arr[] = {"catgc", "ctaagt", "gcta", "ttca", "atgcatc"};

	    System.out.println("The Shortest Superstring is "+obj.findShortestSuperstring(arr));	 
	}
}
