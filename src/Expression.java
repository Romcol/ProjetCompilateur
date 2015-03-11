import java.util.Stack;




public class Expression implements Constants{
	
	private Stack<ValueType> pileType= new Stack<ValueType>();
	private Stack<Operation> pileOp= new Stack<Operation>();
	
	public void eval(){
		Operation op = pileOp.pop();
		ValueType type1 = pileType.pop();
		ValueType type2 = pileType.pop();
		
		if(type1 == type2)
		{
			switch(op){
				case PLUS :
				case MINUS :
				case MUL :
				case DIV :
					if(type1 != ValueType.ENTIER) 
					{
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
						System.out.println("Erreur dans le calcul de l'expresion.");
						pileType.push(ValueType.BOOLEEN);
					}
					break;
				case EQUAL :
				case NEQUAL :
				pileType.push(ValueType.BOOLEEN);
				break;
				default:
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
		if(type == ValueType.ENTIER && op == Operation.MINUS)
		{
			pileType.push(ValueType.ENTIER);
		}
		else if(type == ValueType.BOOLEEN && op == Operation.NOT){
			pileType.push(ValueType.BOOLEEN);
		}
		else{
			System.out.println("Erreur dans le calcul de l'expresion.");
		}
	}
	
	public void pushOp(Operation op)
	{
		pileOp.push(op);
	}
	
	public void pushType(ValueType typ)
	{
		pileType.push(typ);
	}
	
}
