package perst;

import org.garret.perst.Persistent;

public class Item extends Persistent{
	
	public String name;
	public int buyPrice;
	public int sellPrice;
	
	public Item() {
		this.name = "DUMMY";
		this.buyPrice = 0;
		this.sellPrice = 0;
	}
	
	public Item(String name, int buyPrice, int sellPrice) {
		this.name = name;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	public String toString() {
		return this.name + ": B(" + this.buyPrice + ") S(" + this.sellPrice + ")";
	}
}
