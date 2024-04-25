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

// ⑦みんなのW（日付検索W）のServlet
@WebServlet("/calender")
public class GreatWcalenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードをセット
		request.setCharacterEncoding("UTF-8");
		// セッションを生成
		HttpSession session = request.getSession();
		// フォワード先を設定
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/jsp/greatWcalender.jsp");
		// DAOのインスタンスを生成
		KanseiDAO kanseiDAO = new KanseiDAO();

		// ここでJSPから日付情報を受け取る
		String date = request.getParameter("date");
		
		// ここでdateがnullかチェックする(trueかfalseでリクエストスコープに入れる内容を変える。if文)
		if (date == null) {
			// セッションから日付情報を取得
			String currDate = (String) session.getAttribute("currDate");
			if (currDate != null) {
				// セッションに日付情報が登録されていたら
				ArrayList<Kansei> calendarLists = kanseiDAO.dateSelect(currDate);
				request.setAttribute("date", calendarLists);
				dispatcher.forward(request, response);
			} else {
				// セッションに日付情報が登録されていなかったら（初回アクセス時）
				request.setAttribute("date", null);
				dispatcher.forward(request, response);
			}
		} else {
			// JSPから日付情報を受け取っていたら
			session.setAttribute("currDate", date);
			ArrayList<Kansei> calendarLists = kanseiDAO.dateSelect(date);
			request.setAttribute("date", calendarLists);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードを設定
		request.setCharacterEncoding("UTF-8");

		// JSPからID情報を取得
		String id = request.getParameter("wid");
		// リクエストパラメータから日付情報をもらう
		// addGood()を呼んでいいねを+1する
		KanseiDAO kanseiDAO = new KanseiDAO();
		kanseiDAO.addGood(Integer.parseInt(id));
		// doGet()を呼ぶ
		doGet(request, response);
	}

}
