package Array_Matrix;
import java.util.HashSet;

/*
 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 * o(n)
 */
public class A123_CheckGivenArrayContainsDuplicateEltsWithinkDistance {

	 public boolean checkDuplicatesWithinK(int arr[], int k) {
	        // Creates an empty hashset
	        HashSet<Integer> set = new HashSet<>();
	 
	        // Traverse the input array
	        for (int i=0; i<arr.length; i++) {
	            // If already present n hash, then we found 
	            // a duplicate within k distance
	            if (set.contains(arr[i]))
	               return true;
	 
	            // Add this item to hashset
	            set.add(arr[i]);
	 
	            // Remove the k+1 distant item
	            if (i >= k)
	              set.remove(arr[i-k]);
	        }
	        return false;
    }
	 
	public static void main(String[] args) {
		A123_CheckGivenArrayContainsDuplicateEltsWithinkDistance obj = new A123_CheckGivenArrayContainsDuplicateEltsWithinkDistance();
		int arr[] = {10, 5, 3, 4, 3, 5, 6};
        if (obj.checkDuplicatesWithinK(arr, 3))
           System.out.println("Yes");
        else
           System.out.println("No");
	}

}
