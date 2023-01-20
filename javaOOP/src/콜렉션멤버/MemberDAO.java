package 콜렉션멤버;

import java.util.ArrayList;

public class MemberDAO {
	private MemberDAO(){
		init();
	}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getIntance() {
		return instance;
	}
	private ArrayList<Member> memberlist;
	
	public ArrayList<Member> getMemberlist() {
		return memberlist;
	}


	private void init() {
		memberlist = new ArrayList<>();
	}
	
	void insert(Member member) {
		memberlist.add(member);
	}
	
	boolean checkId(String id) {
		for(Member m : memberlist) {
			if(m.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	Member getMember(String id) {
		for(Member member : memberlist) {
			if(id.equals(member.getId())) {
				return member;
			}
		}
		return null;
	}
	
	void remove(Member member) {
		memberlist.remove(member);
	}
	
	
	
}
