package 상속RPG;

import java.util.Random;
import java.util.Scanner;

public class Game {

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	final int BOSS = 9;
	final int MONSTER = 8;
	final int SIZE = 10;

	int map[];
	Player player;

	void init() {
		map = new int[SIZE];
		player = new Player(100, 10, "전사");
		map[3] = MONSTER;
		map[5] = MONSTER;
		map[7] = MONSTER;
		map[SIZE - 1] = BOSS;
	}

	void printGameMap() {
		for (int i = 0; i < map.length; i++) {
			if (i == player.position) {
				System.out.print("[옷]");
			} else if (map[i] == 0) {
				System.out.print("[ ]");
			} else if (map[i] == MONSTER) {
				System.out.print("[M]");
			} else {
				System.out.print("[B]");
			}
		}
		System.out.println();
	}

	void movePlayer() {
		player.movePlayer(SIZE);
	}

	void mainMenu() {
		System.out.println("[0]종료[1]한칸이동[2]체력회복");
	}

	void battleMonster(Monster m) {
		System.out.println("=========[ 전투 ]==========");
		System.out.printf("[%s] 가 나타났다!\n", m.name);
		int selTurn = rd.nextInt(2);
		boolean turn = selTurn == 0 ? true : false;
		while (!m.isDead() == !player.isDead()) {
			if (turn) {
				System.out.println("[플레이어 차례]");
				System.out.println("[1]공격 [2]스킬");
				int input = sc.nextInt();
				if (input == 1) {
					player.attack(m);
				} else if (input == 2) {
					player.skill(m);
				} else {
					System.err.println("입력오류");
				}
				turn = false;
			} else {
				System.out.println("[몬스터 차례]");
				int att = rd.nextInt(2);
				if (att == 1)
					m.attack(player);
				else
					m.skill(player);
				turn = true;
			}
			System.out.println(player.UnitInfo());
			System.out.println(m.UnitInfo());
		}
		if (m.idx == 1)
			player.power += m.cnt;
		map[player.position] = 0;
	}

	Monster createMonster() {
		return Monster.getMonster().init(rd.nextInt(3));
	}

	Monster createBoss() {
		return Monster.getMonster().init(3);
	}

	void run() {
		init();
		while (true) {
			printGameMap();
			System.out.println(player);
			mainMenu();
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("==종료==");
				break;
			} else if (input == 1) {
				player.movePlayer(SIZE);
			} else if (input == 2) {
				player.usePotion();
			}
			if (map[player.position] == 8) {
				Monster m = createMonster();
				battleMonster(m);
				if (player.hp <= 0)
					break;
			} else if (map[player.position] == 9) {
				Monster m = createBoss();
				battleMonster(m);
				if (player.hp <= 0)
					break;
				System.out.println("보스 클리어!");
				break;
			}
		}
	}

}
