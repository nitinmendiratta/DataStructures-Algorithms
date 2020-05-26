package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/move-zeroes/
 */
public class E_0283_MoveZeroes {
	
	public void moveZeroes(int[] nums) {
        int len = nums.length;
        for(int lastZeroFoundAt = 0, i = 0; i < len; i++){
            if(nums[i] != 0){
                nums[lastZeroFoundAt] = nums[i];
                // case if i and lastZeroFoundAt point to same non zero element
                if(lastZeroFoundAt != i){
                    nums[i] = 0;
                }
                lastZeroFoundAt++;
            }
        }
    }
	public static void main(String[] args) {
		E_0283_MoveZeroes obj = new E_0283_MoveZeroes();
		int[] input = new int[]{3,0,1};
		obj.moveZeroes(input);
		System.out.println(Arrays.toString(input));
	}

}
