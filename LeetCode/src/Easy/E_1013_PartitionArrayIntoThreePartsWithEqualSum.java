package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class E_1013_PartitionArrayIntoThreePartsWithEqualSum {
	/*
	 * Check if the total sum is divisible by 3;
	 * Loop through the array A, and compute part of sum; if the average value is found, reset the part to 0, and increase the counter;
	 * By the end if the average can be seen for at least 3 times, return true; otherwise return false.
	 */
	public boolean canThreePartsEqualSum(int[] A) {
		int count = 0, sum = 0, total = 0;
        for (int a : A){
            total += a;
        }
        if (total % 3 != 0) return false;
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == (total / 3)) {
                sum = 0;
                count++;
            }
        }
        return count >= 3;
    }
	public static void main(String[] args) {
		E_1013_PartitionArrayIntoThreePartsWithEqualSum obj = new E_1013_PartitionArrayIntoThreePartsWithEqualSum();
		System.out.println(obj.canThreePartsEqualSum(new int[] {0,2,1,-6,6,-7,9,1,2,0,1}));
		System.out.println(obj.canThreePartsEqualSum(new int[] {0,2,1,-6,6,7,9,-1,2,0,1}));
		System.out.println(obj.canThreePartsEqualSum(new int[] {3,3,6,5,-2,2,5,1,-9,4}));
	}
}
