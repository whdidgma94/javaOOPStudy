package 다형성RPG;

public abstract class Monster extends Unit {
	int cnt;
	public Monster(int hp, int power, String name) {
		super(hp, power, name);
	}

}
