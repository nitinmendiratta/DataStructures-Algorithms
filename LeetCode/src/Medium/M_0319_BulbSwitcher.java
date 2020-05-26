package Medium;

/*
 * https://leetcode.com/problems/bulb-switcher/
 */
public class M_0319_BulbSwitcher {

	/*
	 * https://leetcode.com/problems/bulb-switcher/discuss/77112/Share-my-o(1)-solution-with-explanation
	 */
	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}

	public static void main(String[] args) {
		M_0319_BulbSwitcher obj = new M_0319_BulbSwitcher();
		System.out.println(obj.bulbSwitch(3));
	}

}
