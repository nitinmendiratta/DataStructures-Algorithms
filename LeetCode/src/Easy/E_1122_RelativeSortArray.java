package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/relative-sort-array/
 */
public class E_1122_RelativeSortArray {
	
	//	Time: O(1)
	//	Space: O(1)

	// https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort
	// Because 0 <= arr1[i], arr2[i] <= 1000, we use an array to count every element.
	// Go through every element in the second array, and update values of the first array based on the order in the second array.
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] cnt = new int[1001];
		// create an array with value as count of each element
		for(int n : arr1) cnt[n]++;

		int i = 0;
		for(int n : arr2) {
			while(cnt[n] > 0) {
				arr1[i] = n; // as i have the count array i dont need original arr anymore
				i++;
				cnt[n]--;
			}
		}
		for(int n = 0; n < cnt.length; n++) {
			while(cnt[n] > 0) {
				arr1[i] = n;
				i++;
				cnt[n]--;
			}
		}
		return arr1;
	}
	
	//	Follow-up: What if this constraint 0 <= arr1[i], arr2[i] <= 1000 doesn't exist?
	//			Use TreeMap.
	//			Time: O(NlogN)
	//			Space: O(N)
	public int[] relativeSortArrayApproach2(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : arr1) map.put(n, map.getOrDefault(n, 0) + 1);
        int i = 0;
        for(int n : arr2) {
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        for(int n : map.keySet()){
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        return arr1;
    }
	public static void main(String[] args) {
		E_1122_RelativeSortArray obj = new E_1122_RelativeSortArray();
		System.out.println(Arrays.toString(obj.relativeSortArray(new int[] {2,3,1,3,2,4,6,7,9,2,19}, new int[] {2,1,4,3,9,6})));
	}
}
