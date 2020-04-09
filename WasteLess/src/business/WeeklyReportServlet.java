package business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.WeeklyReport;

/**
 * Servlet implementation class WeeklyReportServlet
 */
@WebServlet("/WeeklyReportServlet")
public class WeeklyReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeeklyReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WeeklyReport report = new WeeklyReport();
		String all = report.generateReport();
	
		HttpSession session = request.getSession(true); 
		if(session!=null) {
			request.setAttribute("reportw", all);
			request.getRequestDispatcher("/WeeklyReport.jsp").forward(request, response);
		}
	}
	
}
