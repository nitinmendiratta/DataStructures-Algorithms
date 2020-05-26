package Easy;
/*
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class E_1342_NumberStepsReduceNumberToZero {

	//	In worst case, each - operation corresponds to one /.
	//	Time: O(log(num)), space: O(1).
	public int numberOfSteps (int num) {
		int steps = 0;
		while(num > 0) {
			
			if(num%2 == 0) {
				num /=2;
			}else {
				num--;
			}
			steps++;
		}
		return steps;
	}
	public static void main(String[] args) {
		E_1342_NumberStepsReduceNumberToZero obj = new E_1342_NumberStepsReduceNumberToZero();
		System.out.println(obj.numberOfSteps(14));
	}
}
