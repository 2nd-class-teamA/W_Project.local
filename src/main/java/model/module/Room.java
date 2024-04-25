package model.module;

import java.io.Serializable;
import java.util.ArrayList;

// Roomクラス：PlayerとCPUを格納するjavaBeansクラス
public class Room implements Serializable{
	// シャッフル済みのArrayListを格納
	private ArrayList<User> roomList;
	// 何人で遊ぶか
	private int Pcount;
	// 何回目の処理か
	private int count = 1;
	//　String型の配列を生成
	private String[] text = new String[4];
	// 完成したテキストを保存する
	private String kanseiText;
	// 作成したプレイヤー名を格納
	private String createrNames = "";
	// 名前を入力してくれた人の数をカウント
	private int countNames = 0;

	public ArrayList<User> getRoom() {
		return roomList;
	}

	public void setRoom(ArrayList<User> room) {
		this.roomList = room;
	}

	public int getPcount() {
		return Pcount;
	}

	public void setPcount(int pcount) {
		Pcount = pcount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void setText(int index, String text) {
		this.text[index] = text;
	}
	
	public String[] getText() {
		return this.text;
	}
	
	public String getText(int index) {
		return this.text[index];
	}

	public String getKanseiText() {
		return kanseiText;
	}
	
	public void setCreaterNames(String name) {
		this.createrNames += name + ", "; 
	}
	
	public String getCreaterNames() {
		return this.createrNames;
	}
	public String getTrimmedCreaterNames() {
		return getCreaterNames().substring(0, (getCreaterNames().length() - 2));
	}
	
	// お題の完成文を生成
	public void createKanseiText() {
		this.kanseiText = this.text[0] + "," + this.text[1] + "で" + this.text[2] + "が" + text[3] + "。";
	}

	public int getCountNames() {
		return countNames;
	}

	public void CountNamesIncrement() {
		this.countNames += 1;
	}
}
