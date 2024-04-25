package model.module;

import java.io.Serializable;
// CPUを表すjavaBeansクラス
public class Cpu extends User implements Serializable {
	private String name;

	public Cpu(int id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
