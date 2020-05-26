package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * (1) naive search: enumerate all possible pairs : Time complexity: O(n^2) 
 * (2) sort the array then use binary search
 * (3) use hashtable : time complexity: O(n), space complexity: O(n)
 * (4) use a balanced binary search tree or two heaps (refer to the stream median problem ) 
 */
 
class Pairs{
	int first;
	int second;
}

public class A102_CountAllDistinctPairsWithDifferenceEqualToK {
	// not working for diff = 0
	public ArrayList<Pairs> isSumApproach1(int[] arr, int x){
		ArrayList<Pairs> result = new ArrayList<Pairs>();
		/*Arrays.sort(arr);
		int n = arr.length, diff = 0, start = 0, end = n-1;
		
		while(start < end){
			diff = arr[end] - arr[start];
			if(diff == x){
				Pairs pair = new Pairs();
				pair.first = arr[start];
				pair.second = arr[end];
				result.add(pair);
				start++;
				end--;
			}
			else if(diff > x){
				start++;
			}
			else end--;
		}*/
		return result;
	}

	public ArrayList<Pairs> isSumApproach2(int[] arr, int k){
		ArrayList<Pairs> result = new ArrayList<Pairs>();
		Hashtable<Integer,Boolean> hash = new Hashtable<Integer,Boolean>();
		int diff = 0;
		int i = 0, count = 0;
		// Insert array elements to hashmap
	    for (i = 0; i < arr.length; i++)
	    	hash.put(arr[i], true);
	 
	    for (i = 0; i < arr.length; i++){
	        int x = arr[i];
	        if (x - k >= 0 && hash.containsKey(x - k)){
	        	Pairs pair = new Pairs();
				pair.first = x;
				pair.second = x-k;
				result.add(pair);
	        	count++;
	        }
	            
	        if (x + k < Integer.MAX_VALUE && hash.containsKey(x + k)){
	        	Pairs pair = new Pairs();
				pair.first = x;
				pair.second = x+k;
				result.add(pair);
	            count++;
	        }
	        hash.remove(x);
	    }
	    return result;
	    //return count;
	}

	public static void main(String[] args) {
		A102_CountAllDistinctPairsWithDifferenceEqualToK obj = new A102_CountAllDistinctPairsWithDifferenceEqualToK();
		int[] arr = {8, 12, 16, 4, 0, 20};
		/*ArrayList<Pairs> result1 = obj.isSumApproach1(arr,4);
		for(Pairs p: result1) {
    		System.out.println(p.first+","+p.second);
		}*/
		ArrayList<Pairs> result2 = obj.isSumApproach2(arr,4);
		for(Pairs p: result2) {
    		System.out.println(p.first+","+p.second);
		}
	}
}
