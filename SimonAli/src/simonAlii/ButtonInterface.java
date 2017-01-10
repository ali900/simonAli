package simonAlii;

import java.awt.Color;

import gui6.components.Action;

public interface ButtonInterface extends Clickable {

	void setColor(Color color);

	void setX(int xCoors);

	void setY(int yCoors);

	void setAction(Action action);

	void highlight();

	void dim();

	void getButton();



}