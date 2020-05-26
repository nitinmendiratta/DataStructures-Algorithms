package Easy;
/*
 * https://leetcode.com/problems/nim-game/
 */
public class E_0292_NimGame {

	public boolean canWinNim(int n) {
		return (n % 4 != 0);
	}
	
	public static void main(String[] args) {
		E_0292_NimGame obj = new E_0292_NimGame();
		System.out.println(obj.canWinNim(12));
	}
}
