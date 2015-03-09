import java.util.Stack;


public class Expression {
	
	private Stack pileval= new Stack();
	private Stack pileop= new Stack();
	
	public void ajoutepileop(char c){
		pileop.add(c);
	}
	public void ajoutepileval(char c){
		pileval.add(c);
	}
	public void effectueOperation(){
		switch(pileop.pop()){
		 case '+' :
		 pileop.add(pileval.pop()+pileval.pop());
	 	case '-' :
	 	float val = pileval.pop();
	 	pileop.add(pileval.pop()-val);
	 	case '*' :
	 	pileop.add(pileval.pop()*pileval.pop());
	 	case '/' :
	 	float val = pileval.pop();
	 	pileop.add(pileval.pop()/val);
		}
	}
	public void negatif(){
		float val = pileval.pop();
		pileval.add(-val);	
	}
	public void afficher(){
		Sytem.out.println(pileval.pop());	
	}

}
