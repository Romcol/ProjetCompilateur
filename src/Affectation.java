
public class Affectation implements Constants {

	private ValueType leftType;
	
	private ValueType rightType;

	
	public boolean eval() {
		if(rightType != leftType) {
			System.out.println("Erreur d'affectation (" + rightType + " = " + leftType + ")");
			return false;
		}
		return true;
	}
	
	public void setLeftType(String identLu) {
		
		Ident ident = Yaka.tabIdent.chercheIdent(identLu);
		if(ident == null) {
			System.out.println("Erreur d'affectation (ident "+ identLu +" non trouvé.)");
		}
		else {
			ValueType type = ident.getValueType();
			this.leftType = type;
		}
	}

	public void setRightType(ValueType rightType) {
		this.rightType = rightType;
	}
	
	
	
}
