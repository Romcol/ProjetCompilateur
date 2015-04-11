import java.util.EmptyStackException;
import java.util.Stack;

public class Conditionnelle implements Constants{
	
	
	private int itIdent = 0;
	private Stack<Integer> pileCond = new Stack<Integer>();
	
	
	public void push()
	{
		itIdent++;
		pileCond.push(itIdent);
		
		Yaka.yvm.beginCond(itIdent);
	}
	
	public void otherwise() {
		
		
		
	}
	
	public void close (){
		try{
			int id = pileCond.pop();
			Yaka.yvm.igoto(id);
			Yaka.yvm.closeIt(id);
		}
		catch(EmptyStackException e) {
			Yaka.yvm.ecrireErreur("Unexpected end of iteration");
		}
	}
	
	


	public void checkExprType (ValueType type)
	{
		if (type != ValueType.BOOLEEN){
			Yaka.yvm.ecrireErreur("Expected boolean expression in TANTQUE");
		}
		
		Yaka.yvm.iffaux(pileCond.lastElement());
	}
}
