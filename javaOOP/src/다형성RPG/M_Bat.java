package 다형성RPG;

public class M_Bat extends Monster{

	public M_Bat() {
		super(30, 7, "박쥐");
	}

	@Override
	void skill(Unit u) {
		u.hp -= power;
		u.power--;
		cnt++;
	}

}
