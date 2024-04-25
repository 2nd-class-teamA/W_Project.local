package model.logic;

import java.util.ArrayList;
import java.util.Random;

import dao.DaregaDAO;
import dao.DokodeDAO;
import dao.ItsuDAO;
import dao.NaniwoDAO;
import model.module.Player;
import model.module.User;
// ゲームに関する処理をまとめたクラス
public class GameManager {

	// 1人目(1回目)はどのインデックスに入っているかを確認
	public int IndexSearch(ArrayList<User> room, int count) {

		switch (count) {
		case 1:
			for (int i = 0; i < room.size(); i++) {
				if (room.get(i).getId() == 1) {
					return i;
				}
			}
			break;
		case 2:
			for (int i = 0; i < room.size(); i++) {
				if (room.get(i).getId() == 2) {
					return i;
				}
			}
			break;
		case 3:
			for (int i = 0; i < room.size(); i++) {
				if (room.get(i).getId() == 3) {
					return i;
				}
			}
			break;
		case 4:
			for (int i = 0; i < room.size(); i++) {
				if (room.get(i).getId() == 4) {
					return i;
				}
			}
			break;
		}
		return -1;
	}

	// 格納されたインスタンスがPlayerかCPUかをチェック
	public boolean PlayerCheck(ArrayList<User> room, int index) {

		if (room.get(index) instanceof Player) {
			return true;
		}
		return false;
	}

	// ↓戻り値はint型(ＣＰＵがどの値をとってくるのか、ＤＢのidがほしい)
	public int randomId(int index) {
		int id = 0;

		switch (index) {
		// ランダム処理のメソッド①(1～ituテーブルの要素数分ランダム)
		case 0:
			ItsuDAO idao = new ItsuDAO();
			id = new Random().nextInt(idao.count()) + 1;
			break;
		// ランダム処理のメソッド②(1～dokodeテーブルの要素数分ランダム)
		case 1:
			DokodeDAO dokodao = new DokodeDAO();
			id = new Random().nextInt(dokodao.count()) + 1;
			break;
		// ランダム処理のメソッド③(1～daregaテーブルの要素数分ランダム)
		case 2:
			DaregaDAO daredao = new DaregaDAO();
			id = new Random().nextInt(daredao.count()) + 1;
			break;
		// ランダム処理のメソッド④(1～naniwoテーブルの要素数分ランダム)
		case 3:
			NaniwoDAO ndao = new NaniwoDAO();
			id = new Random().nextInt(ndao.count()) + 1;
			break;
		}
		return id;
	}

}
