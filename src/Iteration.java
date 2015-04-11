import java.util.EmptyStackException;
import java.util.Stack;


public class Iteration implements Constants{
	private int itIdent = 0;
	private Stack<Integer> pileIt= new Stack<Integer>();
	
	public void push()
	{
		itIdent++;
		pileIt.push(itIdent);
		
		Yaka.yvm.beginIt(itIdent);
	}
	
	public void close (){
		try{
			int id = pileIt.pop();
			Yaka.yvm.igoto("FAIT" + id);
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
		
		Yaka.yvm.iffaux("FAIT" + pileIt.lastElement());
	}
}
 