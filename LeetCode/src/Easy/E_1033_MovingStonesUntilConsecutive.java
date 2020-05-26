package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/moving-stones-until-consecutive/
 */
public class E_1033_MovingStonesUntilConsecutive {


	public int[] numMovesStones(int a, int b, int c) {
		int[] arr = { a, b, c };
		Arrays.sort(arr);
		int first = arr[0], second = arr[1], third = arr[2], minMove = 0, maxMove = 0;

		// Edge case 1: all three stones are next to each other (third - first == 2). Return {0, 0}.
		if (third - first == 2) return new int[] { 0, 0 };

		//Edge case 2: two stones are next to each other, or there is only one space in between. Minimum moves is 1.
		// the position of the middle stone only matters for the minimum moves.
		
		minMove = Math.min(second - first, third - second) <= 2 ? 1 : 2;
		maxMove = third - first - 2;

		return new int[] {minMove, maxMove};
	}

	public static void main(String[] args) {
		E_1033_MovingStonesUntilConsecutive obj = new E_1033_MovingStonesUntilConsecutive();
		System.out.println(Arrays.toString(obj.numMovesStones(1, 2, 5)));
	}
}
