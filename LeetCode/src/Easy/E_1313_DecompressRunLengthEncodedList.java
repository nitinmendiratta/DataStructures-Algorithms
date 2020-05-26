package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/decompress-run-length-encoded-list/
 */
public class E_1313_DecompressRunLengthEncodedList {

	
	public int[] decompressRLElist(int[] nums) {
		int size = 0, count = 0, j = 0, val = 0;
		
		for(int i = 0; i < nums.length; i+=2) {
			size += nums[i];
		}
		int[] res = new int[size];
		
		for(int i = 1; i < nums.length; i+=2) {
			count = nums[i-1];
			val = nums[i];
			while(count > 0) {
				
				res[j] = val;
				count--;
				j++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		E_1313_DecompressRunLengthEncodedList obj = new E_1313_DecompressRunLengthEncodedList();
		int[] nums = new int[] {1,2,3,4};
		System.out.println(Arrays.toString(obj.decompressRLElist(nums)));
	}
}
