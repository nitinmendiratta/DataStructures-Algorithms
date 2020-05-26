package Array_Matrix;

/*
 * http://quiz.geeksforgeeks.org/construct-array-pair-sum-array/
 * Time complexity is O(n)
 */
public class A116_ConstructArrayFromItsPairSumArray {

	// Fills element in arr[] from its pair sum array pair[]. n is size of arr[]
	public void constructArr(int arr[], int pair[], int n) {
		arr[0] = (pair[0] + pair[1] - pair[n - 1]) / 2;
		for (int i = 1; i < n; i++)
			arr[i] = pair[i - 1] - arr[0];
	}

	public static void main(String[] args) {
		A116_ConstructArrayFromItsPairSumArray obj = new A116_ConstructArrayFromItsPairSumArray();
		int pair[] = { 15, 13, 11, 10, 12, 10, 9, 8, 7, 5 };
		int n = 5;
		int[] arr = new int[n];
		obj.constructArr(arr, pair, n);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
