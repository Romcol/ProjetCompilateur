import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class AppelFonction implements Constants{
	
	
	private Stack<Ident> stackIdent = new Stack<Ident>();
	private Stack<IdFunct> stackIdFunct = new Stack<IdFunct>();
	
	private Stack<ArrayList<ValueType>> stackArguments = new Stack<ArrayList<ValueType>>();
	
	public void init(String ident) {
		
		//this.arguments.clear();

		Ident tmpIdent = Yaka.tabIdent.chercheIdent(ident);
		IdFunct tmpIdFunct = Yaka.tabIdent.chercheFonction(ident);
		
		if(tmpIdFunct != null)
		{
			System.out.println("Lecture de la fonction "+tmpIdFunct.getName());
			stackIdFunct.push(tmpIdFunct);
			Yaka.yvm.reserveRetour();
		}
		else if(tmpIdent != null)
		{
			stackIdent.push(tmpIdent);
		}
		else{
			Yaka.yvm.ecrireErreur("Ident "+ident+"+ is not found");
			return;
		}
	}
	
	public void initArguments(){
		ArrayList<ValueType> arguments = new ArrayList<ValueType>();
		stackArguments.push(arguments);
	}
	
	public void addArgument(ValueType type) {
		ArrayList<ValueType> arguments = stackArguments.pop();
		arguments.add(type);
		stackArguments.push(arguments);
	}
	
	
	public void endOfCall() {
		// Si IdVar/IdConst
		if(stackIdent.size() != 0) {
			Ident ident = stackIdent.pop();
			Yaka.expression.pushType(ident.getName());
		}
		// Si IdFunct
		else if(stackIdFunct.size() != 0){
			// controle des arguments
			
			ArrayList<ValueType> arguments = stackArguments.pop();
			IdFunct idFunct = stackIdFunct.pop();
			
			System.out.println("Appel de la fonction "+idFunct.getName());
			
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
			
			Yaka.expression.pushType(idFunct.getName());
			
			Yaka.yvm.call(idFunct.getName());
			
			
		}
		
	}
	
	
	
}
