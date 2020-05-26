package Easy;

/*
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class E_1450_NumberStudentsDoingHomeworkGivenTime {

	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int count = 0;

		for (int i = 0; i < startTime.length; i++) {

			int start = startTime[i];
			int end = endTime[i];

			if (queryTime >= start && queryTime <= end) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		E_1450_NumberStudentsDoingHomeworkGivenTime obj = new E_1450_NumberStudentsDoingHomeworkGivenTime();
		System.out.println(obj.busyStudent(new int[] { 1, 2, 3 }, new int[] { 3, 2, 7 }, 4));
		System.out.println(obj.busyStudent(new int[] { 4 }, new int[] { 4 }, 4));
		System.out.println(obj.busyStudent(new int[] { 4 }, new int[] { 4 }, 5));
		System.out.println(obj.busyStudent(new int[] { 1, 1, 1, 1 }, new int[] { 1, 3, 2, 4 }, 0));
		System.out.println(obj.busyStudent(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 },
				new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 5));
	}

}
