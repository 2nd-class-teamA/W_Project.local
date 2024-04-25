package model.logic;

import java.util.ArrayList;
import java.util.Collections;

import model.module.Cpu;
import model.module.Player;
import model.module.User;
// プレイヤーとCPUを生成するクラス
public class RoomManager {
	
	ArrayList<User> room = new ArrayList<>();
	
	public ArrayList<User> createRoom(int Pcount) {
		
		//switch文(playerとcpuの生成)
		switch (Pcount) {
		case 1:
			Player player1 = new Player(1);
			room.add(player1);
			
			Cpu cpu1_1 = new Cpu(2);
			room.add(cpu1_1);
			
			Cpu cpu1_2= new Cpu(3);
			room.add(cpu1_2);
			
			Cpu cpu1_3 = new Cpu(4);
			room.add(cpu1_3);
			break;
		case 2:
			Player player2_1 = new Player(1);
			room.add(player2_1);
			
			Player player2_2 = new Player(2);
			room.add(player2_2);
			
			Cpu cpu2_1 = new Cpu(3);
			room.add(cpu2_1);
			
			Cpu cpu2_2 = new Cpu(4);
			room.add(cpu2_2);
			break;
		case 3:
			Player player3_1 = new Player(1);
			room.add(player3_1);
			
			Player player3_2 = new Player(2);
			room.add(player3_2);
			
			Player player3_3 = new Player(3);
			room.add(player3_3);
			
			Cpu cpu3_1 = new Cpu(4);
			room.add(cpu3_1);
			break;
		case 4:
			Player player4_1 = new Player(1);
			room.add(player4_1);
			
			Player player4_2 =  new Player(2);
			room.add(player4_2);
			
			Player player4_3 =  new Player(3);
			room.add(player4_3);
			
			Player player4_4 =  new Player(4);
			room.add(player4_4);
			break;
		}
		//PlayerとCPUをシャフルする
		Collections.shuffle(room);
		
		return room;
	}

}
