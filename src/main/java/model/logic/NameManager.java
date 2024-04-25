package model.logic;

import java.util.ArrayList;
import java.util.Random;
// CPUの名前を管理するクラス
public class NameManager {
	private ArrayList<String> nameLists = new ArrayList<>();
	
	public NameManager() {
		// CPUの名前を入れる
		nameLists.add("わさび");
		nameLists.add("わさお");
		nameLists.add("渡辺");
		nameLists.add("ワタリ");
		nameLists.add("ワイルド");
		nameLists.add("わにさん");
		nameLists.add("ワッキー");
		nameLists.add("ワイナイナ");
		nameLists.add("わなわな");
		nameLists.add("ウォルト");
		nameLists.add("ワシントン");
		nameLists.add("わしじゃ");
		nameLists.add("わんこそば");
		nameLists.add("若葉");
		nameLists.add("渡り鳥");
		nameLists.add("わびさび");
		nameLists.add("わさびのり");
		nameLists.add("ワンカルビ");
		nameLists.add("わナンバー");
		nameLists.add("ワリオ");
		nameLists.add("若林");
		nameLists.add("ワイスピ");
		nameLists.add("わいわい");
		nameLists.add("ワールド");
		nameLists.add("ワイン");
		nameLists.add("わさんぼ");
		nameLists.add("ワーゲン");
		nameLists.add("ワイキキ");
		nameLists.add("ワイドショー");
		nameLists.add("ワイナリー");
		nameLists.add("わくわくさん");
		nameLists.add("ゎら");
		nameLists.add("Wi-Fi");
		nameLists.add("ワイマール");
		nameLists.add("ワイド");
		nameLists.add("ワイヤレス");
	}
	
	public String getRandomName() {
		Random r = new Random();
		String name;
		return name = nameLists.get(r.nextInt(nameLists.size()));
	}
}
