package dao;

import java.util.Calendar;
import java.util.Date;

public interface ReportFactory {
	public String generateReport();
	public Calendar getCalendarForNow();
	public void setTimeToBeginningOfDay(Calendar calendar);
	public void setTimeToEndOfDay(Calendar calendar);
	public Date getStartDay();
	public Date getEndDay();
	
}
