package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
 */
public class A048_MaxLengthBitonicSubarray {

	public int[] bitonicSubarray(int[] arr){
		int n = arr.length;
		int i = 0,start = 0,end = 0;
		int[] result = new int[2];
		int[] inc = new int[n];
		int[] dec = new int[n];

		inc[0] = 1; // The length of increasing sequence ending at first index is 1
		dec[n-1] = 1; // The length of increasing sequence starting at first index is 1

		// Step 1) Construct increasing sequence array
		for(i = 1; i < n; i++){
			if (arr[i] > arr[i-1])
				inc[i] = inc[i-1] + 1;
			else
				inc[i] = 1;
		}

		// Step 2) Construct decreasing sequence array
		for (i = n-2; i >= 0; i--){
			if (arr[i] > arr[i+1])
				dec[i] = dec[i+1] + 1;
			else
				dec[i] = 1;
		}
		
		// Step 3) Find the length of maximum length bitonic sequence
		int max = inc[0] + dec[0] - 1;
		start = 0;
		end = dec[0] - 1;
		
		for (i = 1; i < n; i++){
			if (inc[i] + dec[i] - 1 > max){
				max = inc[i] + dec[i] - 1;
				start = (i - inc[i] + 1);
				end = (i + dec[i] - 1);
			}
		}
		result[0] = start;
		result[1] = end;
		return result;
	}

	public static void main(String[] args) {
		A048_MaxLengthBitonicSubarray obj = new A048_MaxLengthBitonicSubarray();
		int[] arr = {12, 4, 78, 90, 45, 23};
		int[] result = obj.bitonicSubarray(arr);

		System.out.print("Bitonic sequence is: ");
		for(int i = result[0]; i <= result[1];i++){
			System.out.print(arr[i]+",");
		}
	}
}
