package perst;

import org.garret.perst.FieldIndex;
import org.garret.perst.Persistent;
import org.garret.perst.Storage;

public class MyRootClass extends Persistent {
	
	public FieldIndex<Item> strKeyIndex;
	
	public MyRootClass() {}
	
	public MyRootClass(Storage db) {
		super(db);
		
		strKeyIndex = db.createFieldIndex(Item.class, "name", true);
	}
}
