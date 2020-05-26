package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class E_0905_SortArrayByParity {

	public int[] sortArrayByParityII(int[] A) {
		int i = 0, j = 1, n = A.length;

		while (i < n && j < n) {

			// point to even index with odd number on it
			while (i < n && A[i] % 2 == 0) i += 2;

			// point to odd index with even number on it
			while (j < n && A[j] % 2 == 1) j += 2;

			//  will swap only if valid indexes
			if (i < n && j < n) {
				swap(A, i, j);
			}
		}
		return A;
	}
	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[] args) {
		E_0905_SortArrayByParity obj = new E_0905_SortArrayByParity();
		System.out.println(Arrays.toString(obj.sortArrayByParityII(new int[] {1,3})));
	}
}
