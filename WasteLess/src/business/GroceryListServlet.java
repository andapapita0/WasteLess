package business;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FoodItemDao;
import persistent.FoodItem;

/**
 * Servlet implementation class GroceryListServlet
 */
@WebServlet("/GroceryListServlet")
public class GroceryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroceryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodItemDao dao = new FoodItemDao();
		List<FoodItem> groceries = dao.getAlldata();
		String all = "";
		for(FoodItem grocery: groceries) {
			long b = grocery.burndownRate();
			String s = Long.toString(b);
			all += "Ideal burndown rate for " + grocery.getName() + " is: " + s + " calories each day<br>";
		}
		System.out.println(all);
		HttpSession session = request.getSession(true); 
		if(session!=null) {
			request.setAttribute("burn", all);
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}	
	}
}
