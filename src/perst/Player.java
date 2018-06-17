package perst;

public class Player extends Character {
	public int xp;
	
	public Player() {
		super();
		this.xp = 0;
	}
	
	public Player(String name, int strength, int defense, int xp) {
		super(name, strength, defense);
		this.xp = xp;
	}
	
	int calculateLevel() {
		return xp / 10;
	}
	
	public String toString() {
		return super.toString() + " Exp(" + this.xp + ")";
	}
}
