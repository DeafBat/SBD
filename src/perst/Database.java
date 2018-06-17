package perst;

import java.util.Iterator;

import org.garret.perst.Storage;
import org.garret.perst.StorageFactory;

public class Database {

	public static void main(String[] args) {
		System.out.println("Perst Database");
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
		
		root.itemIndex.put(sword);
		root.itemIndex.put(potion);
		root.itemIndex.put(cloak);
		root.characterIndex.put(player1);
		
		db.commit();
		
		db.close();
		
		db.open("test.dbs");
		root = (MyRootClass)db.getRoot();
		Iterator<Item> i = root.itemIndex.iterator();
		while (i.hasNext()) {
			Item item = (Item)i.next();
			System.out.println(item.toString());
		}
		Iterator<Character> j = root.characterIndex.iterator();
		while (j.hasNext()) {
			Character character = (Character)j.next();
			System.out.println(character.toString());
		}
		db.close();
	}

}
