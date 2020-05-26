package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class E_0448_FindAllNumbersDisappearedInArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
	public static void main(String[] args) {
		E_0448_FindAllNumbersDisappearedInArray obj = new E_0448_FindAllNumbersDisappearedInArray();
		int[] input = new int[] {4,3,2,7,8,2,3,1};
		System.out.println(obj.findDisappearedNumbers(input));
	}
}
