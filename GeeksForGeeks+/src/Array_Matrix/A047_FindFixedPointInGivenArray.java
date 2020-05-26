package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
 */
 
public class A047_FindFixedPointInGivenArray {

	public int fixPoint(int[] arr, int low, int high){
	
		if(high >= low){
			int mid = (low + high)/2;  /*low + (high - low)/2;*/
			if(mid == arr[mid])
				return mid;
			if(mid > arr[mid])
				return fixPoint(arr, (mid + 1), high);
			else
				return fixPoint(arr, low, (mid -1));
		}
		/* Return -1 if there is no Fixed Point */
		return -1;
	}

	public static void main(String[] args) {
		A047_FindFixedPointInGivenArray obj = new A047_FindFixedPointInGivenArray();
		int[] arr = {-10, -1, 0, 3, 10, 11, 30, 50, 100};
		System.out.println("fix point exists at:"+obj.fixPoint(arr,0,arr.length-1));
	}
}
