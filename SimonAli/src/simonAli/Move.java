package simonAli;

public class Move implements MoveInterfaceAli {

	private ButtonInterface b; 
	
	public Move(ButtonInterface b) {
		this.b = b;
	}

	public ButtonInterface getButton() {
		return b;
	}

}