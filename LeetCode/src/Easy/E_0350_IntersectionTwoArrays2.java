package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class E_0350_IntersectionTwoArrays2 {

	//Approach 1 O(N + M) time complexity, O(N) for iterate one of the array to create a hashmap and O(M) to iterate the other array. O(N) space to store such hashmap.
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : nums1){
			int freq = map.getOrDefault(i, 0);
			map.put(i, freq + 1);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i : nums2){
			if(map.get(i) != null && map.get(i) > 0){
				list.add(i);
				map.put(i, map.get(i) - 1);
			}
		}
		int[] ret = new int[list.size()]; 
		for(int i = 0; i < list.size();i++){
			ret[i] = list.get(i);
		}
		return ret;
	}

	//Approach 2 O(nlogn)
	public int[] intersectionHelper(int[] smallArray, int[] bigArray) {
		int len1 = smallArray.length, len2 = bigArray.length, i = 0, j = 0, k = 0;
		int[] output = new int[len1];
		while(i < len1 && j < len2){
			if(smallArray[i] == bigArray[j]){
				output[k++] = smallArray[i];
				i++;
				j++;
			}else if(smallArray[i] > bigArray[j]){
				j++;
			}else{
				i++;
			}
		}
		return Arrays.copyOf(output, k);
	}
	public int[] intersectSortedArray(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int len1 = nums1.length, len2 = nums2.length;
		if(len1 <= len2){
			return intersectionHelper(nums1, nums2);
		}
		return intersectionHelper(nums2, nums1);
	}
	public static void main(String[] args) {
		E_0350_IntersectionTwoArrays2 obj = new E_0350_IntersectionTwoArrays2();
		int[] nums1 = new int[]{1,2,2,1};
		int[] nums2 = new int[] {2,2};
		System.out.println(Arrays.toString(obj.intersect(nums1, nums2)));
		System.out.println(Arrays.toString(obj.intersectSortedArray(nums1, nums2)));
	}
}
