package perst;

import org.garret.perst.Index;
import org.garret.perst.Storage;
import org.garret.perst.StorageFactory;

public class Database {

	public static void main(String[] args) {
		System.out.println("Perst Database");
		Storage db = StorageFactory.getInstance().createStorage();
		db.open("test.dbs");
		
		Index root = (Index)db.getRoot();
		if (root == null) {
			root = db.createIndex(String.class, true);
		}
		
		db.close();
	}

}
