package servlet;

import java.io.IOException;
import java.time.YearMonth;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BodyTempTebleDate;
import model.MonthSerchLogic;

/**
 * Servlet implementation class mainRetrunServlet
 */
@WebServlet("/mainRetrunServlet")
public class mainRetrunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainRetrunServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj =  session.getAttribute("userid");
		String userid = obj.toString();
		MonthSerchLogic monthSerchLogic = new MonthSerchLogic();
		YearMonth yseMonth = YearMonth.now();
		String date  = yseMonth.toString();
		if(userid != null) {
			List<BodyTempTebleDate> resultList = monthSerchLogic.getDate(userid,date);
			session.setAttribute("userid", userid);
			request.setAttribute("resultlist", resultList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}
	}
}
