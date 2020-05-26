package Easy;
/*
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93817/It-is-a-math-question
 */
public class E_0453_MinimumMovesEqualArrayElements {

	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE, sum = 0;
		for (int n : nums) {min = Math.min(min, n); sum += n;}
		/*
		 * why x = minNum + m our goal is :increment minNum to be equal to maxNum
		 * No matter how many add operations are executed,the goal won't change. Every
		 * time we do the add operation,the min number in the array must participate in.
		 * After an add operation,the minNum is still the min number So the minNum
		 * participate in every add operation So x = minNum + m
		 */
		return sum - nums.length * min;
	}
	public static void main(String[] args) {
		E_0453_MinimumMovesEqualArrayElements obj = new E_0453_MinimumMovesEqualArrayElements();
		int[] input = new int[] {4,3,2,7,8,2,3,1};
		System.out.println(obj.minMoves(input));
	}
}
