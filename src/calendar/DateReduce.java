package calendar;

import java.util.Calendar;


public class DateReduce {
	public static void main(String[] args) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(Calendar.DAY_OF_MONTH, 2);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(c1.getTimeInMillis()-c2.getTimeInMillis());
	}
}
