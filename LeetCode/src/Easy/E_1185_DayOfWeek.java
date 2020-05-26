package Easy;
/*
 * https://leetcode.com/problems/day-of-the-week/
 */
public class E_1185_DayOfWeek {


	//Zeller's congruence or Kim larsen calculation formula.
	String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	public String dayOfTheWeek(int d, int m, int y) {
		if (m < 3) {
			m += 12;
			y -= 1;
		}
		int c = y / 100;
		y = y % 100;
		int w = (c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + d - 1) % 7;
		return days[(w + 7) % 7];
	}
	public static void main(String[] args) {
		E_1185_DayOfWeek obj = new E_1185_DayOfWeek();
		System.out.println(obj.dayOfTheWeek(31, 8, 2019));
	}
}
