package simonAli;

import java.awt.Color;

import gui6.components.Action;
import gui6.components.Visible;

public interface ButtonInterface extends Visible {

	void setColor(Color color);

	void setX(int xCoors);

	void setY(int yCoors);

	void setAction(Action action);

	void highlight();

	void dim();

	void getButton();
	
	void setName(String name);


}