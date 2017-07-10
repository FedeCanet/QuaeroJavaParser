package java_quaero.ast;

import java.util.ArrayList;
import java.util.HashMap;

public class QuaeroObject {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashValue == null) ? 0 : hashValue.hashCode());
		result = prime * result + ((objectList == null) ? 0 : objectList.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuaeroObject other = (QuaeroObject) obj;
		if (hashValue == null) {
			if (other.hashValue != null)
				return false;
		} else if (!hashValue.equals(other.hashValue))
			return false;
		if (objectList == null) {
			if (other.objectList != null)
				return false;
		} else if (!objectList.equals(other.objectList))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
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
