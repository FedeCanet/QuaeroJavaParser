package java_quaero.ast;

import java.util.ArrayList;
import java.util.HashMap;

public class QuaeroObject {
	
	private String tag;
	private ArrayList<QuaeroObject> objectList;
	private HashMap<String, Value> hashValue;
	
	public QuaeroObject(String id){
		this.tag = id;
		this.objectList = new ArrayList<QuaeroObject>();
		this.hashValue = new HashMap<String, Value>();
	}
}
