package Easy;
import java.util.*;
/**
 * https://leetcode.com/problems/rotate-array/
 */
public class E_0189_RotateArray {
	
	 public void rotate(int[] nums, int k) {
	        int len = nums.length;
	        k = k % nums.length;
	        int count = 0;
	        for (int start = 0; count < nums.length; start++) {
	            int current = start;
	            int prev = nums[start];
	            while(true){
	                int next = (current + k) % len;
	                int temp = nums[next];
	                nums[next] = prev;
	                current  = next;
	                prev = temp;
	                count++; 
	                if(start == current) break;
	            }
	        }
	    }
	public static void main(String[] args) {
		E_0189_RotateArray obj = new E_0189_RotateArray();
		int[] arr = new int[]{2,2,1};
		obj.rotate(arr, 1);
		System.out.println(Arrays.toString(arr));
	}

}
