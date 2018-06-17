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
		
		root.strKeyIndex.put(sword);
		root.strKeyIndex.put(potion);
		root.strKeyIndex.put(cloak);
		
		db.commit();
		
		db.close();
		
		db.open("test.dbs");
		root = (MyRootClass)db.getRoot();
		Iterator<Item> i = root.strKeyIndex.iterator();
		while (i.hasNext()) {
			Item item = (Item)i.next();
			System.out.println(item.toString());
		}
		db.close();
	}

}
