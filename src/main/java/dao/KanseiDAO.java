package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.data.Kansei;

// Kanseiテーブルに関する処理をまとめたDAOクラス
public class KanseiDAO implements SettingsDAO {

	// データベースに完成した文を格納(INSERT)する
	// 引数は完成文とクリエイトユーザ
	public void insert(String text, String createUser) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// JDBCドライバの定義
			Class.forName("org.postgresql.Driver");
			// PostgreSQLへの接続
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// INSERT文の準備
			String sql = "INSERT INTO Kansei (id, text, create_user, add_date, good) ";
			sql += "VALUES (?, ?, ?, current_date, 0);";
			st = con.prepareStatement(sql);
			st.setInt(1, count() + 1);
			st.setString(2, text);
			st.setString(3, createUser);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
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

	// Kanseiテーブルのデータ数(末尾のID)をint型で返す
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
			String sql = "SELECT COUNT(id) FROM Kansei;";
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

	// いいねが多い投稿を降順に１５件取得する
	public ArrayList<Kansei> goodSelect() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		// 戻り値格納用の変数
		ArrayList<Kansei> goodLists = null;

		try {
			// JDBCドライバの定義
			Class.forName("org.postgresql.Driver");
			/* PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// SELECT文の準備
			String sql = "SELECT * FROM Kansei ";
			sql += "ORDER BY good DESC ";
			sql += "LIMIT 15 ;";
			st = con.prepareStatement(sql);
			// SQL文の実行
			rs = st.executeQuery();
			goodLists = makeResultData(rs);

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
		return goodLists;
	}

	// 最新の投稿を降順に１５件取得する
	public ArrayList<Kansei> latestSelect() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		// 戻り値格納用の変数
		ArrayList<Kansei> latestLists = null;

		try {
			// JDBCドライバの定義
			Class.forName("org.postgresql.Driver");
			/* PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// SELECT文の準備
			String sql = "SELECT * FROM Kansei ";
			sql += "ORDER BY id DESC ";
			sql += "LIMIT 15 ;";
			st = con.prepareStatement(sql);
			// SQL文の実行
			rs = st.executeQuery();
			latestLists = makeResultData(rs);

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
		return latestLists;
	}

	// 指定された投稿IDのいいねの数を＋１する
	public void addGood(int id) {
		Connection con = null;
		PreparedStatement st = null;
		int currGood = getGood(id);
		try {
			// JDBCドライバの定義
			Class.forName("org.postgresql.Driver");
			/* PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// INSERT文の準備
			String sql = "UPDATE kansei SET good = ? WHERE id = ? ;";
			st = con.prepareStatement(sql);
			st.setInt(1, currGood + 1);
			st.setInt(2, id);
			int good = st.executeUpdate();
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
	}

	// goodを取り出す
	public int getGood(int id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Integer good = null;
		try {
			// JDBCドライバの定義
			Class.forName("org.postgresql.Driver");
			/* PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// SQL文の準備
			String sql = "SELECT good FROM Kansei WHERE id = ? ;";
			st = con.prepareStatement(sql);
			st.setInt(1, id);

			// SQL文の実行(SELECT文)
			rs = st.executeQuery();
			// 取り出したデータを変数に格納する
			while (rs.next()) {
				good = rs.getInt("good");
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
		return good;
	}

	// 日付ごとにランダムに15件の投稿を取得する
	public ArrayList<Kansei> dateSelect(String date) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		// 戻り値格納用の変数
		ArrayList<Kansei> dateLists = null;

		try {
			// JDBCドライバの定義
			Class.forName("org.postgresql.Driver");
			/* PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			// SELECT文の準備
			String sql = "SELECT * FROM Kansei ";
			sql += "WHERE add_date = ?::date ";
			sql += "ORDER BY random() LIMIT 15;";
			st = con.prepareStatement(sql);
			st.setString(1, date);
			// SQL文の実行
			rs = st.executeQuery();
			dateLists = makeResultData(rs);

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
		return dateLists;
	}

	public ArrayList<Kansei> makeResultData(ResultSet rs) throws Exception {
		ArrayList<Kansei> kanseis = new ArrayList<Kansei>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String text = rs.getString("text");
			String createUser = rs.getString("create_user");
			String addDate = rs.getString("add_date");
			int good = rs.getInt("good");

			// 1行分のデータを格納するインスタンス
			Kansei kansei = new Kansei(id, text, createUser, addDate, good);
			// リストに1行分のデータを追加する
			kanseis.add(kansei);
		}
		return kanseis;
	}
}
