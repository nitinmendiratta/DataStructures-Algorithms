package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/pancake-sorting/
 * https://www.youtube.com/watch?v=RB9hlDDWQY0
 */
public class A081_PancakeSorting {

	public void sort(int[] arr){
		int n = arr.length,k,j,temp;
		// Start from the complete array and one by one reduce current size by one
		for (int curr_size = n; curr_size > 1; --curr_size){
			// Find index of the maximum element in arr[0..curr_size-1]
			int mi = findMax(arr, curr_size);

			// Move the maximum element to end of current array if it's not already at the end
			if (mi != curr_size-1){
				// To move at the end, first move maximum number to beginning 
				flip(arr, mi);
				// Now move the maximum number to end by reversing current array
				flip(arr, curr_size-1);
			}
		}
	}

	public void flip(int[] arr,int i){
		int temp, start = 0;
		while (start < i){
			temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
			start++;
			i--;
		}
	}
	/* Returns index of the maximum element in arr[0..n-1] */
	public int findMax(int arr[], int n){
		int mi = 0, i = 0;
		for (mi = 0, i = 0; i < n; ++i)
			if (arr[i] > arr[mi])
				mi = i;
		return mi;
	}
	public static void main(String[] args) {
		A081_PancakeSorting obj = new A081_PancakeSorting();
		int[] arr = {23, 10, 20, 11, 12, 6, 7};
		obj.sort(arr);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
