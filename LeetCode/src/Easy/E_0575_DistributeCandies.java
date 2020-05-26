package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/distribute-candies/
 */
public class E_0575_DistributeCandies {

	/*
	 * Time complexity : O(n). The entire candies array is traversed only
	 * once. Here, n refers to the size of candies array.
	 * 
	 * Space complexity : O(n). set will be of size n in the worst case.
	 */
	public int distributeCandies(int[] candies) {
		HashSet < Integer > set = new HashSet < > ();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
	}
	public static void main(String[] args) {
		E_0575_DistributeCandies obj = new E_0575_DistributeCandies();
		int[] candies = {1,1,2,2,3,3};
		System.out.println(obj.distributeCandies(candies));
	}
}
