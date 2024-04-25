package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KanseiDAO;

//⑦みんなのW（最新のW）のServlet
@WebServlet("/greatWnew")
public class GreatWnewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードをセット
		request.setCharacterEncoding("UTF-8");
		
		//みんなのWの日付データを初期化
		HttpSession session = request.getSession();
		session.removeAttribute("currDate");
		
		//KanseiDAOからListを受け取る
		KanseiDAO kanseiDAO = new KanseiDAO();
		//latestSelect()を呼ぶ
		//リクエストスコープに入れる
		request.setAttribute("latest", kanseiDAO.latestSelect());
		//JSPへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/greatWnew.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードを設定
		request.setCharacterEncoding("UTF-8");
		
		// JSPからID情報を取得
		String id = request.getParameter("wid");
		//addGood()を呼んでいいねを+1する
		KanseiDAO kanseiDAO = new KanseiDAO();
		kanseiDAO.addGood(Integer.parseInt(id));
		//doGet()を呼ぶ
		doGet(request,response);
	}

}
