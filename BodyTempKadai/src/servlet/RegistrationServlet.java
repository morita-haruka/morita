package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserInfomation;
import model.UserRegistrationLogic;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		UserInfomation userInfomation = new UserInfomation(name, mail, pass);
		UserRegistrationLogic userRegistrationLogic = new UserRegistrationLogic();
		boolean bool = userRegistrationLogic.Register(userInfomation);
		if(!bool) {
			if(name == "") {
				request.setAttribute("namemessage", "氏名を入力してください");
			}
			if(mail == "") {
				request.setAttribute("mailmessage", "メールアドレスを入力してください");
			}
			if(pass == "") {
				request.setAttribute("passmessage", "パスワードを入力してください");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationUser.jsp");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
}
