
abstract public class Ident {
	private enum Type {
		VARIABLE, CONSTANTE
	}
	private Type type;
	private String name;
	private enum ValueType {
		BOOLEAN, ENTIER
	}
	private ValueType valueType;
	public Ident(int type, String name, int valueType){
		this.type = type;
		this.valueType = valueType;
		this.name = name;
	}
}
