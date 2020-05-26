package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class E_1431_KidsWithGreatestNumberCandies {

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> res = new ArrayList<>();
		int maxCandies = candies[0];
		
		for(int i = 0; i < candies.length; i++) {
			maxCandies = Math.max(maxCandies, candies[i]);
		}
		
		for(int i = 0; i < candies.length; i++) {
			
			if(extraCandies + candies[i] >= maxCandies) {
				res.add(true);
			}else {
				res.add(false);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		E_1431_KidsWithGreatestNumberCandies obj = new E_1431_KidsWithGreatestNumberCandies();
		System.out.println(obj.kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));
	}
}
