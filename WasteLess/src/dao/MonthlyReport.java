package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import persistent.FoodItem;

public class MonthlyReport implements ReportFactory {
	
	@Override
	public Calendar getCalendarForNow() {
	    Calendar calendar = GregorianCalendar.getInstance();
	    calendar.setTime(new Date());
	    return calendar;
	}
	
	@Override
	public void setTimeToBeginningOfDay(Calendar calendar) {
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	}

	@Override
	public void setTimeToEndOfDay(Calendar calendar) {
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MILLISECOND, 999);
	}
	
	@Override
	public Date getStartDay() {
		Date beginning;
		Calendar calendar = getCalendarForNow();
		setTimeToBeginningOfDay(calendar);
	    beginning = calendar.getTime();
	    return beginning;
	}
	
	@Override
	public Date getEndDay() {
		Date end;
		Calendar calendar = getCalendarForNow();
		setTimeToEndOfDay(calendar);
	    end = calendar.getTime();
	    return end;
	}

	@Override
	public String generateReport() {
		Date beginning, end;
		beginning = getStartDay();
		end = getEndDay();
	    int nrOfWastedItems = 0;
		String all="This month, from " + beginning.toString() + " to " + end.toString() +
				", the following products were wasted:<br>";
		FoodItemDao d = new FoodItemDao();
		List<FoodItem> list = d.getAlldata();
		for(FoodItem item:list) {
			if(item.getExpiration_date().compareTo(beginning) >= 0 && item.getExpiration_date().compareTo(end) <= 0) {
				if(item.waste() == true) {
					all+="	-> " + item.getName() + "<br>";
					nrOfWastedItems++;
				}
			}
		}
		all += "<br><br> The total number of wasted products this month is: " + nrOfWastedItems;
		return all;
	}
	
	public static void main(String[] args) {
		MonthlyReport r = new MonthlyReport();
		r.generateReport();
		
	}

}
