package java_quaero.ast;

import java.util.ArrayList;

public class QuaeroAttribute extends QuaeroObject{
	String tag;
	QuaeroValue val;
	public QuaeroAttribute(String tag, QuaeroValue val) {
		super();
		this.tag = tag;
		this.val = val;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public QuaeroValue getVal() {
		return val;
	}
	public void setVal(QuaeroValue val) {
		this.val = val;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((val == null) ? 0 : val.hashCode());
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
		QuaeroAttribute other = (QuaeroAttribute) obj;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		return true;
	}
	@Override
	public ArrayList<QuaeroObject> eval() {
		// TODO Auto-generated method stub
		ArrayList<QuaeroObject> result = new ArrayList<QuaeroObject>();
		result.add(this);
		return result;
	}
	@Override
	public String toString() {
		return tag+":"+val.toString();
	}
	
}
