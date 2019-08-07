package com.lendbox.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarConvert {
	public String convertDate(Calendar cal)
	{
		SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyyy");
		String formatDate=format.format(cal.getTime());
		return formatDate;
	}
}
