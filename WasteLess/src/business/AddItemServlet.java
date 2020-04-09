package business;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodItemDao;
import persistent.FoodItem;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static boolean isValidFormat(String format, String value, Locale locale) {
 
        LocalDateTime ldt = null;
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

        try {
            ldt = LocalDateTime.parse(value, fomatter);
            String result = ldt.format(fomatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(value, fomatter);
                String result = ld.format(fomatter);
                return result.equals(value);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(value, fomatter);
                    String result = lt.format(fomatter);
                    return result.equals(value);
                } catch (DateTimeParseException e2) {
                }
            }
        }

        return false;
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date purchase_date = null, expiration_date = null, consumption_date = null;
		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int calorie_value = Integer.parseInt(request.getParameter("calorie_value"));
		String purchase = request.getParameter("purchase_date");
		String expiration = request.getParameter("expiration_date");
		String consumption = request.getParameter("consumption_date");
        
        if (isValidFormat("yyyy-MM-dd", purchase, Locale.ENGLISH) && 
        		isValidFormat("yyyy-MM-dd", expiration, Locale.ENGLISH) && 
        		(isValidFormat("yyyy-MM-dd", consumption, Locale.ENGLISH) || consumption.equals(""))) {
        	try {
        		purchase_date = sdformat.parse(purchase);
        		expiration_date = sdformat.parse(expiration);
        		consumption_date = sdformat.parse(consumption);
        	} catch (ParseException e) {
        		e.printStackTrace();
        	}
        	FoodItem food = new FoodItem(name, quantity, calorie_value, purchase_date, expiration_date, consumption_date);
            FoodItemDao dao = new FoodItemDao();
            dao.addFoodItem(food);
            request.setAttribute("add", "Added successfully!");
    		request.getRequestDispatcher("/Home.jsp").forward(request, response);
        } else {
        	request.setAttribute("add", "The input format for the dates is incorrect. Try YYYY-MM-DD.");
        	request.getRequestDispatcher("/AddItem.jsp").forward(request, response);
        }
        
	}

}
