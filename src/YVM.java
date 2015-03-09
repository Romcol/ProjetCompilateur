import java.util.Stack;


public class YVM {

	protected Stack<IdVar> pile;
	
	
	public YVM() {
		this.pile = new Stack<IdVar>();
	}

	public void addVar(IdVar var) {
		this.pile.push(var);
	}

	public void getVar(int offset) {
		this.pile.get(-2 * offset);
	}
	
	
	
	public static void error(String message) {
		System.out.println(message + "\n");
	}

}
