
public class IdConst extends Ident {
	public IdConst(String name, ValueType valueType, int value){
		super(name, valueType);
		this.value = value;
	}
	public boolean isConst(){
		return true;
	}
	public String toString() {
		return name + ":" + Integer.toString(this.value);
	}

	public void load() {
		Yaka.yvm.iconst(this.value);
	}

	public void store() {
		Yaka.yvm.ecrireChaine("Impossible de modifier une constante.");
	}
}
