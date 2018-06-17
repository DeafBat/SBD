package perst;

import org.garret.perst.Persistent;

public class Map extends Persistent {

	public int id;
	public Character mainPlayer;
	public Character[] monsters;
	public int numOfMonsters;
	
	public Map() {
		this.id = 0;
		this.mainPlayer = null;
		this.monsters = null;
		this.numOfMonsters = 0;
	}
	
	public Map(int id, Character mainPlayer) {
		this.id = id;
		this.mainPlayer = mainPlayer;
		this.monsters = new Monster[5];
		this.numOfMonsters = 0;
	}
	
	public void addMonster(Character monster) {
		if (this.numOfMonsters < 5) {
			this.monsters[this.numOfMonsters++] = monster;
		}
	}
	
	@Override
	public String toString() {
		return this.id + ": " + this.mainPlayer.name + " vs " + this.numOfMonsters;
	}
}
