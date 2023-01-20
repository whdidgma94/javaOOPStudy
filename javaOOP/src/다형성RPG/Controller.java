package 다형성RPG;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Controller {
	
	Random rd = new Random();
	Scanner scan = new Scanner(System.in);
	Stage stage = new Stage();
	int getInt(int start, int end) {
		int input = 0;

		System.out.print("입력 : ");
		try {
			input = scan.nextInt();
			if (input < start || input > end)
				throw new Exception(start + " ~ " + end + " 의 숫자를 입력 해 주세요.");
		} catch (InputMismatchException e) {
			System.err.println("숫자를 입력 해 주세요.");
			scan.nextLine();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			input = 0;
		}

		return input;
	}

	void printChoice() {
		System.out.println("직업을 선택 하세요.");
		System.out.println("[1]전사 [2]궁수 [3]도적 [4]마법사");
	}

	Unit givePlayerClass(int sel) {
		if (sel == 1)
			return new P_Worrior();
		else if (sel == 2)
			return new P_Archer();
		else if (sel == 3)
			return new P_Rogue();
		else
			return new P_Magician();
	}
	
	void getStage(int num,Unit player) {
		if (num == 0) {
			stage.cave();
		} else if (num == 1) {
			stage.road();
		} else if (num == 2) {
			stage.villige();
		} else if (num == 3) {
			stage.forest();
		} 
		
	}
	
	
	void run() {

		printChoice();
		int sel = 0;
		while (sel == 0) {
			sel = getInt(1, 4);
		}
		Unit player = givePlayerClass(sel);
		System.out.println(player);
		while (!player.isDead()) {
			getStage(rd.nextInt(7),player);
		}

	}
}
