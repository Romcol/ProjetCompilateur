
public class Affectation implements Constants {

	private Ident leftIdent;
	
	private ValueType rightType;

	
	public boolean eval() {
		if(rightType != leftIdent.getValueType()) {
			System.out.println("Erreur d'affectation (" + leftIdent.getValueType() + " = " + rightType + ")");
			return false;
		}
		if(leftIdent instanceof IdVar)
		{
			Yaka.yvm.istore(Yaka.yvm.getOffset((IdVar)leftIdent));
		}
		else{
			System.out.println("Impossible de modifier une constante.");
		}
		return true;
	}
	
	public void setLeftIdent(String identLu) {
		Ident ident = Yaka.tabIdent.chercheIdent(identLu);
		if(ident == null) {
			System.out.println("lalalala\n");
			System.out.println("Erreur d'affectation (ident "+ identLu +" non trouvé.)");
		}
		else {
			this.leftIdent = ident;
		}
	}

	public void setRightType(ValueType rightType) {
		this.rightType = rightType;
	}
	
	
	
}
