package simonAlii;

import java.util.ArrayList;

import gui.components.TextLabel;
import simonMichael.ButtonInterfaceMichael;
import simonMichael.MoveInterfaceMichael;
import simonMichael.ProgressInterfaceMichael;

public class SimonScreenX extends ClickableScreen implements Runnable{

	private TextLabel text;
	private ButtonInterface[] btnList;
	private ProgressInterface progress;
	private ArrayList<MoveInterface> moveList;

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
}
