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
	
}
