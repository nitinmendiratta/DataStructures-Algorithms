package Easy;
import java.time.*;
import java.time.temporal.ChronoUnit;
/*
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 */
public class E_1360_NumberOfDaysBetweenTwoDates {

	// time since 1971
	public int daysBetweenDates(String date1, String date2) {    
		return Math.abs(countSince1971(date1) - countSince1971(date2));
	}

	public int countSince1971(String date) {
		int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] data = date.split("-");

		int year = Integer.parseInt(data[0]);
		int month = Integer.parseInt(data[1]);
		int day = Integer.parseInt(data[2]);

		for (int i = 1971; i < year; i++) {
			day += isALeapYear(i) ? 366 : 365;
		}
		for (int i = 1; i < month; i++) {
			if (isALeapYear(year) && i == 2) {
				day += 1;
			} 
			day += monthDays[i];
		}
		return day;
	}

	public boolean isALeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}


	// using inbuilt API
	public int daysBetweenDatesApproach2(String date1, String date2) {
		return Math.abs((int)ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
	}
	public static void main(String[] args) {
		E_1360_NumberOfDaysBetweenTwoDates obj = new E_1360_NumberOfDaysBetweenTwoDates();
		//System.out.println(obj.daysBetweenDates("2019-06-29", "2019-06-30"));
		System.out.println(obj.daysBetweenDates("2020-01-15", "2019-12-31"));
	}
}
