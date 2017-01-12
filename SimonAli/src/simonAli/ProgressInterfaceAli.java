package simonAli;

import gui6.components.Visible;

public interface ProgressInterfaceAli extends Visible {
	void gameOver();

	void setRoundInt(int roundNumber);

	void setSequenceSize(int size);

	SimonScreenX get(int sequenceIndex);

}
