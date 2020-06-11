package zenGame;

import javax.swing.*;
import java.util.*;

/**
 * This class is used to manage the game
 * @author LePors
 * @version 1.0
 */
public class GameManager {

	private Player firstPlayer;
	private Player secondPlayer;
	private Player current;
	protected Square[][] grid;
	private ArrayList<Pawn> pawnGame;
	public final static int width = 11;
	public final static int height = 11;
	public int playerNumber = 0;
	private Mode mode;
	public static final String ANSI_CYAN = "\u001B[36m";

	/**
	 * Initialize every variables
	 * @param pawnGame The list of pawn
	 * @param playerName The first player name
	 * @param playerName2 The second player name
	 */
	public GameManager(ArrayList<Pawn> pawnGame, String playerName, String playerName2, Mode mode) {
		this.description();
		if(pawnGame != null && playerName != null && playerName2 != null && mode != null){
			this.pawnGame = pawnGame;
			this.mode = mode;
			if(this.mode.equals(Mode.HumainHumain)){
				this.firstPlayer = new HumanPlayer(pawnGame, playerName, this.playerNumber);
				this.playerNumber++;
				this.secondPlayer = new HumanPlayer(pawnGame, playerName2, this.playerNumber);
			} else if(this.mode.equals(Mode.HumainRobot)){
				this.firstPlayer = new HumanPlayer(pawnGame, playerName, this.playerNumber);
				this.playerNumber++;
				this.secondPlayer = new AutoPlayer(pawnGame, playerName2, this.playerNumber);
			}
			this.current = firstPlayer;
			this.initializeGrid();
		}
	}

	/**
	 * Initialize the grid composed of square
	 */
	public void initializeGrid() {
		this.grid = new Square[width][height];
		for(int i = 0 ; i < width ; i++){
			for(int j = 0 ; j < height ; j++){
				this.grid[i][j] = new Square(i,j);
			}
		}
	}



	/**
	 * Initialize the pawn placement at the start of the game
	 */
	public void initializePawnPlacement() {

	}

	/**
	 * This method start the game and make the loop that makes the game work
	 */
	public void start() {
		// TODO - implement GameManager.start
		throw new UnsupportedOperationException();
	}

	/**
	 * This method stop the game
	 */
	public void endOfGame() {
		// TODO - implement GameManager.endOfGame
		throw new UnsupportedOperationException();
	}

	/**
	 * Print the description of the configuration
	 * @return A string with de description
	 */
	public String description() {
		System.out.println(ANSI_CYAN + " ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|");
		return null;
	}

	/**
	 * Change the current player
	 */
	private void changeCurrent() {
		if(this.current.equals(this.firstPlayer)){
			this.current = this.secondPlayer;
		} else if(this.current.equals(this.secondPlayer)){
			this.current = this.firstPlayer;
		}
	}

	/**
	 * Save the game
	 * @param fileName The path to save
	 */
	public void gameSave(String fileName) {
		// TODO - implement GameManager.gameSave
		throw new UnsupportedOperationException();
	}

	/**
	 * Test if the player have win
	 * @return true if the player have win
	 */
	public boolean haveWin() {
		// TODO - implement GameManager.haveWin
		throw new UnsupportedOperationException();
	}
}