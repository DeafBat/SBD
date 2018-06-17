package perst;

import java.util.Iterator;

import org.garret.perst.Storage;
import org.garret.perst.StorageFactory;

public class Database {

	public static void main(String[] args) {
		
		System.out.println("--==Perst Database==--\n");
		
		//Create and open DB.
		Storage db = StorageFactory.getInstance().createStorage();
		db.open("test.dbs");
		
		//Get (or create if nonexistent) root object of DB.
		MyRootClass root = (MyRootClass)db.getRoot();
		if (root == null) {
			root = new MyRootClass(db);
			db.setRoot(root);
		}
		
		//Create some objects.
		Character player1 = new Player("Qwerty", 50, 35, 123);
		Character player2 = new Player("Wasd", 60, 25, 321);
		Character monster1 = new Monster("Kobold", 20, 10, 9);
		Character monster2 = new Monster("Troll", 30, 60, 22);
		Character monster3 = new Monster("Gnome", 13, 8, 47);
		Map map = new Map(1);
		map.addCharacter(player1);
		map.addCharacter(player2);
		map.addCharacter(monster1);
		map.addCharacter(monster2);
		map.addCharacter(monster3);
		Item item1 = new Item("Sword", 200, 100);
		Item item2 = new Item("Potion", 10, 1);
		Item item3 = new Item("Cloak", 150, 50);
		Shop shop = new Shop(1, 300);
		shop.buy(item1);
		shop.buy(item2);
		
		//Store them.
		root.mapIndex.put(map);
		root.itemIndex.put(item1);
		root.itemIndex.put(item2);
		root.itemIndex.put(item3);
		root.shopIndex.put(shop);
		db.commit();
		
		//Close the DB.
		db.close();
		
		//Open DB.
		db.open("test.dbs");
		
		//Get root.
		root = (MyRootClass)db.getRoot();
		
		//Get all items and run their toString method.
		Iterator<Item> i = root.itemIndex.iterator();
		Item item = null;
		while (i.hasNext()) {
			item = (Item)i.next();
			System.out.println(item.toString());
		}
		
		System.out.println();
		
		//Get all maps and run their toString and firstFightWithRest Methods.
		Iterator<Map> j = root.mapIndex.iterator();
		while (j.hasNext()) {
			Map m = (Map)j.next();
			System.out.println(m.toString());
			m.firstFightWithRest();
		}
		
		System.out.println();
		
		//Get all maps and run their toString and firstFightWithRest Methods.
		Iterator<Shop> k = root.shopIndex.iterator();
		while (k.hasNext()) {
			Shop s = (Shop)k.next();
			System.out.println(s.toString());
			s.buy(item);
			System.out.println(s.toString());
		}
		
		//Close the db again.
		db.close();
	}

}
