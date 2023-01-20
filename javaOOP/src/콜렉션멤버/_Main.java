package 콜렉션멤버;

import java.util.InputMismatchException;

public class _Main {

	public static void main(String[] args) {
   
	Controller con = Controller.getInstance();
	
	while(true) {
		System.out.println("=====메뉴======");
		System.out.println("1) 추가");
		System.out.println("2) 삭제");
		System.out.println("3) 수정");
		System.out.println("4) 출력");
		System.out.println("0) 종료");
		int sel = -1;
		try {
			sel = Util.scan.nextInt();
			if(sel<0||sel>4) {
				throw new Exception();
			}
		}catch(InputMismatchException e) {
			System.err.println("숫자를 입력 하세요");
			Util.scan.nextLine();
			continue;
		} catch (Exception e) {			
			System.err.println("범위 오류");
			continue;
		}
		if (sel == 1) {
			con.getAction("insert").excute();
		} else if (sel == 2) {
			con.getAction("delete").excute();
		} else if (sel == 3) {
			con.getAction("update").excute();
		} else if (sel == 4) {
			con.getAction("print").excute();
		} else if (sel == 0) {
			System.out.println("프로그램 종료");
			break;
		}
	}
  }
}
