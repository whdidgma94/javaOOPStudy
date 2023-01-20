package 다형성RPG;

public class M_Boss extends Monster{

	public M_Boss() {
		super(60, 8, "보스");
	}

	@Override
	void skill(Unit u) {		
		u.hp -= power * 2;
	}

}
