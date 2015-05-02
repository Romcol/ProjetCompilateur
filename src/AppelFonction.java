import java.util.ArrayList;
import java.util.List;


public class AppelFonction implements Constants{
	
	
	private Ident ident;
	private IdFunct idFunct;
	
	private List<ValueType> arguments = new ArrayList<ValueType>();
	
	
	
	public void init(String ident) {
		this.arguments.clear();

		this.ident = Yaka.tabIdent.chercheIdent(ident);
		this.idFunct = Yaka.tabIdent.chercheFonction(ident);
		
		if(idFunct != null)
		{
			Yaka.yvm.reserveRetour();
		}
	}
	
	
	public void addArgument(ValueType type) {
		arguments.add(type);
	}
	
	
	public void endOfCall() {

		// Si IdVar/IdConst
		if(arguments.size() == 0 && ident != null) {
			Yaka.expression.pushType(ident.getName());
		}
		// Si IdFunct
		else if(idFunct != null){
			// controle des arguments
			List<IdVar> params = idFunct.getParams();

			if(params.size() != arguments.size()) {
				Yaka.yvm.ecrireErreur("Incorrect number of parameters : " + params.size() + " expected, " + arguments.size() + "encountered.");
				return;
			}
			
			ValueType expected = null;
			ValueType encountered = null;
			for(int i = 0; i < arguments.size(); i++) {
				
				expected = params.get(i).getValueType();
				encountered = arguments.get(i);
				
				boolean paramsOk = true;
				
				if(expected != encountered) {
					paramsOk = false;
					Yaka.yvm.ecrireErreur("Incorrect parameter n°" + i + " : " + expected + " expected, " + encountered + "encountered.");
				}
				if(!paramsOk)
					return;
				
			}
			
			Yaka.yvm.call(ident.getName());
			
			
		}
		
	}
	
	
	
}
