import java.util.Stack;


public class Expression implements Constants{
	
	private Stack pileType= new Stack();
	private Stack pileOp= new Stack();
	
	public void eval(){
		String op = pileOp.pop();
		char type1 = pileType.pop();
		char type2 = pileType.pop();
		if(type1 == type2)
		{
			switch(op){
			case '+' :
			case '-' :
			case '*' :
			case '/' :
			case '<' :
			case '>' :
			case '<=' :
			case '>=' :
			if(type1 != ValueType.ENTIER) 
			{
				System.out.println("Erreur dans le calcul de l'expresion.");
			}
			break;
			case 'et' :
			case 'ou' :
			if(type1 != ValueType.BOOLEEN) 
			{
				System.out.println("Erreur dans le calcul de l'expresion.");
			}
			break;
		}
		else{
			System.out.println("Erreur dans le calcul de l'expresion.");
		}
	}
	
	public void stack(){
		
	}
	}
}
