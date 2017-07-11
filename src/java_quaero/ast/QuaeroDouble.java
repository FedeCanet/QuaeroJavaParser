package java_quaero.ast;

public class QuaeroDouble extends QuaeroValue {
	private Double value;
	
	public QuaeroDouble(Double num) {
		this.value = num;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
		{
			System.out.println("ke wea");
			return false;}
		if (getClass() != obj.getClass())
			return false;
		QuaeroDouble other = (QuaeroDouble) obj;
		if (value == null) {
			if (other.getValue()!= null){
				System.out.println("ke wea");
				return false;}
		} else if (!value.equals(other.getValue())){
			System.out.println("ke wea");
			return false;}
		return true;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
