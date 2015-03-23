
public class Affectation implements Constants {

	private Ident leftIdent;
	
	private ValueType rightType;

	
	public boolean eval() {
		if(rightType != leftIdent.getValueType()) {
			Yaka.yvm.ecrireErreur("Erreur d'affectation (" + leftIdent.getValueType() + " = " + rightType + ")");
			return false;
		}
		leftIdent.store();

		return true;
	}
	
	public void setLeftIdent(String identLu) {
		Ident ident = Yaka.tabIdent.chercheIdent(identLu);
		if(ident == null) {
			Yaka.yvm.ecrireErreur("Erreur d'affectation (ident "+ identLu +" non trouvé.)");
		}
		else {
			this.leftIdent = ident;
		}
	}

	public void setRightType(ValueType rightType) {
		this.rightType = rightType;
	}
	
	
	
}
