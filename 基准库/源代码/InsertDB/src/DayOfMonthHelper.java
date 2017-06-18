
public class DayOfMonthHelper {

	public static int getDayOfMonth(int year, int month) {
		boolean leap;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			leap = true;
		} else {
			leap = false;
		}
		switch (month) {
		case 1:
			return 31;
		case 2:
			if (leap) {
				return 29;
			} else {
				return 28;
			}
		case 3:
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		case 12:
			return 31;
		default:
			return 0;
		}
	}
}
