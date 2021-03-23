package fly.test;

interface Movable {
	void move(int x, int y);
}

interface Attackable {
	void attack(Unit u);
}

class Unit {
	int currentHP;
	int x;
	int y;
	
}

interface Fightable extends Movable, Attackable{
	void goahead();
	// ¾ê³Ù ÀÌ¹Ì µé¾î°¡ÀÖÀ½
//	move(int x, int y);
//	void attack(Unit u);
}

public class FighterTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
