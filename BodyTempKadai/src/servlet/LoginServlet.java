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
import model.Login;
import model.MonthSerchLogic;
import model.UserLoginLogic;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		Login login = new Login(mail, pass);
		UserLoginLogic userloginLogic = new UserLoginLogic();
		MonthSerchLogic monthSerchLogic = new MonthSerchLogic();
		YearMonth yseMonth = YearMonth.now();
		String date  = yseMonth.toString();
		String userid = userloginLogic.execute(login);
		if(userid != null) {
			List<BodyTempTebleDate> resultList = monthSerchLogic.getDate(userid,date);
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			request.setAttribute("resultlist", resultList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("message", "メールアドレスまたはパスワードが違います");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
