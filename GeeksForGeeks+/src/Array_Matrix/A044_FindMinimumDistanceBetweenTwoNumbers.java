package Array_Matrix;

/* http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 * Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. 
 * The array might also contain duplicates. You may assume that both x and y are different and present in arr[].
 */
public class A044_FindMinimumDistanceBetweenTwoNumbers {

	public int minDist(int[] arr, int x, int y){
		int i = 0, n = arr.length;
		int min_dist = Integer.MAX_VALUE;
		int prev = 0;

		// Find the first occurence of any of the two numbers (x or y) and store the index of this occurence in prev
		for (i = 0; i < n; i++){
			if (arr[i] == x || arr[i] == y){
				prev = i;
				break;
			}
		}
		// Traverse after the first occurence
		for ( ; i < n; i++){
		
			if (arr[i] == x || arr[i] == y){
				// If the current element matches with any of the two then check if current element and prev element are different
				// Also check if this value is smaller than minimm distance so far
				if ( arr[prev] != arr[i] && (i - prev) < min_dist ){
					min_dist = i - prev;
					prev = i;
				}
				else
					prev = i;
			}
		}
		return min_dist;
	}

	public static void main(String[] args){
		A044_FindMinimumDistanceBetweenTwoNumbers obj = new A044_FindMinimumDistanceBetweenTwoNumbers();
		int[] arr = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
		System.out.println("Min Dist:"+obj.minDist(arr,3,4));
	}
}
