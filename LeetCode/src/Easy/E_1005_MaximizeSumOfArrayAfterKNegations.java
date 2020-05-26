package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class E_1005_MaximizeSumOfArrayAfterKNegations {

	public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        // queue maintains min element at the top
        for(int x: A) pq.add(x);
        while( K--  > 0) pq.add(-pq.poll());
  
        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;
    }
	/*
	 * 1- sort the numbers in ascending order 
	 * 2- flip all the negative numbers, as
	 * long as k > 0 
	 * 3- find the sum of the new array (with flipped numbers if any)
	 * and keep track of the minimum number 
	 * 4- Now for the return statement
	 * 
	 * res is the total sum of the new array 
	 * K % 2 check if the remaining K is odd because if it's even it will have no effect (we will flip a number and then get it back to the original) 
	 * flip the minimum number and remove twice its
	 * value from the result (twice because we already added it as positive in our
	 * sum operation)
	 */
	public int largestSumAfterKNegationsApproach2(int[] A, int K) {
		Arrays.sort(A);

		for (int i = 0; i < A.length; ++i) {
			
			if(K > 0 && i < A.length && A[i] < 0) {
				A[i] = -A[i];
			}
			--K;
		}

		int res = 0, min = Integer.MAX_VALUE;
		for (int a : A) {
			res += a;
			min = Math.min(min, a);
		}
		return res - (K % 2) * min * 2;
	}



	public int largestSumAfterKNegationsMyApproach(int[] A, int K) {

		int i = 0, j = 0, sum = 0, len = A.length;
		Arrays.sort(A);

		while(i < len && A[i] < 0) i++;

		// i points to first positive number

		// operations to be performed less then -ve numbers
		if(K <= i) {
			// make max -ve numbers as +ve
			while(j < K) {
				A[j] = -A[j];
				j++;
			}
		}else {
			// K > i here
			// operations to be performed more then -ve numbers

			// make all -ve numbers +ve
			// i could be greater then len if all -ve numbers
			while(j < len && j < i) {
				A[j] = -A[j];
				j++;
			}

			// if -ve numbers left are even
			if((K-i)%2 != 0) {
				if(j < len && (j == 0 || A[j] < A[j-1])) {
					A[j] = -A[j];
				}else {
					A[j-1] = -A[j-1];
				}
			}
		}

		j = 0;
		while(j < A.length) {
			sum += A[j];
			j++;
		}
		return sum;
	}
	public static void main(String[] args) {
		E_1005_MaximizeSumOfArrayAfterKNegations obj = new E_1005_MaximizeSumOfArrayAfterKNegations();
		System.out.println(obj.largestSumAfterKNegations(new int[] {4,2,3}, 1));
		System.out.println(obj.largestSumAfterKNegations(new int[] {3,-1,0,2}, 3));
		System.out.println(obj.largestSumAfterKNegations(new int[] {2,-3,-1,0,5,-4}, 4));
		System.out.println(obj.largestSumAfterKNegations(new int[] {-2}, 10));
	}
}
