package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 */

public class A053_FindContiguousSubarrayWithGivenSum {

	public int[] sumSubarray(int[] arr,int x){
		int n = arr.length;
		int i = 0,start = 0,end = 0;
		int[] result = new int[2];
		int sum = arr[start];

		if(sum == x) return result;


		for(end = 1;end <= n;end++){

			
			// If curr_sum becomes equal to sum, then return true
			if(sum == x) break;

			 // If curr_sum exceeds the sum, then remove the starting elements
			while(sum > x && start < end-1){
				sum -= arr[start];
				start++;
			}
			
			// Add this element to curr_sum
			if(end < n) sum += arr[end];
		}
		if(sum != x){
			result[0] = -1;
			return result;
		}
		result[0] = start;
		result[1] = end;
		return result;
	}

	public static void main(String[] args) {
		A053_FindContiguousSubarrayWithGivenSum obj = new A053_FindContiguousSubarrayWithGivenSum();
		int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
		int[] result = obj.sumSubarray(arr,230);
		if(result[0] == -1) System.out.println("sumSubarray sequence not found");
		else{
			System.out.print("sumSubarray sequence is: ");
			for(int i = result[0]; i <= result[1];i++){
				System.out.print(arr[i]+",");
			}
		}
	}
}
