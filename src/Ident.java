
abstract public class Ident implements Constants{
	protected String name;
	protected ValueType valueType;
	public ValueType getValueType(){
		return valueType;
	}
	public Ident(String name, ValueType valueType){
		this.valueType = valueType;
		this.name = name;
	}
	public abstract boolean isConst();
}
