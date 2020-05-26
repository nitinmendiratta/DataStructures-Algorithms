package Array_Matrix;
import java.util.*;
/* http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/ 
 * 
 * */

public class A092_PrintAllPossibleCombinationsOfElementsInAnArray {

	// The main function that prints all combinations of size r in arr[] of size n. Not working for duplicates
	public ArrayList<String> printCombination(int arr[], int r){
		int n = arr.length;
		ArrayList<String> result = new ArrayList<String>();
		// A temporary array to store all combination one by one
		int data[] = new int[r];
		
		// Sort array to handle duplicates
		//Arrays.sort(arr);;
		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, n, r, 0, data, 0,result);
		return result;
	}
	/* arr[]  ---> Input Array
   		n      ---> Size of input array
   		r      ---> Size of a combination to be printed
   		index  ---> Current index in data[]
   		data[] ---> Temporary array to store current combination
   		i      ---> index of current element in arr[]     
	 */
	public void combinationUtil(int arr[], int n, int r, int index, int data[], int i, ArrayList<String> result){
		// Current cobination is ready, print it
		if (index == r){
			String s = "";
			for (int j = 0; j < r; j++)		s += data[j];
			result.add(s);
			return;
		}
		// When no more elements are there to put in data[]
		if (i >= n)	return;
		// current is included, put next at next location
		data[index] = arr[i];
		combinationUtil(arr, n, r, index+1, data, i+1,result);
		
		// Remove duplicates
//	    while (arr[i] == arr[i+1])
//	        i++;
    
		// current is excluded, replace it with next (Note that i+1 is passed, but index is not changed)
		combinationUtil(arr, n, r, index, data, i+1,result);
	}

	public static void main(String[] args) {
		A092_PrintAllPossibleCombinationsOfElementsInAnArray obj = new A092_PrintAllPossibleCombinationsOfElementsInAnArray(); 
		int arr[] = {1, 2, 1, 3, 1};
		int r = 3;
		ArrayList<String> result = obj.printCombination(arr, r);
		System.out.println(result);
	}
}