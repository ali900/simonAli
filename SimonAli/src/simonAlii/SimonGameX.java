package simonAlii;

import gui.GUIApplication;

public class SimonGameX extends GUIApplication {

	public SimonGameX(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		SimonScreenX sgm = new SimonScreenX(getWidth(),getHeight());
		setScreen(sgm);
	}
	
	public static void main(){
		SimonGameX sgm= new SimonGameX(800,600);
		Thread game = new Thread(sgm);
		game.start();
	}
}