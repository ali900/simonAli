package simonAli;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui6.components.Action;
import gui6.components.ClickableScreen;
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

	public SimonScreenX(int width, int height) {
		super(width, height);
		
		btnList = new ButtonInterface[6];
		
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
	private void changeText(String string) {
		text.setText(string);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		moveList.add(randomMove());
		
	}
	private MoveInterfaceAli randomMove() {
		ButtonInterface b;
		int rand = -1;
		while (rand == lastSelectedButton || rand == -1){
			rand = (int) (Math.random() * btnList.length);
		}
		b = btnList[rand];

		return getMove(b);
	}
	private MoveInterfaceAli getMove(ButtonInterface b) {
		return null;
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		text = new TextLabel(130,230,300,40,"Let's play Simon!");
		moveList = new ArrayList<MoveInterfaceAli>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moveList.add(randomMove());
		moveList.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(text);
}
	private ProgressInterfaceAli getProgress() {
		// TODO Auto-generated method stub
		return null;
	}
	private void addButtons(List<Visible> viewObjects) {
		int numberOfButtons = 6;
		Color[] buttonColors = {Color.blue, Color.red, Color.yellow, Color.orange, Color.green, Color.pink};
		int[] xCoors = {350,365,435,450,435,365};
		int[] yCoors = {300,335,335,300,265,265};
		for(int i = 0; i < numberOfButtons; i++){
			final ButtonInterface b = getButton();
			b.setColor(buttonColors[i]);
			b.setX(xCoors[i]);
			b.setY(yCoors[i]);
			b.setAction(new Action(){

				public void act(){
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
							}

						});
						blink.start();

						if(b == progress.get(sequenceIndex).getButton()){
							sequenceIndex++;
						}else{
							progress.gameOver();
						}
					
						Thread nextRound = new Thread(SimonScreenX.this);
						nextRound.start();
						viewObjects.add(b);
					}
				}
			});
		}
	}	
	private ButtonInterface getButton() {
		// TODO Auto-generated method stub
		return new Button();
	}
	private void playSequence() {
		ButtonInterface b = null;
		for(int i = 0; i< moveList.size(); i++){
			if(b!=null){
				b.dim();
				b.getButton();
				b.highlight();
				
				try {
					Thread.sleep(1500/(200*roundNumber+1500));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		b.dim();
	}

}


