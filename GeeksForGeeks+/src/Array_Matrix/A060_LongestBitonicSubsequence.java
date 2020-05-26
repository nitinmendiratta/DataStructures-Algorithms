package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 * We need to construct two arrays lis[] and lds[] using Dynamic Programming solution of LIS problem. 
 * lis[i] stores the length of the Longest Increasing subsequence ending with arr[i]. 
 * lds[i] stores the length of the longest Decreasing subsequence starting from arr[i]. 
 * Finally, we need to return the max value of lis[i] + lds[i] – 1 where i is from 0 to n-1.
 * 
 * Time Complexity: O(n^2)
	Auxiliary Space: O(n)
 */
public class A060_LongestBitonicSubsequence {

	public int bitonicSubsequence(int[] arr){
		int n = arr.length;
		int i = 0,j = 0;
		int[] lis = new int[n];
		int[] lds = new int[n];

		for(i = 0;i < n;i++) lis[i] = 1;
		for(i = 0;i < n;i++) lds[i] = 1;
		// Step 1) Construct increasing sequence array
		
		for(i = 1; i < n; i++){
			for(j = 0;j < i;j++){
				if (arr[i] > arr[j])
					lis[i] = Math.max(lis[i], lis[j] + 1);
			}
		}

		// Step 2) Construct decreasing sequence array
		for (i = n-2; i >= 0; i--){
			for(j = n-1;j > i;j--){
				if (arr[i] > arr[j])
					lds[i] = Math.max(lds[i], lds[j] + 1);
			}
		}

		// Step 3) Find the length of maximum length bitonic sequence
		int max = lis[0] + lds[0] - 1;
		for (i = 1; i < n; i++){
			if (lis[i] + lds[i] - 1 > max){
				max = lis[i] + lds[i] - 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		A060_LongestBitonicSubsequence obj = new A060_LongestBitonicSubsequence();
		int[] arr = {80, 60, 30, 40, 20, 10};
		int result = obj.bitonicSubsequence(arr);
		System.out.println("Length of sequence is:"+result);
	}
}
