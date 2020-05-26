package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 */
public class A032_EquilibriumIndexOfAnArray {

	public int equibIndex(int[] arr){
		int n = arr.length, sum = 0;      // initialize sum of whole array
		int leftsum = 0; // initialize leftsum
		int i;

		/* Find sum of the whole array */
		for (i = 0; i < n; ++i)
			sum += arr[i];

		for( i = 0; i < n; ++i){
			sum -= arr[i]; // sum is now right sum for index i
			if(leftsum == sum)	return i;
			leftsum += arr[i];
		}
		/* If no equilibrium index found, then return -1 */
		return -1;
	}

	public static void main(String[] args) {
		A032_EquilibriumIndexOfAnArray obj = new A032_EquilibriumIndexOfAnArray();
		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
		int result = obj.equibIndex(arr);
		System.out.println(result);
	}
}