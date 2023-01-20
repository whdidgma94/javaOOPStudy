package 다형성RPG;

public class M_Wolf extends Monster{

	public M_Wolf() {
		super(40, 6, "늑대");
	}

	@Override
	void skill(Unit u) {
		u.hp -= power;
		u.hp -= power / 2;	
	}

}
