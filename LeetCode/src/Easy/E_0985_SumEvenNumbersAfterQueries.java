package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */
public class E_0985_SumEvenNumbersAfterQueries {

	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] res = new int[A.length];
		int sum = 0, i = 0;

		for(i = 0; i < A.length; i++){
			if(A[i]%2 == 0) sum += A[i];
		}
        
		for(i = 0; i < queries.length; i++){
			int value = queries[i][0];
			int idx = queries[i][1];

			// current elt even
			if(A[idx]%2 == 0){
				if(value%2 == 0){
					// even + even = even
					sum += value;
				}else{
					// even + odd = odd
					sum -= A[idx];
				}
			}else if(value%2 != 0){
				// odd+odd = even
				sum += A[idx] + value;
				// odd+even = odd
				// nothing
			}
			A[idx] += value;
			res[i] = sum;
		}
		return res;
	}
	public static void main(String[] args) {
		E_0985_SumEvenNumbersAfterQueries obj = new E_0985_SumEvenNumbersAfterQueries();
		int[][] queries = new int[][] {
			{1,0},{-3,1},{-4,0},{2,3}
		};
		System.out.println(Arrays.toString(obj.sumEvenAfterQueries(new int[] {1,2,3,4}, queries)));
	}
}
