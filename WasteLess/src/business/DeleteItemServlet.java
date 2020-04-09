package business;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodItemDao;
import persistent.FoodItem;

/**
 * Servlet implementation class DeleteItemServlet
 */
@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
        FoodItem foodItem = new FoodItem();
        FoodItemDao dao = new FoodItemDao();
        List<FoodItem> groceries= dao.getAlldata();
        for(FoodItem item: groceries) {
        	if(item.getId() == id)
        		foodItem = item;
        }
        dao.deleteFoodItem(foodItem);
        request.setAttribute("update", "Item deleted successfully!");
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

}
