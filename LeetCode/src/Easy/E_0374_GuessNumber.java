package Easy;
/*
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class E_0374_GuessNumber {

	/* Time complexity : O(log2n). Binary Search is used.
	 * Space complexity : O(1). No extra space is used.
	*/
	public int guessNumber(int n) {
		int i = 1, low = 1, high = n, mid = -1;
		while(low <= high){
			mid = (high - low)/2 + low;
			if(guess(mid) == 0){
				return mid;
			}else if(guess(mid) == -1){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return mid;
	}
	private int guess(int n) {
		if(n == 3) return 0;
		else if(n > 3) return 1;
		else return -1;
	}
	public static void main(String[] args) {
		E_0374_GuessNumber obj = new E_0374_GuessNumber();
		System.out.println(obj.guessNumber(10));
	}
}
