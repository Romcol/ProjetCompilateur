import java.util.EmptyStackException;
import java.util.Stack;

public class Conditionnelle implements Constants{
	
	
	private int itIdent = 0;
	private Stack<Integer> pileCond = new Stack<Integer>();
	
	
	public void open()
	{
		itIdent++;
		pileCond.push(itIdent);
	}
	
	public void endThen() {
		
		try{
			int id = pileCond.lastElement();
			Yaka.yvm.igoto("FSI" + id);
			Yaka.yvm.label("SINON" + id);
		}
		catch(EmptyStackException e) {
			Yaka.yvm.ecrireErreur("Unexpected end of iteration");
		}		
	}
	
	public void close (){
		try{
			int id = pileCond.pop();
			Yaka.yvm.label("FSI" + id);
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
		
		Yaka.yvm.iffaux("SINON" + pileCond.lastElement());
	}
}
