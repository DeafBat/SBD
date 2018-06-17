package perst;

import java.util.Iterator;

import org.garret.perst.Storage;
import org.garret.perst.StorageFactory;

public class Database {

	public static void main(String[] args) {
		
		System.out.println("--==Perst Database==--");
		
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
		Item sword = new Item("Sword", 200, 100);
		Item potion = new Item("Potion", 10, 1);
		Item cloak = new Item("Cloak", 150, 50);
		Character player1 = new Player("Qwerty", 50, 35, 123);
		Character player2 = new Player("Wasd", 60, 25, 321);
		Character monster1 = new Monster("Kobold", 20, 10, 9);
		Character monster2 = new Monster("Troll", 30, 20, 22);
		Character monster3 = new Monster("Gnome", 13, 8, 47);
		Map map = new Map(1);
		map.addCharacter(player1);
		map.addCharacter(player2);
		map.addCharacter(monster1);
		map.addCharacter(monster2);
		map.addCharacter(monster3);
		
		//Store them.
		root.itemIndex.put(sword);
		root.itemIndex.put(potion);
		root.itemIndex.put(cloak);
		root.mapIndex.put(map);
		db.commit();
		
		//Close the DB.
		db.close();
		
		//Open DB.
		db.open("test.dbs");
		
		//Get root.
		root = (MyRootClass)db.getRoot();
		
		//Get all items and run their toString method.
		Iterator<Item> i = root.itemIndex.iterator();
		while (i.hasNext()) {
			Item item = (Item)i.next();
			System.out.println(item.toString());
		}
		
		//Get all maps and run their toString Methods.
		Iterator<Map> j = root.mapIndex.iterator();
		while (j.hasNext()) {
			Map m = (Map)j.next();
			System.out.println(m.toString());
		}
		
		//Close the db again.
		db.close();
	}

}
