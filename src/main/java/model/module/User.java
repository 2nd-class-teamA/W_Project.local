package model.module;

// PlayerとCPUに共通する処理をまとめたクラス
public class User {
	private int id;
	
	//コンストラクタ id格納
	public User(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}


	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
