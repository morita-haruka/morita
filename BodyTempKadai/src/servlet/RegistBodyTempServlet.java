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

import model.BodyTempDateRegist;
import model.BodyTempRegistrationLogic;
import model.BodyTempTebleDate;
import model.MonthSerchLogic;

/**
 * Servlet implementation class RegistBodyTempServlet
 */
@WebServlet("/RegistBodyTempServlet")
public class RegistBodyTempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistBodyTempServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String temp = request.getParameter("bodytemp");
		String symptom = request.getParameter("symptom");
		String place = request.getParameter("place");
		String memo = request.getParameter("memo");
		double bodyTemp = 0;
		if(temp != "") {
			bodyTemp = Double.parseDouble(temp);
		}
		HttpSession session = request.getSession();
		Object obj =  session.getAttribute("userid");
		String userid = obj.toString();
		BodyTempDateRegist bodyTempDateRegist = new BodyTempDateRegist(bodyTemp,symptom, place, memo,userid);
		BodyTempRegistrationLogic bodyTempRegistrationLogic = new BodyTempRegistrationLogic();
		boolean bool = bodyTempRegistrationLogic.Register(bodyTempDateRegist);
		System.out.println(bool);
		if(!bool) {
			if(bodyTemp == 0) {
				request.setAttribute("tempmessage", "体温が入力されていません");
			}
			if(symptom == "") {
				request.setAttribute("symptommessage", "症状が入力されていません");
			}
			if(place == "") {
				request.setAttribute("placemessage", "出かけた場所が入力されていません");
			}
			if(memo == "") {
				request.setAttribute("memomessage", "メモが入力されていません");
			}
			if(temp != "" && symptom != "" && place != "" && memo != "") {
				request.setAttribute("message", "本日の体温は登録済みなので登録できません");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationBodyTemp.jsp");
			dispatcher.forward(request, response);
		}else{
			MonthSerchLogic monthSerchLogic = new MonthSerchLogic();
			YearMonth yseMonth = YearMonth.now();
			String date  = yseMonth.toString();
			if(userid != null) {
				List<BodyTempTebleDate> resultList = monthSerchLogic.getDate(userid,date);
				request.setAttribute("resultlist", resultList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
				dispatcher.forward(request, response);
			}
		}

	}
}
