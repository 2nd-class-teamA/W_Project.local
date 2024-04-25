package model.data;

import java.io.Serializable;
// Dokodeテーブルのレコードを表すjavaBeansクラス
public class Dokode implements Serializable {
	private int id;
	private String text;
	private String userName;
	private String addDate;

	// コンストラクタ①
	public Dokode(int id, String text, String userName, String addDate) {
		this.id = id;
		this.text = text;
		this.userName = userName;
		this.addDate = addDate;
	}

	// コンストラクタ②
	public Dokode(int id, String text, String addDate) {
		this.id = id;
		this.text = text;
		this.addDate = addDate;
	}

	// コンストラクタ③(空)
	public Dokode() {
			
		}

	public int getId() {
		return id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
}
