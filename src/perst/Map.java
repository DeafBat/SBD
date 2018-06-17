package perst;

import org.garret.perst.Persistent;

public class Map extends Persistent {

	public int id;
	public Character[] characters;
	public int numOfCharacters;
	
	public Map() {
		this.id = 0;
		this.characters = null;
		this.numOfCharacters = 0;
	}
	
	public Map(int id) {
		this.id = id;
		this.characters = new Character[5];
		this.numOfCharacters = 0;
	}
	
	public void addCharacter(Character character) {
		if (this.numOfCharacters < 5) {
			this.characters[this.numOfCharacters++] = character;
		}
	}
	
	@Override
	public String toString() {
		String s = this.id + ": \n";
		for (int i = 0; i < this.numOfCharacters; i++) {
			s += "  " + this.characters[i].toString() + "\n";
		}
		return s;
	}
	
	//The first Character (assumed player) fights with the other characters in map.
	//Fight  = compare strength and defense. s>=d - win. s < d - lose.
	//If Player wins against Monster they get its experience worth added.
	//Winning against other Players doesn't change anything.
	public void firstFightWithRest() {
		Player p = (Player) this.characters[0];
		System.out.println(p.name + "'s lvl before fights: " + p.calculateLevel());
		for (int i = 1; i < this.numOfCharacters; i++) {
			Character c = this.characters[i];
			if (c.getClass() == Monster.class) {
				if (p.strength >= c.defense) {
					p.xp += ((Monster) c).xpWorth;
				}
			}
		}
		System.out.println(p.name + "'s lvl after fights: " + p.calculateLevel());
	}
}
