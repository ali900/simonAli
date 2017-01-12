package simonAli;

import gui6.GUIApplication;

public class SimonGameX extends GUIApplication {
	
	public static void main(String[] args) {
		SimonGameX sgm = new SimonGameX(800, 600);
		Thread game = new Thread(sgm);
		game.start();
	}

	public SimonGameX(int width, int height) {
		super(width, height);
	}

	public void initScreen() {
		SimonScreenX sgm = new SimonScreenX(800, 600);
		setScreen(sgm);
	}

}
