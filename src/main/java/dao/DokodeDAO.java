package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Dokodeテーブルに関する処理をまとめたDAOクラス
public class DokodeDAO implements SettingsDAO {

	// データベースから文を取り出す
	public String select(int id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String text = null;
		try {
			// JDBCドライバの定義
			Class.forName("org.postgresql.Driver");
			/* PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// SQL文の準備
			String sql = "SELECT text FROM dokode WHERE id = ? ;";
			st = con.prepareStatement(sql);
			st.setInt(1, id);

			// SQL文の実行(SELECT文)
			rs = st.executeQuery();
			// 取り出したデータを変数に格納する
			while (rs.next()) {
				text = rs.getString("text");
			}
		} catch (Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// PostgreSQLとの接続を切断する
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					;
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					;
				}
			}
		}
		return text;
	}
	
	// 入力されたデータをデータベースに追加する
		public void insert(String text, String userName) {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;

			try {
				// JDBCドライバの定義
				Class.forName("org.postgresql.Driver");
				/* PostgreSQLへの接続 */
				con = DriverManager.getConnection(URL, USER, PASSWORD);
				// INSERT文の準備
				String sql = "INSERT INTO dokode (id, text, user_name, add_date) ";
				sql += "VALUES (?, ?, ?, current_date);";
				st = con.prepareStatement(sql);
				st.setInt(1, count() + 1);
				st.setString(2, text);
				st.setString(3, userName);
				st.executeUpdate();
			} catch (Exception e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			} finally {
				// PostgreSQLとの接続を切断する
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						;
					}
				}
				if (st != null) {
					try {
						st.close();
					} catch (SQLException e) {
						;
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						;
					}
				}
			}
		}
		
		public int count() {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			int allId = 0;

			try {
				// JDBCドライバの定義
				Class.forName("org.postgresql.Driver");
				/* PostgreSQLへの接続 */
				con = DriverManager.getConnection(URL, USER, PASSWORD);

				// SQL文の準備
				String sql = "SELECT COUNT(id) FROM dokode;";
				st = con.prepareStatement(sql);
				// SQL文の実行(SELECT文)
				rs = st.executeQuery();
				while (rs.next()) {
					allId = rs.getInt(1);
				}
			} catch (Exception e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			} finally {
				// PostgreSQLとの接続を切断する
				if (st != null) {
					try {
						st.close();
					} catch (SQLException e) {
						;
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						;
					}
				}
			}
			return allId;
		}
}
