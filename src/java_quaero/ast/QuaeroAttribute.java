package java_quaero.ast;

public class QuaeroAttribute {
	String tag;
	Value val;
	public QuaeroAttribute(String tag, Value val) {
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
	public Value getVal() {
		return val;
	}
	public void setVal(Value val) {
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
	
}
