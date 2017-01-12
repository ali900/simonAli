package simonAli;

import java.awt.Graphics2D;

import gui6.components.Visible;

public interface PlayerInterface extends Visible {

	void increaseScore(int i);

	void update(Graphics2D g);

}