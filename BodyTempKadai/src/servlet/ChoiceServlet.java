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
import model.RegistrationBody;
import model.Result;
import model.ResultLogic;

/**
 * Servlet implementation class ChoiceServlet
 */
@WebServlet("/ChoiceServlet")
public class ChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tempText = request.getParameter("registration");
		double bodyTemp = Double.parseDouble(tempText);
		RegistrationBody registrationBody = new RegistrationBody();
		boolean regiResult = registrationBody.execute(bodyTemp);
		if(!regiResult) {
			response.sendRedirect("/BodyTempKadai/");
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/choice.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("month");
		HttpSession session = request.getSession();
		Object obj =  session.getAttribute("userid");
		String userid = obj.toString();
		MonthSerchLogic monthSerchLogic = new MonthSerchLogic();
		if(userid != null) {
			List<BodyTempTebleDate> resultList = monthSerchLogic.getDate(userid,date);
			request.setAttribute("resultlist", resultList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}
	}
}
