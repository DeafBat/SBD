package perst;

import org.garret.perst.FieldIndex;
import org.garret.perst.Persistent;
import org.garret.perst.Storage;

public class MyRootClass extends Persistent {
	
	public FieldIndex<Item> itemIndex;
	public FieldIndex<Character> characterIndex;
	
	public MyRootClass() {}
	
	public MyRootClass(Storage db) {
		super(db);
		
		this.itemIndex = db.createFieldIndex(Item.class, "name", true);
		this.characterIndex = db.createFieldIndex(Character.class, "name", true);
	}
}
