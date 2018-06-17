package perst;

import java.util.Iterator;

import org.garret.perst.Storage;
import org.garret.perst.StorageFactory;

public class Database {

	public static void main(String[] args) {
		System.out.println("--==Perst Database==--");
		Storage db = StorageFactory.getInstance().createStorage();
		db.open("test.dbs");
		
		MyRootClass root = (MyRootClass)db.getRoot();
		if (root == null) {
			root = new MyRootClass(db);
			db.setRoot(root);
		}
		
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
		
		
		root.itemIndex.put(sword);
		root.itemIndex.put(potion);
		root.itemIndex.put(cloak);
		root.mapIndex.put(map);
		
		db.commit();
		
		db.close();
		
		db.open("test.dbs");
		root = (MyRootClass)db.getRoot();
		Iterator<Item> i = root.itemIndex.iterator();
		while (i.hasNext()) {
			Item item = (Item)i.next();
			System.out.println(item.toString());
		}
		Iterator<Map> j = root.mapIndex.iterator();
		while (j.hasNext()) {
			Map m = (Map)j.next();
			System.out.println(m.toString());
		}
		db.close();
	}

}
