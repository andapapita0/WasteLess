package business;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodItemDao;
import persistent.FoodItem;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date consumption_date = null;
        try {
			consumption_date = sdformat.parse(request.getParameter("consumption_date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        FoodItem foodItem = new FoodItem();
        FoodItemDao dao = new FoodItemDao();
        List<FoodItem> groceries= dao.getAlldata();
        for(FoodItem item: groceries) {
        	if(item.getName().equals(name))
        		foodItem = item;
        }
        foodItem.setConsumption_date(consumption_date);
        dao.updateFoodItem(foodItem);
        request.setAttribute("update", "Updated successfully!");
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

}
