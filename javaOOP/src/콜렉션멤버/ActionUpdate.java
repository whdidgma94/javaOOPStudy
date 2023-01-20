package 콜렉션멤버;

public class ActionUpdate implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getIntance();

		System.out.println("수정할 아이디 입력:");
		String id = Util.scan.next();

		Member member = dao.getMember(id);
		if (member == null) {
			System.err.println("아이디가 존재하지 않습니다.");
			return;
		}
		System.out.println("수정할 비밀번호 입력:");
		String pw = Util.scan.next();
		member.setPw(pw);
		System.out.println("비밀번호 수정 완료");
	}

}
