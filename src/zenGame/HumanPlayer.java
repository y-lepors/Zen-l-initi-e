package zenGame;

import java.util.ArrayList;

/**
 * This class allows you to create a human player
 * @author LePors
 * @version 1.0
 */
public class HumanPlayer extends Player {

	/**
	 * Initialize the human player with his pawn list
	 * @param myPawn Player's pawn list
	 * @param name PLayer's name
	 */
	public HumanPlayer(ArrayList<Pawn> myPawn, String name, int playerNumber) {
		super(myPawn, name, playerNumber);
	}

	/**
	 * This class records the movement of the auto player
	 * @return An int tab with int [0] = x and int [1] = y
	 */
	public int[] newMove() {
		// TODO - implement HumanPlayer.newMove
		throw new UnsupportedOperationException();
	}

	/**
	 * Check if the move is true
	 * @return true if the move is allowed
	 */
	public boolean verifMove() {
		// TODO - implement HumanPlayer.verifMove
		throw new UnsupportedOperationException();
	}
}