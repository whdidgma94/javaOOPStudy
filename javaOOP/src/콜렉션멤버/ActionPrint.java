package 콜렉션멤버;

public class ActionPrint implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getIntance();
		for(int i = 0 ; i < dao.getMemberlist().size();i++) {
			System.out.print(i+1+". ");
			System.out.println(dao.getMemberlist().get(i));
		}
		
	}

}
