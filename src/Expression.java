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
				case INF :
				case SUP :
				case INFEQ :
				case SUPEQ :
					if(type1 != ValueType.ENTIER) 
					{
						System.out.println("Erreur dans le calcul de l'expresion.");
					}
					break;
				case AND :
				case OR :
					if(type1 != ValueType.BOOLEEN) 
					{
						System.out.println("Erreur dans le calcul de l'expresion.");
					}
					break;
				default:
					System.out.println("Erreur dans le calcul de l'expression.");
			}
		}
		else{
			System.out.println("Erreur dans le calcul de l'expresion.");
		}
	}
	
	public void stack(){
		
	}
}
