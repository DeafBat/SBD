package perst;

public class Monster extends Character {
	
	public int xpWorth;
	
	public Monster() {
		super();
		this.xpWorth = 0;
	}
	
	public Monster(String name, int strength, int defense, int xpWorth) {
		super(name, strength, defense);
		this.xpWorth = xpWorth;
	}
	
	@Override
	public String toString() {
		return super.toString() + " EW(" + this.xpWorth + ")";
	}
}
