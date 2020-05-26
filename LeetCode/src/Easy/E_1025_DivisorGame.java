package Easy;
/*
 * https://leetcode.com/problems/divisor-game/
 */
public class E_1025_DivisorGame {

	// Explanation: https://leetcode.com/problems/divisor-game/discuss/274606/JavaC%2B%2BPython-return-N-2-0
	public boolean divisorGame(int N) {
		return N % 2 == 0;
    }
	public static void main(String[] args) {
		E_1025_DivisorGame obj = new E_1025_DivisorGame();
		System.out.println(obj.divisorGame(2));		
	}
}
