package perst;

public class Shop {
	
	public int id;
	public Item[] items;
	public int gold;
	public int numOfItems;
	
	public Shop() {
		this.id = 0;
		this.items = null;
		this.gold = 0;
		this.numOfItems = 0;
	}
	
	public Shop(int id, int gold) {
		this.id = id;
		this.items = new Item[10];
		this.gold = gold;
		this.numOfItems = 0;
	}
	
	void buy(Item item) {
		if (this.numOfItems < 10) {
			this.items[this.numOfItems++] = item;
			this.gold -= item.sellPrice;
		}
	}
	
	@Override
	public String toString() {
		String s = this.id + "(" + this.gold + "): \n";
		for (int i = 0; i < this.numOfItems; i++) {
			s += "  " + this.items[i].toString() + "\n";
		}
		return s;
	}
	
}
