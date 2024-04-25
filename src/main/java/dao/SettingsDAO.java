package dao;

// データベースの接続設定をまとめたクラス
// 各種DAOで継承して利用する
public interface SettingsDAO {
	public static final String URL = "jdbc:postgresql://localhost:5432/wdb";
	public static final String USER = "postgres";
	public static final String PASSWORD = "root";
}
