
abstract public class Ident implements Constants{
	protected String name;
	protected ValueType valueType;
	protected int value;
	public int getValue() {
		return value;
	}
	public ValueType getValueType(){
		return valueType;
	}
	public Ident(String name, ValueType valueType){
		this.valueType = valueType;
		this.name = name;
	}
	
	public abstract void load();
	
	public abstract void store();
	
	public void setValue(int value) {
		this.value = value;
	}
}
