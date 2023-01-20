package 다형성RPG;

public class M_Zombie extends Monster{

	public M_Zombie() {
		super(50, 3, "좀비");
		
	}

	@Override
	void skill(Unit u) {
		u.hp -= power;
		power += 2;
	}

}
