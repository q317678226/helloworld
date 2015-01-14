package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReCalendar {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 11);
		for (int i=1;i<=31;i++) {
			calendar.set(Calendar.DAY_OF_MONTH, i);
			System.out.println(sdf.format(calendar.getTime()));
		}
		
//		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
//		Date date = new Date();
	}
}
