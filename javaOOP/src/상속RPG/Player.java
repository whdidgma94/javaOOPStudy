package 상속RPG;

public class Player extends Unit{
	int level=1;
	int item;
	int position;
	
	public Player(int hp, int power, String name) {
		super(hp, power, name);
	}

	@Override
	public String toString() {
		System.out.println(UnitInfo());
		return "[레벨:" +level+"]" + "[위치:"+ position +"]";
	}

	void movePlayer(int max) {
		if(position < max-1) {
			position++;
		}
	}

	void skill(Unit u) {
		u.hp-=power;
		u.hp-= (power/10*3);
		System.out.printf("[깊게 찌르기] 공격력의 30%%증가 데미지 [%s] \n", u.name);
	}
	
	void usePotion() {
		if (hp != maxHp) {
			hp = maxHp;
			System.out.println("체력 회복 완료");
		}else {
			System.out.println("체력이 최고치 입니다");
		}
	}
	void levelUp() {
		level++;
		power+=5;
		hp+=10;
		maxHp+=10;
		item+=1;
		System.out.printf("[레벨업! %d]\n" , level);
	}
	
}
