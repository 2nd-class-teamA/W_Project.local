package model.module;

import java.io.Serializable;
// playerを表すjavaBeansクラス
public class Player extends User implements Serializable {
	private String name = "名無しさん";
	
	public Player(int id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
