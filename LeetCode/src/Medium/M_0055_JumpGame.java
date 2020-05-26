package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/jump-game/
 */
enum Index {
	GOOD, BAD, UNKNOWN
}
public class M_0055_JumpGame {


	// Best case O(N) Greedy
	public boolean canJump(int[] nums) {
		int lastPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}
	
	// Approach 2: O(N2) Dynamic Programming Bottom Up
	public boolean canJumpDPBottomUp(int[] nums) {
		Index[] memo = new Index[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Index.UNKNOWN;
		}
		memo[memo.length - 1] = Index.GOOD;

		for (int i = nums.length - 2; i >= 0; i--) {
			int furthestJump = Math.min(i + nums[i], nums.length - 1);
			for (int j = i + 1; j <= furthestJump; j++) {
				if (memo[j] == Index.GOOD) {
					memo[i] = Index.GOOD;
					break;
				}
			}
		}

		return memo[0] == Index.GOOD;
	}

	// Approach 3: O(N2) Dynamic Programming Top-down
	Index[] memo;

	public boolean canJumpFromPosition(int position, int[] nums) {
		if (memo[position] != Index.UNKNOWN) {
			return memo[position] == Index.GOOD ? true : false;
		}

		int furthestJump = Math.min(position + nums[position], nums.length - 1);
		for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
			if (canJumpFromPosition(nextPosition, nums)) {
				memo[position] = Index.GOOD;
				return true;
			}
		}

		memo[position] = Index.BAD;
		return false;
	}

	public boolean canJumpDPTopDown(int[] nums) {
		memo = new Index[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Index.UNKNOWN;
		}
		memo[memo.length - 1] = Index.GOOD;
		return canJumpFromPosition(0, nums);
	}

	// my approach O(n2)
	public boolean canJumpMyApproach(int[] nums) {
		if(nums.length == 0) return true;
		boolean[] cache = new boolean[nums.length];
		Arrays.fill(cache, true);
		return canJumpHelper(nums, 0, cache);
	}

	public boolean canJumpHelper(int[] nums, int currIdx, boolean[] cache) {

		if(!cache[currIdx]) return false;

		if(currIdx == nums.length-1) return true;

		int furthestJump = currIdx + nums[currIdx];
		for(int i = furthestJump; i > currIdx; i--) {

			if(i >= nums.length) continue;

			if(canJumpHelper(nums, i, cache)) return true;
		}
		cache[currIdx] = false;
		return false;
	}

	public static void main(String[] args) {
		M_0055_JumpGame obj = new M_0055_JumpGame();
		System.out.println(obj.canJump(new int[] {2,3,1,1,4}));
		System.out.println(obj.canJump(new int[] {3,2,1,0,4}));
		System.out.println(obj.canJump(new int[] {2,0}));
	}
}
