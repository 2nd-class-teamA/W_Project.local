package model.data;

import java.io.Serializable;
// Naniwoテーブルのレコードを表すjavaBeansクラス
public class Naniwo implements Serializable {
	private int id;
	private String text;
	private String userName;
	private String addDate;
	//コンストラクタ
		public Naniwo() {
			//空のコンストラクタ
		}
		
		public Naniwo(int id, String text, String userName, String addDate) {
			this.id = id;
			this.text = text;
			this.userName = userName;
			this.addDate = addDate;
		}
		
		public Naniwo(int id, String text, String addDate) {
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
