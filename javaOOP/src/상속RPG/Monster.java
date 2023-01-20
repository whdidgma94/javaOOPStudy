package 상속RPG;

public class Monster extends Unit {

	String[] names = { "늑대", "박쥐", "좀비", "보스" };
	String[] attack = { "할퀴기", "음파공격", "물어뜯기", "메테오" };
	int idx;
	int cnt;


	private static Monster monster = new Monster(0, 0, null, 0);

	public static Monster getMonster() {
		return monster;
	}

	private Monster(int hp, int power, String name, int idx) {
		super(hp, power, name);
		this.idx = idx;
	}

	void skill(Unit u) {
		if (idx == 0) {
			u.hp -= power;
			u.hp -= power / 2;
		} else if (idx == 1) {
			u.hp -= power;
			u.power--;
			cnt++;
		} else if (idx == 2) {
			u.hp -= power;
			power += 2;
		} else {
			u.hp -= power * 2;
		}
		System.out.printf("[%s]의 [%s]공격!\n", names[idx], attack[idx]);
	}

	Monster init(int index) {
		this.idx = index;
		if (idx == 0)
			return new Monster(40, 6, names[idx], index);
		else if (idx == 1)
			return new Monster(30, 7, names[idx], index);
		else if (idx == 2)
			return new Monster(50, 3, names[idx], index);
		else
			return new Monster(60, 8, names[idx], index);
	}


}

