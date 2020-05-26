package Array_Matrix;
import java.util.Arrays;
import java.util.Comparator;
/*
 * http://www.geeksforgeeks.org/find-four-numbers-with-sum-equal-to-given-sum/
 * http://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
 * 
1) Create an auxiliary array aux[] and store sum of all possible pairs in aux[]. 
The size of aux[] will be n*(n-1)/2 where n is the size of A[].
2) Sort the auxiliary array aux[].
3) Now the problem reduces to find two elements in aux[] with sum equal to X. 
We can use method 1 of this post to find the two elements efficiently. 
There is following important point to note though. An element of aux[] represents a pair from A[]. 
While picking two elements from aux[], we must check whether the two elements have an element of A[] in common. 
For example, if first element sum of A[1] and A[2], and second element is sum of A[2] and A[4], 
then these two elements of aux[] don’t represent four distinct elements of input array A[].
 */

//The following structure is needed to store pair sums in aux[]
class pairSum{
	int first; // index (int A[]) of first element in pair
	int sec; // index of second element in pair
	int sum;  // sum of the pair
};

public class A068_69_FindFourElementsThatSumToaValue {

	// Time Complexity: O(n^3)
	public void Check4sumApproach1(int[] A,int X){
		int n = A.length;
		int l, r;

		// Sort the array in increasing order, using library function for quick sort
		Arrays.sort (A);

		/* Now fix the first 2 elements one by one and find the other two elements */
		for (int i = 0; i < n - 3; i++){
			for (int j = i+1; j < n - 2; j++){
				// Initialize two variables as indexes of the first and last elements in the remaining elements
				l = j + 1;
				r = n-1;

				// To find the remaining two elements, move the index variables (l & r) toward each other.
				while (l < r){
					if( A[i] + A[j] + A[l] + A[r] == X){
						System.out.println(A[i]+","+A[j]+","+A[l]+","+A[r]);
						return;
						//l++; r--;
					}
					else if (A[i] + A[j] + A[l] + A[r] < X)
						l++;
					else // A[i] + A[j] + A[l] + A[r] > X
						r--;
				} // end of while
			} // end of inner for loop
		} // end of outer for loop
		System.out.println("No elements found");
	}

	// Time Complexity: O(n^2logn): the code is throwing error right now.
	public void Check4sumApproach2 (int arr[], int X){
		int i, j;
		int n = arr.length;
		// Create an auxiliary array to store all pair sums
		int size = (n*(n-1))/2;
		pairSum aux[] = new pairSum[size];

		/* Generate all possible pairs from A[] and store sums
	       of all possible pairs in aux[] */
		int k = 0;
		for (i = 0; i < n-1; i++){
			for (j = i+1; j < n; j++){
				aux[k].sum = arr[i] + arr[j];
				aux[k].first = i;
				aux[k].sec = j;
				k++;
			}
		}

		// Sort the aux[] array using library function for sorting
		Arrays.sort(aux, new Comparator<pairSum>() {
			public int compare(pairSum a, pairSum b) {
				return (a.sum - b.sum );
			}
		});

		// Now start two index variables from two corners of array
		// and move them toward each other.
		i = 0;
		j = size-1;
		while (i < size && j >=0 ){
			if ((aux[i].sum + aux[j].sum == X) && noCommon(aux[i], aux[j])){
				System.out.println("Elements are:"+arr[aux[i].first]+", "+arr[aux[i].sec]
						+", "+arr[aux[j].first]+", "+arr[aux[j].sec]);
				return;
			}
			else if (aux[i].sum + aux[j].sum < X)
				i++;
			else
				j--;
		}
	}
	// Function to check if two given pairs have any common element or not
	boolean noCommon(pairSum a, pairSum b){
		if (a.first == b.first || a.first == b.sec ||
				a.sec == b.first || a.sec == b.sec)
			return false;
		return true;
	}

	public static void main(String[] args) {
		A068_69_FindFourElementsThatSumToaValue obj = new A068_69_FindFourElementsThatSumToaValue();
		int arr[] = {10, 20, 30, 40, 1, 2};
		int X = 91;
		obj.Check4sumApproach1(arr,X);
		obj.Check4sumApproach2(arr,X);

	}
}
