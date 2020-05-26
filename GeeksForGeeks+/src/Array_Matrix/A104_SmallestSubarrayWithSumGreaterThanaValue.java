package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class A104_SmallestSubarrayWithSumGreaterThanaValue {

	public int[] subarray(int[] arr, int x){
		int result[] = new int[2];
		int n = arr.length,start = 0,end = 0, minlen = n+1, sum = 0;
		if(sum > x) return result;

		while(end < n){
			// Keep adding array elements while current sum is smaller than x
			while ((sum <= x) && (end < n)){
				// we are doing post increment, so we will have an extra elt whch is not part of the sum
				sum += arr[end++];
			}
			
			// If current sum becomes greater than x.
			while(sum > x && start < n){
				int len = end - start;
				// Update minimum length if needed
				if(len < minlen){
					minlen = len;
					//System.out.println("start: "+start);
					//System.out.println("End: "+end);
					result[0] = start;
					result[1] = end;
				}
				// remove starting elements
				sum -= arr[start++];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		A104_SmallestSubarrayWithSumGreaterThanaValue obj = new A104_SmallestSubarrayWithSumGreaterThanaValue();
		int[] arr = {1, 10, 5, 2, 7};
		int[] result = obj.subarray(arr,9);
		//elts will be from start to end-1 because we have a post increment on end
		for(int i = result[0]; i <= result[1]-1;i++){
			System.out.print(arr[i]+",");
		}
	}
}
