package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 */
public class A054_MaximumSumIncreasingSubsequence {

	public int maxSumLis(int[] arr){
		int max = 0;
		int[] cache = new int[arr.length];

		/* Initialize LIS values for all indexes */
		for (int i = 0; i < arr.length; i++ )
			cache[i] = arr[i];
			
		for(int i = 1 ; i < arr.length ;i++){
			for(int j = 0 ;j < i; j++){
				if((arr[i] > arr[j]) && (cache[i] < cache[j] + arr[i])){
					cache[i] = cache[j] + arr[i];
				}
			}
		}
		/* Pick maximum of all LIS values */
		for (int i = 0; i < arr.length; i++)
			if (max < cache[i])	max = cache[i];
		return max;

	}

	public static void main(String[] args) {
		A054_MaximumSumIncreasingSubsequence obj = new A054_MaximumSumIncreasingSubsequence();
		int[] arr = new int[] {3, 4, 5, 10};
		System.out.println("MAX sum:"+obj.maxSumLis(arr));
	}

}
