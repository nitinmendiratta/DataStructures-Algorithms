package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/distribute-candies-to-people/
 */
public class E_1103_DistributeCandiesToPeople {

	// Use give % num_people to determine the current index of the people, where give is the give-th giving of candy;
	// Increase each giving amount by 1 till run out of candies.
	
	// Time: O(sqrt(candies)), space: O(num_people).
	public int[] distributeCandies(int candies, int num_people) {
		int[] people = new int[num_people];
		
		// loop until we run out of candies
		for (int give = 0; candies > 0; candies -= give) {
			// we take min in case we have no more candies left in that case candies < give
			people[give % num_people] +=  Math.min(candies, ++give);
		}
		return people;
	}
	public static void main(String[] args) {
		E_1103_DistributeCandiesToPeople obj = new E_1103_DistributeCandiesToPeople();
		System.out.println(Arrays.toString(obj.distributeCandies(7, 4)));
	}
}
