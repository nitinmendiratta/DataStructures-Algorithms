package Easy;
/*
 * https://leetcode.com/problems/robot-return-to-origin/
 */
public class E_0657_RobotReturnOrigin {

	public boolean judgeCircle(String moves) {
		int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y++;
            else if (move == 'D') y--;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
	}
	public static void main(String[] args) {
		E_0657_RobotReturnOrigin obj = new E_0657_RobotReturnOrigin();
		System.out.println(obj.judgeCircle("UD"));
	}
}
