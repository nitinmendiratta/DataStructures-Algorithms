package Medium;
/*
 * https://leetcode.com/problems/reach-a-number/
 */
public class M_0754_ReachNumber {

	// Math problem no idea how it works
	// Explanation: https://leetcode.com/problems/reach-a-number/discuss/112968/Short-JAVA-Solution-with-Explanation
    public int reachNumber(int target) {
        int step = 0, dis = 0;
        target = Math.abs(target); 
        while (dis < target || (dis - target) % 2 != 0) {
            step++; 
            dis += step;
        }
        return step; 
    }
	public static void main(String[] args) {
		M_0754_ReachNumber obj = new M_0754_ReachNumber();
		System.out.println(obj.reachNumber(3));
	}
}
