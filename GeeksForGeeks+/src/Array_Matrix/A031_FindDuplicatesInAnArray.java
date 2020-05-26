package Array_Matrix;

import java.util.*;

/*
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 */
 
public class A031_FindDuplicatesInAnArray {

	public ArrayList<Integer> dup(int[] arr){
		int n = arr.length;
		int j = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i = 0;i < n;i++){
			j = Math.abs(arr[i]);
			if(arr[j] >= 0)	
				arr[j] = -arr[j];
			else
				result.add(j);
		}
		return result;
	}
	
	public static void main(String[] args) {
		A031_FindDuplicatesInAnArray obj = new A031_FindDuplicatesInAnArray();
		int[] arr = {1, 2, 3, 1, 3, 6, 6};
		ArrayList<Integer> result = new ArrayList<Integer>(obj.dup(arr));
		System.out.println(result);
	}
}
