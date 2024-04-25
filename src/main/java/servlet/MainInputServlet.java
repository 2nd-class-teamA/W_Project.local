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

import model.logic.GameManager;
import model.logic.RoomManager;
import model.module.Player;
import model.module.Room;
import model.module.User;

// ③お題入力画面のServlet
@WebServlet("/maininput")
public class MainInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// ②人数選択画面で選ばれた人数を元に処理を行う
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードをセット
		request.setCharacterEncoding("UTF-8");

		// 人数選択画面から遊ぶ人数をString型の文字列として受け取る
		String Pcount = request.getParameter("pcount");

		// GameManagerとRoomManagerをnewする
		RoomManager rm = new RoomManager();

		// プレイヤーの人数に合わせて、PlayerとCPUが格納されたArrayListを生成
		ArrayList<User> roomList = rm.createRoom(Integer.parseInt(Pcount));

		// Roomクラスを生成しデータを格納
		Room room = new Room();
		room.setRoom(roomList);
		room.setPcount(Integer.parseInt(Pcount));

		// セッションでRoomクラスを保存
		HttpSession session = request.getSession();
		session.setAttribute("room", room);
		doPost(request, response);
	}
	
	// プレイヤーの人数分お題の出力を行う
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードを設定
		request.setCharacterEncoding("UTF-8");

		// ★必要なクラスをインスタンス化★
		// セッションからRoomクラスを取得
		HttpSession session = request.getSession();
		Room room = (Room) session.getAttribute("room");
		// GameManagerクラスのインスタンスを生成
		GameManager gm = new GameManager();

		// お題の格納処理が4回以下（データがそろっていなければ）
		// JSPからのお題の回答を取得 または データベースからランダムに取得を行う
		if (room.getCount() <= 4) {

			// Roomクラスが持っているお題の格納状況を管理するフィールド変数:Countを元に
			// プレイヤーまたはCPUのindex情報を取得（ArrayListの何番目に格納されているか）
			// 0: 「いつ」
			// 1: 「どこで」
			// 2: 「だれが」
			// 3: 「何をした」
			int index = gm.IndexSearch(room.getRoom(), room.getCount());

			// ★プレイヤーとCPUで処理を分岐させる★
			// #プレイヤー:お題入力画面へフォワードし、回答をPlayerクラスのTextフィールドへ格納+データベースへ登録
			// #CPU: ランダムにデータベースからお題の回答を取得しCPUクラスのTextフィールドへ格納
			if (gm.PlayerCheck(room.getRoom(), index)) {
				// プレイヤーの場合の処理
				String id = request.getParameter("id"); // リクエストパラメータに格納されているIDを取得 ※初回時はnull
				String count = String.valueOf(room.getCount()); // お題の格納処理の回数をString型へ変換 ※IDと比較するため

				// ★リクエストパラメータに格納されているお題の回答情報が現在のプレイヤーと一致しているか？
				if (count.equals(id)) {
					// 一致している場合
					// リクエストパラメータから値を取得
					String text = request.getParameter("text"); // お題入力フォームに入力された回答を取得
					String name = request.getParameter("name");// お題入力フォームに入力された名前を取得 ※未入力の場合""（空文字）が入る

					// Playerクラスへお題の回答と名前を格納する
					room.getRoom().get(index).setText(text);
					// Roomクラスの配列にテキストを格納
					room.setText(index, text);
					// nameが空文字でなければ値を格納する
					if (!"".equals(name)) {
						((Player) room.getRoom().get(index)).setName(name);
						room.setCreaterNames(name);
						room.CountNamesIncrement();

						// nameが空文字ならば名無しを追加する処理
					} else {
						((Player) room.getRoom().get(index)).setName("名無し");
						room.setCreaterNames("名無し");
						room.CountNamesIncrement();
					}
					// お題の回答状況を管理するCountをインクリメントする
					room.setCount(room.getCount() + 1);
					// roomの情報をセッションへ格納
					session.setAttribute("room", room);
					// 次の処理へ
					doPost(request, response);
				} else {
					// 一致していない場合
					// お題入力画面へフォワード
					switch (index) {
					case 0:
						request.setAttribute("id", room.getRoom().get(index).getId());
						RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/jsp/maininput/itsu.jsp");
						rd1.forward(request, response);
						break;
					case 1:
						request.setAttribute("id", room.getRoom().get(index).getId());
						RequestDispatcher rd2 = request.getRequestDispatcher("/WEB-INF/jsp/maininput/dokode.jsp");
						rd2.forward(request, response);
						break;
					case 2:
						request.setAttribute("id", room.getRoom().get(index).getId());
						RequestDispatcher rd3 = request.getRequestDispatcher("/WEB-INF/jsp/maininput/darega.jsp");
						rd3.forward(request, response);
						break;
					case 3:
						request.setAttribute("id", room.getRoom().get(index).getId());
						RequestDispatcher rd4 = request.getRequestDispatcher("/WEB-INF/jsp/maininput/naniwo.jsp");
						rd4.forward(request, response);
						break;
					}
				}
			} else {
				// お題の回答状況を管理するCountをインクリメントする
				room.setCount(room.getCount() + 1);
				// roomの情報をセッションへ格納
				session.setAttribute("room", room);
				// 次の処理へ
				doPost(request, response);
			}
		} else {
			// 結果出力処理
			RequestDispatcher resultRD = request.getRequestDispatcher("/WEB-INF/jsp/resultWait.jsp");
			resultRD.forward(request, response);
		}
	}
}