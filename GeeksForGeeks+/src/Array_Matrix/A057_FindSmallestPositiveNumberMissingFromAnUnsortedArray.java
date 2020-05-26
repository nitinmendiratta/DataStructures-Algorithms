package Array_Matrix;
import java.util.Arrays;
/*
 * http://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 */
public class A057_FindSmallestPositiveNumberMissingFromAnUnsortedArray {

	public int smallestPositive(int[] arr){
		int n = arr.length;
		//Segregate positive numbers from others i.e., move all non-positive numbers to left side.
		int shift  = segregate(arr);
		arr = Arrays.copyOfRange(arr, shift, n);
		n = arr.length;

		// Mark arr[i] as visited by making arr[arr[i] - 1] negative. Note that 
		// 1 is subtracted because index start from 0 and positive numbers start from 1
		for(int i = 0; i < n;i++){
			if((Math.abs(arr[i]) - 1) < n && arr[Math.abs(arr[i]) - 1] > 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
		}

		// Return the first index value at which is positive
		for(int i = 0; i < n; i++)
			if (arr[i] > 0)  return i+1;  // 1 is added becuase indexes start from 0

		return n+1;
	}

	int segregate (int arr[]){
		int size = arr.length;
		int j = 0, i;
		for(i = 0; i < size; i++){
			if (arr[i] <= 0){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;  // increment count of non-positive integers
			}
		}
		return j;
	}

	/*public int segregate(int[] arr){
		int l = 0,count = 0;
		int r = arr.length-1;
		int temp = 0;
		while(l < r){
			while(arr[l] > 0 && l < r) l++; //search for first -ve number from left		
			while(arr[r] <= 0 && l < r) { //search for first +ve number from right
				r--; 
				count++;
			}
			if(l < r){
				temp = arr[r];
				arr[r] = arr[l];
				arr[l] = temp;
				l++;
				r--;
				count++;
			}
		}
		if(arr[r] <= 0) count++;
		return count;
	}*/
	public static void main(String[] args) {
		A057_FindSmallestPositiveNumberMissingFromAnUnsortedArray obj = new A057_FindSmallestPositiveNumberMissingFromAnUnsortedArray();
		int[] arr = {2, 3, 7, 6, 8, -1, -10, 15}; // -1,-10,2,3,6,7,8,15
		System.out.println("smallest Positive numbr:"+obj.smallestPositive(arr));
	}
}
