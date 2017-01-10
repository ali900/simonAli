package simonAlii;

import java.util.ArrayList;
import java.util.List;

import gui6.components.TextLabel;
import gui6.components.Visible;


public class SimonScreenX extends ClickableScreen implements Runnable{

	private TextLabel text;
	private ButtonInterface[] btnList;
	private ProgressInterfaceAli progress;
	private ArrayList<MoveInterfaceAli> moveList;

	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public SimonScreenX(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}
	public void run() {
		text.setText("");
		nextRound();
		progress.setRoundInt(roundNumber);
		progress.setSequenceSize(moveList.size());
		changeText("Simon's turn");
		text.setText("");
		playSequence();
		changeText("Your turn");
		sequenceIndex = 0;
		acceptingInput=true;
	}
	private void playSequence() {
		// TODO Auto-generated method stub
		
	}
	private void changeText(String string) {
		// TODO Auto-generated method stub
		
	}
	private void nextRound() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
}
