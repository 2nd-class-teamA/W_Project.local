package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaregaDAO;
import dao.DokodeDAO;
import dao.ItsuDAO;
import dao.KanseiDAO;
import dao.NaniwoDAO;
import model.logic.GameManager;
import model.logic.NameManager;
import model.module.Player;
import model.module.Room;

// ⑤お題アニメーション画面のServlet
@WebServlet("/mainOutput")
public class MainOutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードを設定
		request.setCharacterEncoding("UTF-8");

		// ★必要なクラスをインスタンス化★
		// セッションからRoomクラスを取得
		HttpSession session = request.getSession();
		Room room = (Room) session.getAttribute("room");
		// GameManagerクラスのインスタンスを生成
		GameManager gm = new GameManager();
		NameManager nm = new NameManager();

		//
		for (int i = 0; i < 4; i++) {
			// プレイヤーとCPUで処理を分岐させる
			if (gm.PlayerCheck(room.getRoom(), i)) {
				// データベースへの保存する
				switch (i) {
				case 0: // いつ
					ItsuDAO itudao = new ItsuDAO();
					itudao.insert(room.getRoom().get(i).getText(), ((Player) room.getRoom().get(i)).getName());
					break;
				case 1: // どこで
					DokodeDAO dokodao = new DokodeDAO();
					dokodao.insert(room.getRoom().get(i).getText(), ((Player) room.getRoom().get(i)).getName());
					break;
				case 2: // だれが
					DaregaDAO daredao = new DaregaDAO();
					daredao.insert(room.getRoom().get(i).getText(), ((Player) room.getRoom().get(i)).getName());
					break;
				case 3: // なにをした
					NaniwoDAO nanidao = new NaniwoDAO();
					nanidao.insert(room.getRoom().get(i).getText(), ((Player) room.getRoom().get(i)).getName());
					break;
				}
			} else {
				// CPUの場合の処理
				switch (i) {
				case 0:
					// いつテーブルからデータベースの値をランダムに取得する
					int ituBox = gm.randomId(i);
					ItsuDAO itudao = new ItsuDAO();
					String itText = itudao.select(ituBox);

					// CPUが持っているTEXTフィールドへ値を格納する
					room.getRoom().get(i).setText(itText);
					room.setText(i, itText);
					room.setCreaterNames(nm.getRandomName());
					room.CountNamesIncrement();
					break;
				case 1:
					// どこでテーブルからデータベースの値をランダムに取得する
					int dokoBox = gm.randomId(i);
					DokodeDAO dokodao = new DokodeDAO();
					String dokoText = dokodao.select(dokoBox);

					// CPUが持っているTEXTフィールドへ値を格納する
					room.getRoom().get(i).setText(dokoText);
					room.setText(i, dokoText);
					room.setCreaterNames(nm.getRandomName());
					room.CountNamesIncrement();
					break;
				case 2:
					// だれがテーブルからデータベースの値をランダムに取得する
					int daregaBox = gm.randomId(i);
					DaregaDAO daregadao = new DaregaDAO();
					String daregaText = daregadao.select(daregaBox);

					// CPUが持っているTEXTフィールドへ値を格納する
					room.getRoom().get(i).setText(daregaText);
					room.setText(i, daregaText);
					room.setCreaterNames(nm.getRandomName());
					room.CountNamesIncrement();
					break;
				case 3:
					// なにをテーブルからデータベースの値をランダムに取得する
					int nanioBox = gm.randomId(i);
					NaniwoDAO naniodao = new NaniwoDAO();
					String nanioText = naniodao.select(nanioBox);

					// CPUが持っているTEXTフィールドへ値を格納する
					room.getRoom().get(i).setText(nanioText);
					room.setText(i, nanioText);
					room.setCreaterNames(nm.getRandomName());
					room.CountNamesIncrement();
					break;
				}
			}
		}
		// Roomクラスへすべてのお題の結果を保存する
		room.createKanseiText();
		// データベースへ保存する
		KanseiDAO kanseidao = new KanseiDAO();
		kanseidao.insert(room.getKanseiText(), room.getTrimmedCreaterNames());

		// 画面遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/resultAnimation.jsp");
		dispatcher.forward(request, response);
	}

}
