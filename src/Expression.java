import java.util.Stack;




public class Expression implements Constants{
	
	private Stack<ValueType> pileType= new Stack<ValueType>();
	private Stack<Operation> pileOp= new Stack<Operation>();
	
	public void eval(){
		
		if(pileType.isEmpty() || pileOp.isEmpty())
			return;
		
		//System.out.println("-------");
		//System.out.print(this);
		//System.out.println(Yaka.token.image);
		
		Operation op = pileOp.pop();
		System.out.println("Popage de operation "+op);
		ValueType type1 = pileType.pop();
		System.out.println("Popage de type "+type1);
		ValueType type2 = pileType.pop();
		System.out.println("Popage de type "+type2);
		
		Yaka.yvm.ecrireOp(op);
		
		if(type1 == type2)
		{
			switch(op){
				case PLUS :
				case SUB :
				case MUL :
				case DIV :
					if(type1 != ValueType.ENTIER) 
					{
						pileType.push(ValueType.ERREUR);
						Yaka.yvm.ecrireErreur("Erreur dans le calcul de l'expresion.");
						
					}
					else{
						pileType.push(ValueType.ENTIER);
						System.out.println("Pushage de "+ValueType.ENTIER);
					}
					break;
				case INF :
				case SUP :
				case INFEQ :
				case SUPEQ :
				if(type1 != ValueType.ENTIER) 
				{
					pileType.push(ValueType.ERREUR);
					Yaka.yvm.ecrireErreur("Erreur dans le calcul de l'expression.");
					
				}
				else{
					pileType.push(ValueType.BOOLEEN);
					System.out.println("Pushage de "+ValueType.BOOLEEN);
		 		}
				break;
				case AND :
				case OR :
					if(type1 != ValueType.BOOLEEN) 
					{
						pileType.push(ValueType.ERREUR);
						Yaka.yvm.ecrireErreur("Erreur dans le calcul de l'expression.");
					}
					else
					{
						pileType.push(ValueType.BOOLEEN);
						System.out.println("Pushage de "+ValueType.BOOLEEN);
					}
					break;
				case EQUAL :
				case NEQUAL :
				pileType.push(ValueType.BOOLEEN);
				System.out.println("Pushage de "+ValueType.BOOLEEN);
				break;
				default:
					pileType.push(ValueType.ERREUR);
					Yaka.yvm.ecrireErreur("Erreur dans le calcul de l'expression.");
			}
		}
		else{
			pileType.push(ValueType.ERREUR);
			Yaka.yvm.ecrireErreur("Erreur dans le calcul de l'expression.");
		}

		//System.out.print(this);
		//System.out.println(Yaka.token.image);
		//System.out.println("-------");
	}
	public void evalNeg(){
		Operation op = pileOp.pop();
		System.out.println("Popage de operation "+op);
		ValueType type = pileType.pop();
		System.out.println("Popage de type "+type);
		
		Yaka.yvm.ecrireOp(op);
		
		if(type == ValueType.ENTIER && op == Operation.MINUS)
		{
			pileType.push(ValueType.ENTIER);
			System.out.println("Pushage de "+ValueType.ENTIER);
		}
		else if(type == ValueType.BOOLEEN && op == Operation.NOT){
			pileType.push(ValueType.BOOLEEN);
			System.out.println("Pushage de "+ValueType.BOOLEEN);
		}
		else{
			pileType.push(ValueType.ERREUR);
			Yaka.yvm.ecrireErreur("Erreur dans le calcul de l'expresion.");
		}
	}
	
	public void pushOp(Operation op)
	{
		pileOp.push(op);
		System.out.println("Pushage de opération "+op);
	}
	
	public void pushBool(int value)
	{
		pileType.push(ValueType.BOOLEEN);
		System.out.println("Pushage de "+ValueType.BOOLEEN);
		Yaka.yvm.iconst(value);
	}

	public void pushInt(int value)
	{
		pileType.push(ValueType.ENTIER);
		System.out.println("Pushage de "+ValueType.ENTIER+" int :"+value);
		Yaka.yvm.iconst(value);
	}
	
	public void pushType(String identLu) {
		Ident ident = Yaka.tabIdent.chercheIdent(identLu);
		IdFunct idFunct = Yaka.tabIdent.chercheFonction(identLu);
		if(idFunct != null)
		{
			ValueType type = idFunct.getReturnType();
			pileType.push(type);
			System.out.println("Pushage de "+type+" de la fonction "+idFunct.getName());
		}
		else if (ident != null){
			ValueType type = ident.getValueType();
			pileType.push(type);
			System.out.println("Pushage de "+type+" de l'ident "+ident.getName());
			ident.load();
		}
		else {
			pileType.push(ValueType.ERREUR);
			Yaka.yvm.ecrireErreur("Erreur dans le calcul de l'expresion (ident "+ identLu +" non trouvé.)");
		}

	}
	
	public ValueType getFinalType() {
		if(pileType.size() != 1) {
			Yaka.yvm.ecrireErreur("La pile doit contenir 1 type a la fin de l'analyse de l'expression.");
			System.out.println("nombre :"+pileType.size());
			return null;
		}
		ValueType typecatch = pileType.pop();
		System.out.println("Popage de type "+typecatch);
		return typecatch;
	}
	
	public void init() {

	}
	public String toString() {
		return pileOp.toString() + "\n" + pileType.toString();
	}
	
}
