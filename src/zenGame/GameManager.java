package zenGame;

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
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				this.grid[i][j] = new Square(i, j);
			}
		}
		// WHITE PAWN
		this.grid[0][0].setPawn(pawnGame.get(0));
		this.grid[0][5].setPawn(pawnGame.get(1));
		this.grid[2][7].setPawn(pawnGame.get(2));
		this.grid[2][3].setPawn(pawnGame.get(3));
		this.grid[4][1].setPawn(pawnGame.get(4));
		this.grid[6][1].setPawn(pawnGame.get(5));
		this.grid[8][3].setPawn(pawnGame.get(6));
		this.grid[10][5].setPawn(pawnGame.get(7));
		this.grid[8][7].setPawn(pawnGame.get(8));
		this.grid[6][9].setPawn(pawnGame.get(9));
		this.grid[4][9].setPawn(pawnGame.get(10));
		this.grid[10][10].setPawn(pawnGame.get(11));

		// BLACK PAWN
		this.grid[10][0].setPawn(pawnGame.get(12));
		this.grid[5][0].setPawn(pawnGame.get(13));
		this.grid[7][2].setPawn(pawnGame.get(14));
		this.grid[9][4].setPawn(pawnGame.get(15));
		this.grid[9][6].setPawn(pawnGame.get(16));
		this.grid[7][8].setPawn(pawnGame.get(17));
		this.grid[5][10].setPawn(pawnGame.get(18));
		this.grid[3][8].setPawn(pawnGame.get(19));
		this.grid[1][6].setPawn(pawnGame.get(20));
		this.grid[1][4].setPawn(pawnGame.get(21));
		this.grid[3][2].setPawn(pawnGame.get(22));
		this.grid[0][10].setPawn(pawnGame.get(23));

		// ZEN PAWN
		this.grid[5][5].setPawn(pawnGame.get(24));

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