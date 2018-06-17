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
}
