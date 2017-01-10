package simonAlii;

import gui.GUIApplication;

public class SimonGameX extends GUIApplication implements Runnable {

	public SimonGameX(int width, int height) {
		super(width, height);
	}

	public void initScreen() {
		SimonScreenX sgm = new SimonScreenX();
		setScreen(sgm);
	}
	
	private void setScreen(SimonScreenX sgm) {
		// TODO Auto-generated method stub
		
	}

	public static void main(){
		SimonGameX sgm= new SimonGameX(800,600);
		Thread game = new Thread(sgm);
		game.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}