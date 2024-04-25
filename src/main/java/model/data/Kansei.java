package model.data;

import java.io.Serializable;
// Kanseiテーブルのレコードを表すJavaBeansクラス
public class Kansei implements Serializable{
	private int id;
	private String text;
	private String createUser;
	private String addDate;
	private int good;
	
	//コンストラクタ①(全てを引数に)
	public Kansei(int id, String text, String createUser, String addDate, int good) {
		this.id = id;
		this.text = text;
		this.createUser = createUser;
		this.addDate = addDate;
		this.good = good;
	}
	//コンストラクタ②(ユーザ―名がないVer)
	public Kansei(int id, String text, String addDate, int good) {
		this.id = id;
		this.text = text;
		this.addDate = addDate;
		this.good = good;
	}
	//コンストラクタ③(ユーザー名といいねがないVer)
	public Kansei(int id, String text, String addDate) {
		this.id = id;
		this.text = text;
		this.addDate = addDate;
	}
	//コンストラクタ④(引数なし)
	public Kansei() {
		;
	}
	//以下、getter,setter
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
}
