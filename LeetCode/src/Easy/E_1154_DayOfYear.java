package Easy;
/*
 * https://leetcode.com/problems/day-of-the-year/
 */
public class E_1154_DayOfYear {

	public int dayOfYear(String date) {
		int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] split = date.split("-");
		
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);
		int res = 0;
		
		boolean isLeap = (((year % 4 == 0) && (year % 100 != 0)) || 
	            (year % 400 == 0)); 
		
		if(isLeap) days[1] = 29;
		
		for(int i = 0; i < month-1; i++) {
			res += days[i];
		}
		return res+day;
	}
	public static void main(String[] args) {
		E_1154_DayOfYear obj = new E_1154_DayOfYear();
		System.out.println(obj.dayOfYear("2019-01-09"));
		System.out.println(obj.dayOfYear("2019-02-10"));
		System.out.println(obj.dayOfYear("2003-03-01"));
		System.out.println(obj.dayOfYear("2004-03-01"));
	}
}
