package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//①トップ画面へフォワードするサーブレット
@WebServlet("/return")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードをセット
		request.setCharacterEncoding("UTF-8");
		
		//みんなのWの日付データを初期化
		HttpSession session = request.getSession();
		session.removeAttribute("currDate");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
	}
}
