package 다형성RPG;

public abstract class Player extends Unit{
	int level = 1;
	int mp;
	int maxMp;
	int gold;
	
	public Player(int hp, int power, String name, int mp) {
		super(hp, power, name);
		this.mp = mp;
		this.maxMp = mp;
	}

	@Override
	public String toString() {
		return "[직업] "+name+"\n공격력 : "+power+"\nHP : "+hp+"/"+maxHp+"\nMP : "+mp+"/"+maxMp+"\nGold : "+gold;
	}
	
}
