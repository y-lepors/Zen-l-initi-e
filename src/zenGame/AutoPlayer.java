package zenGame;

import java.util.ArrayList;

/**
 * This class allows you to create the auto player
 * @author LePors
 * @version 1.0
 */
public class AutoPlayer extends Player {

	/**
	 * Initialize the auto player
	 * @param myPawn The list of pawn
	 * @param name The name of the auto player
	 */
	public AutoPlayer(ArrayList<Pawn> myPawn, String name, int playerNumber) {
		super(myPawn, name, playerNumber);
	}

	/**
	 * This class records the movement of the auto player
	 * @return An int tab with int [0] = x and int [1] = y
	 */
	@Override
	public int[] newMove(Square[][] grid) {
		return new int[0];
	}



	/**
	 * Check if the move is true
	 * @return true if the move is allowed
	 */
	public boolean verifMove() {
		// TODO - implement AutoPlayer.verifMove
		throw new UnsupportedOperationException();
	}

}