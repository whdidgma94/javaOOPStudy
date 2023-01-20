package 콜렉션멤버;

public class ActionDelete implements Action {
	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getIntance();

		System.out.println("삭제할 아이디 입력:");
		String id = Util.scan.next();

		Member member = dao.getMember(id);
		if (member == null) {
			System.err.println("아이디가 존재하지 않습니다.");
			return;
		}
		dao.remove(member);
		System.out.println("삭제 완료");
	}
}
