import java.util.Stack;




public class Expression implements Constants{
	
	private Stack<ValueType> pileType= new Stack<ValueType>();
	private Stack<Operation> pileOp= new Stack<Operation>();
	
	public void eval(){
		
		
		Operation op = pileOp.pop();
		ValueType type1 = pileType.pop();
		ValueType type2 = pileType.pop();
		
		System.out.println("eval : " + type1 + " " + op + " " + type2);

		if(type1 == type2)
		{
			switch(op){
				case PLUS :
				case MINUS :
				case MUL :
				case DIV :
					if(type1 != ValueType.ENTIER) 
					{
						pileType.push(ValueType.ERREUR);
						System.out.println("Erreur dans le calcul de l'expresion.");
						
					}
					else{
						pileType.push(ValueType.ENTIER);
					}
					break;
				case INF :
				case SUP :
				case INFEQ :
				case SUPEQ :
				if(type1 != ValueType.ENTIER) 
				{
					pileType.push(ValueType.ERREUR);
					System.out.println("Erreur dans le calcul de l'expresion.");
					
				}
				else{
					pileType.push(ValueType.BOOLEEN);
		 		}
				break;
				case AND :
				case OR :
					if(type1 != ValueType.BOOLEEN) 
					{
						pileType.push(ValueType.ERREUR);
						System.out.println("Erreur dans le calcul de l'expresion.");
					}
					break;
				case EQUAL :
				case NEQUAL :
				pileType.push(ValueType.BOOLEEN);
				break;
				default:
					pileType.push(ValueType.ERREUR);
					System.out.println("Erreur dans le calcul de l'expression.");
			}
		}
		else{
			System.out.println("Erreur dans le calcul de l'expresion.");
		}
	}
	public void evalNeg(){
		Operation op = pileOp.pop();
		ValueType type = pileType.pop();
		
		System.out.println("eval : " + op + " " + type);

		if(type == ValueType.ENTIER && op == Operation.MINUS)
		{
			pileType.push(ValueType.ENTIER);
		}
		else if(type == ValueType.BOOLEEN && op == Operation.NOT){
			pileType.push(ValueType.BOOLEEN);
		}
		else{
			pileType.push(ValueType.ERREUR);
			System.out.println("Erreur dans le calcul de l'expresion.");
		}
	}
	
	public void pushOp(Operation op)
	{
		System.out.println("pushOp " + op);
		pileOp.push(op);
	}
	
	public void pushType(ValueType typ)
	{
		System.out.println("pushType " + typ);
		pileType.push(typ);
	}
	
	public void pushType(String identLu) {
		Ident ident = Yaka.tabIdent.chercheIdent(identLu);
		if(ident == null) {
			pileType.push(ValueType.ERREUR);
			System.out.println("Erreur dans le calcul de l'expresion (ident "+ identLu +" non trouvé.)");
		}
		else {
			ValueType type = ident.getValueType();
			System.out.println("pushType " + type);

			pileType.push(type);
		}
	}
	
	public String toString() {
		return pileOp.toString() + "\n" + pileType.toString();
	}
	
}
