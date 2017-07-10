package java_quaero.ast;

import java.util.ArrayList;
import java.util.HashMap;

public class QuaeroObject {
	
	private String tag;
	private ArrayList<QuaeroObject> objectList;
	private HashMap<String, Value> hashValue;
	
	public QuaeroObject(){
		this.setObjectList(new ArrayList<QuaeroObject>());
		this.hashValue = new HashMap<String, Value>();
	}

	public String getTag(){
		return tag;
	}
	public void setTag(String id) {
		this.tag = id;
	}

	public void put(String key, Value val) {
		this.hashValue.put(key, val);
	}

	public ArrayList<QuaeroObject> getObjectList() {
		return objectList;
	}

	public void setObjectList(ArrayList<QuaeroObject> objectList) {
		this.objectList = objectList;
	}
	public HashMap<String,Value> getAttributes(){
		return hashValue;
	}
}
