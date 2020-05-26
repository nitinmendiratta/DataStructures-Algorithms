package Easy;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 */
public class E_0922_SortArrayByParity2 {

	public int[] sortArrayByParityII(int[] A) {
		int len = A.length, i = 0, j = len - 1;

		while(i < len && j >= 0){
			// point to even index with odd number on it
			while(i < len && A[i]%2 == 0) i=i+2;

			// point to odd index with even number on it
			while(j > 0 && A[j]%2 != 0) j = j-2;

			//  will swap only if valid indexes
			if(i < len && j >= 0){
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
			i=i+2;
			j=j-2;
		}
		return A;
    }
	public static void main(String[] args) {
		E_0922_SortArrayByParity2 obj = new E_0922_SortArrayByParity2();
		System.out.println(Arrays.toString(obj.sortArrayByParityII(new int[] {5,4,3,2,1,0})));
	}
}
