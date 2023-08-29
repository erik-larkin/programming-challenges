/*
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-time-conversion/problem
 *  August 29th 2023
 *  By Erik Larkin
 */

public class TimeConversion {

	private static final int AM_PM_START_INDEX = 8;
	private static final int HOUR_END_INDEX = 2;

	public static String timeConversion(String s) {
		
		int hours = Integer.parseInt(s.substring(0, HOUR_END_INDEX));
		boolean isPM = s.charAt(AM_PM_START_INDEX) == 'P';
		
		if (hours < 12 && isPM) {
			hours += 12;
		} else if (hours == 12 && !isPM) {
			hours -= 12;
		}

		return String.format("%02d%s", hours, s.substring(HOUR_END_INDEX, AM_PM_START_INDEX));

	}
}
