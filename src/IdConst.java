
public class IdConst extends Ident {
	private int value;
	public IdConst(String name, ValueType valueType, int value){
		super(name, valueType);
		this.value = value;
	}
	public boolean isConst(){
		return true;
	}
	public int getValue() {
		return value;
	}
}
