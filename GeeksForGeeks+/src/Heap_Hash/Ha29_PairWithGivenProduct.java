package Heap_Hash;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/pair-with-given-product-set-1-find-if-any-pair-exists/
 * time complexity to O(n)
 */
public class Ha29_PairWithGivenProduct {

	// Returns true if there is a pair in arr[0..n-1] with product equal to x.
	static boolean isProduct(int arr[], int x){
		int n = arr.length;
	    if (n < 2)
	        return false;
	 
	    // Create an empty set and insert first element into it
	    Set<Integer> s = new HashSet<Integer>();
	 
	    // Traverse remaining elements
	    for (int i=0; i<n; i++){
	        // 0 case must be handles explicitly as
	        // x % 0 is undefined behaviour in C++
	        if (arr[i] == 0){
	           if (x == 0)
	               return true;
	           else
	               continue;
	        }
	        // x/arr[i] exists in hash, then we found a pair
	        if (x%arr[i] == 0){
	            if (s.contains(x/arr[i]))
	               return true;
	 
	            // Insert arr[i]
	            s.add(arr[i]);
	        }
	    }
	    return false;
	}
	public static void main(String[] args) {
		int arr[] = {10, 20, 9, 40};
	    int x = 400;

	    System.out.println(isProduct(arr, x));
	 
	    x = 190;
	    System.out.println(isProduct(arr, x));
	}
}
