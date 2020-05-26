package Heap_Hash;
import java.util.HashSet;
/*
 * http://www.geeksforgeeks.org/longest-consecutive-subsequence/
 * Time Complexity: At first look, time complexity looks more than O(n). 
 * If we take a closer look, we can notice that it is O(n) under the assumption that hash insert and search take O(1) time. 
 * The function S.find() inside the while loop is called at most twice for every element. 
 * For example, consider the case when all array elements are consecutive. 
 * In this case, the outer find is called for every element, but we go inside the if condition only for the smallest element. 
 * Once we are inside the if condition, we call find() one more time for every other element.
 */
public class Ha15_LongestConsecutiveSubsequence {

	 // Returns length of the longest consecutive subsequence
    static int findLongestConseqSubseq(int arr[],int n){
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;
 
        // Hash all the array elements
        for (int i=0; i<n; ++i)
            S.add(arr[i]);
 
        // check each possible sequence from the start
        // then update optimal length
        for (int i=0; i<n; ++i){
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i]-1)){
                // Then check for next elements in the
                // sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;
 
                // update  optimal length if this length
                // is more
                if (ans<j-arr[i])
                    ans = j-arr[i];
            }
        }
        return ans;
    }
    
	public static void main(String[] args) {
		int arr[] =  {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr,n));
	}
}
