package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class E_0599_MinimumIndexSumOfTwoLists {
	/*
	 * Time complexity : O(l1 + l2)
	 * Space complexity : O(l1*x)
	 */
	public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap < String, Integer > map = new HashMap < String, Integer > ();
		for (int i = 0; i < list1.length; i++)
			map.put(list1[i], i);
		List < String > res = new ArrayList < > ();
		int min_sum = Integer.MAX_VALUE, sum;
		for (int j = 0; j < list2.length && j <= min_sum; j++) {
			if (map.containsKey(list2[j])) {
				sum = j + map.get(list2[j]);
				if (sum < min_sum) {
					res.clear();
					res.add(list2[j]);
					min_sum = sum;
				} else if (sum == min_sum)
					res.add(list2[j]);
			}
		}
		return res.toArray(new String[res.size()]);
	}
	public static void main(String[] args) {
		E_0599_MinimumIndexSumOfTwoLists obj = new E_0599_MinimumIndexSumOfTwoLists();
		String[] str1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] str2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		System.out.println(Arrays.toString(obj.findRestaurant(str1, str2)));
	}
}
