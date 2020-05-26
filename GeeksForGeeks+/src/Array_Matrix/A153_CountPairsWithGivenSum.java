package Array_Matrix;
import java.util.HashMap;
/*
 * http://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * O(n)
 */
public class A153_CountPairsWithGivenSum {

	// Returns number of pairs in arr[0..n-1] with sum equal
	// to 'sum'
	public int getPairsCount(int arr[], int sum){
		int n = arr.length;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
 
		int res = 0;
 
		for(int i=0;i<n;i++) {
			if(hm.containsKey(arr[i])) {
				int c = hm.get(arr[i]); 
				hm.put(arr[i],c+1);
			}
			else
				hm.put(arr[i],1);
		}
 
		int twiceCount = 0;
		for(int i=0;i<n;i++) {
			if(hm.get(sum-arr[i]) != null) {
				twiceCount += hm.get(sum-arr[i]); 
				if(sum-arr[i] == arr[i])
					twiceCount--;
			}
		}
 
		return twiceCount/2;
	}
	public static void main(String[] args) {
		A153_CountPairsWithGivenSum obj = new A153_CountPairsWithGivenSum();
		int arr[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1} ;

	    int sum = 11;
	    System.out.println("Count of pairs is: "+obj.getPairsCount(arr, sum));
	}
}
