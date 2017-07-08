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

	public void setTag(String id) {
		// TODO Auto-generated method stub
		
	}

	public void put(String key, Value val) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<QuaeroObject> getObjectList() {
		return objectList;
	}

	public void setObjectList(ArrayList<QuaeroObject> objectList) {
		this.objectList = objectList;
	}
}
