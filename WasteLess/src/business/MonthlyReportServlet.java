package business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MonthlyReport;

/**
 * Servlet implementation class MonthlyReportServlet
 */
@WebServlet("/MonthlyReportServlet")
public class MonthlyReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonthlyReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MonthlyReport report = new MonthlyReport();
		String all = report.generateReport();
		System.out.println(all);
		HttpSession session = request.getSession(true); 
		if(session!=null) {
			request.setAttribute("report", all);
			request.getRequestDispatcher("/MonthlyReport.jsp").forward(request, response);
		}
	}
}
