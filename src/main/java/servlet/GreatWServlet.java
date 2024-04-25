package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KanseiDAO;
import model.data.Kansei;

//⑦みんなのW（人気のW）のServlet
@WebServlet("/greatW")
public class GreatWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードをセット
		request.setCharacterEncoding("UTF-8");
		
		//みんなのWの日付データを初期化
		HttpSession session = request.getSession();
		session.removeAttribute("currDate");
		
		KanseiDAO kanseiDAO = new KanseiDAO();
		ArrayList<Kansei> goodLists = kanseiDAO.goodSelect();
		// リクエストスコープにインスタンスを保存
		request.setAttribute("iine", goodLists);
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/greatWiine.jsp");// URL:OK⁇
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
