package business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import persistent.User;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 User user = new User();
		 user.setUsername(username);
		 user.setPassword(password);
		 System.out.println(username+password);
		 UserDao dao= new UserDao(); 
		 String userValidate = dao.authenticateUser(user);
		 if(userValidate.equals("success")) {
			 HttpSession session = request.getSession(true);
			 session.setAttribute("username", username); 
			 request.setAttribute("username", username); 
			 request.getRequestDispatcher("/Home.jsp").forward(request, response);
		 }
		 else {
			 request.setAttribute("errMessage", userValidate); 
			 request.getRequestDispatcher("/Login.jsp").forward(request, response);
		 }
	}
}
	

