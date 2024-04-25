package model.data;

import java.io.Serializable;
//Daregaテーブルのレコードを表すjavaBeansクラス
public class Darega implements Serializable {
	private int id;
	private String text;
	private String userName;
	private String addDate;
	
	//コンストラクタ
	public Darega() {
		//空のコンストラクタ
	}
	
	public Darega(int id, String text, String userName, String addDate) {
		this.id = id;
		this.text = text;
		this.userName = userName;
		this.addDate = addDate;
	}
	
	public Darega(int id, String text, String addDate) {
		this.id = id;
		this.text = text;
		this.addDate = addDate;
	}
	
	//getter
	public int getId() {
		return id;
	}
	public String getText() {
		return text;
	}
	public String getUserName() {
		return userName;
	}
	public String getAddDate() {
		return addDate;
	}
	//setter
	public void setId(int id) {
		this.id = id;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	
}
