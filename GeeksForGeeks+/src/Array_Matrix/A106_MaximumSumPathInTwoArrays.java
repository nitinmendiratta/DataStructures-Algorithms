package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
 * Time complexity is O(m+n)
 */
public class A106_MaximumSumPathInTwoArrays {

	public int sum(int[]ar1, int[] ar2){
		int m = ar1.length;
		int n = ar2.length;
		int maxsum = 0,sum1 = 0,sum2 = 0,i = 0,j = 0;

		// Below 3 loops are similar to merge in merge sort
		while (i < m && j < n){
			// Add elements of ar1[] to sum1
			if (ar1[i] < ar2[j])
				sum1 += ar1[i++];
			// Add elements of ar2[] to sum2
			else if (ar1[i] > ar2[j])
				sum2 += ar2[j++];

			else{  // we reached a common point
				// Take the maximum of two sums and add to result
				maxsum += Math.max(sum1, sum2);
				// Update sum1 and sum2 for elements after this intersection point
				sum1 = 0; sum2 = 0;
				// Keep updating result while there are more common elements
				while (i < m &&  j < n && ar1[i] == ar2[j]){
					maxsum = maxsum + ar1[i++];
					j++;
				}
			}
		}
		// Add remaining elements of ar1[]
		while (i < m)
			sum1  +=  ar1[i++];
		// Add remaining elements of ar2[]
		while (j < n)
			sum2 +=  ar2[j++];
		// Add maximum of two sums of remaining elements
		maxsum +=  Math.max(sum1, sum2);
		return maxsum;
	}

	public static void main(String[] args) {
		A106_MaximumSumPathInTwoArrays obj = new A106_MaximumSumPathInTwoArrays();
		int A1[] = {10, 12};
		int A2[] = {5, 7, 9};
		int result = obj.sum(A1, A2);
		System.out.println("Max sum:"+result);
	}
}
