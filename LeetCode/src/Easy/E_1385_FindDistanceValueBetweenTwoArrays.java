package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 */
public class E_1385_FindDistanceValueBetweenTwoArrays {

	/*
	 * Arrays.binarySearch(int[] a, int key) returns the index of the search key, if
	 * it is contained in the array. Otherwise, (-(insertion point) - 1). 
	 * The insertion point is defined as the point at which the key would be inserted
	 * into the array: the index of the first element greater than the key, or
	 * a.length if all elements in the array are less than the specified key.
	 */
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int count = 0;
		Arrays.sort(arr2);

		for (int num : arr1) {
			int index = Arrays.binarySearch(arr2, num);
			if (index >= 0) { /* arr2 contains num */
				continue;
			}

			if (index == -1) { /* num is smaller than the first element in sorted arr2 */
				if (Math.abs(num - arr2[0]) > d) {
					count++;
				}
			} else if (index == -arr2.length - 1) { /* num is larger than the last element in sorted arr2 */
				if (Math.abs(num - arr2[arr2.length - 1]) > d) {
					count++;
				}
			} else {
				index = -index - 1;
				if (Math.abs(num - arr2[index]) > d && Math.abs(num - arr2[index - 1]) > d) {
					count++;
				}
			}
		}

		return count;
	}

	// Approach2: TreeSet
	public int findTheDistanceValueApproach2(int[] arr1, int[] arr2, int d) {
		TreeSet<Integer> ts = new TreeSet<>();
		int res = 0;
		for (int n : arr2)
			ts.add(n);

		for (int i = 0; i < arr1.length; i++) {
			Integer ceiling = ts.ceiling(arr1[i]);
			Integer floor = ts.floor(arr1[i]);

			// check how far are the closest elements in arr2 to curr element in arr1
			if ((ceiling != null && Math.abs(ceiling - arr1[i]) <= d)
					|| (floor != null && Math.abs(floor - arr1[i]) <= d))
				continue;
			else
				res++;
		}
		return res;
	}

	public static void main(String[] args) {
		E_1385_FindDistanceValueBetweenTwoArrays obj = new E_1385_FindDistanceValueBetweenTwoArrays();
		System.out.println(obj.findTheDistanceValue(new int[] { 1 }, new int[] { -4, -3, 6, 10, 20, 30 }, 3));
	}
}
