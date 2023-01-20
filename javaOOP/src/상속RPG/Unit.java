package 상속RPG;

public class Unit {
	int hp;
	int maxHp;
	int power;
	String name;


	public Unit(int hp, int power, String name) {
		super();
		this.hp = hp;
		this.maxHp = hp;
		this.power = power;
		this.name = name;
	}

	void attack(Unit u) {
		u.hp -= power;
		System.out.printf("[%s]가 [%s]에게 [%d] 데미지 공격\n", name, u.name, power);
	}

	boolean isDead() {
		if (hp <= 0) {
			System.out.printf("[%s]가 사망했습니다\n", name);
			return true;
		}
		return false;
	}

	public String UnitInfo() {
		return name + "[" + hp + "/" + maxHp + "]";
	}
	
}
