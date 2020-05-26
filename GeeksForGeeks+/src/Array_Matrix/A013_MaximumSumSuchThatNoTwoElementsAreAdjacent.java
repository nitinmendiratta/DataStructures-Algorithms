package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * Time Complexity: O(n)
 */
public class A013_MaximumSumSuchThatNoTwoElementsAreAdjacent {

	public int maxSum(int[] arr){
		int n = arr.length;
		if(n == 0) return Integer.MIN_VALUE;
		if(n == 1) return arr[0];
		
		int excl = arr[0];
		int incl = 0;
		int excl_new;
		for(int i = 1; i < n;i++){
			/* current max excluding i */
			excl_new = Math.max(incl,excl);
			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		}
		return Math.max(incl,excl);
	}
	
	public static void main(String[] args) {
		A013_MaximumSumSuchThatNoTwoElementsAreAdjacent obj = new A013_MaximumSumSuchThatNoTwoElementsAreAdjacent();
		int[] arr = {1, 4, 45, 5, 5, 8};
		System.out.println("Max sum:"+obj.maxSum(arr));
	}
}
