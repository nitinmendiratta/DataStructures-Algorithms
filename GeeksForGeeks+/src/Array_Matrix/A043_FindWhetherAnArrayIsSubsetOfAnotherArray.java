package Array_Matrix;
import java.util.Arrays;
/*
 * http://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
 * 1) Sort both arrays: arr1[] and arr2[] O(mLogm + nLogn)
 * 2) Use Merge type of process to see if all elements of sorted arr2[] are present in sorted arr1[].
 * Time Complexity: O(mLogm + nLogn)
 */
public class A043_FindWhetherAnArrayIsSubsetOfAnotherArray {

	public boolean isSubset(int[] a1, int[] a2){
		
		int len1 = a1.length;
		int len2 = a2.length;
		if(len1 < len2) return false;
		Arrays.sort(a1);
		Arrays.sort(a2);
		int i = 0,j = 0;
		
		while(i < len1 && j < len2){
			if(a1[i] < a2[j]){
				i++;
			}else if(a1[i] == a2[j]){
				i++;
				j++;
			}else if(a2[j] < a1[i]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		A043_FindWhetherAnArrayIsSubsetOfAnotherArray obj = new A043_FindWhetherAnArrayIsSubsetOfAnotherArray();
		int[] a1 = {1,4,2,2};
		int[] a2 = {1,4,2};
		System.out.println("is subset:"+obj.isSubset(a1,a2));
	}
}
