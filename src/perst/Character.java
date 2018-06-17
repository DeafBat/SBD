package perst;

import org.garret.perst.Persistent;

public abstract class Character extends Persistent {
	
	public String name;
	public int strength;
	public int defense;
	
	public Character() {
		this.name = "DUMMY_CHARACTER";
		this.strength = 1;
		this.defense = 1;
	}
	
	public Character(String name, int strength, int defense) {
		this.name = name;
		this.strength = strength;
		this.defense = defense;
	}
	
	@Override
	public String toString() {
		return this.name + ": S(" + this.strength + ") D(" + this.defense + ")";
	}

}
