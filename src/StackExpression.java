import java.util.Stack;

public class StackExpression implements Constants {
	private Stack<Expression> stackExpression = new Stack<Expression>();
	
	public void newExpression()
	{
		stackExpression.push(new Expression());
	}
	
	public void eval(){
		stackExpression.lastElement().eval();
	}
	
	public void evalNeg(){
		stackExpression.lastElement().evalNeg();
	}
	
	public void pushOp(Operation op){
		stackExpression.lastElement().pushOp(op);
	}
	
	public void pushBool(int value){
		stackExpression.lastElement().pushBool(value);
	}
	
	public void pushInt(int value){
		stackExpression.lastElement().pushInt(value);
	}
	
	public void pushType(String identLu){
		stackExpression.lastElement().pushType(identLu);
	}
	
	public ValueType getFinalType(){
		return stackExpression.pop().getFinalType();
	}
}
