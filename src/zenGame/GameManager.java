package zenGame;

import consoleView.IGameMenu;
import consoleView.PrintGameMenu;

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
	public int playerNumber = 0;
	private Mode mode;
	private IGameMenu gameMenu;


	/**
	 * Initialize every variables
	 * @param pawnGame The list of pawn
	 * @param playerName The first player name
	 * @param playerName2 The second player name
	 */
	public GameManager(ArrayList<Pawn> pawnGame, String playerName, String playerName2, IGameMenu gameMenu, Square[][] grid) {
		this.description();
		this.grid = grid;
		this.gameMenu = gameMenu;
		if(pawnGame != null && playerName != null && playerName2 != null){
			this.pawnGame = pawnGame;
			this.mode = gameMenu.initializeMode();
			if(this.mode == Mode.HumainHumain){
				this.firstPlayer = new HumanPlayer(pawnGame, playerName, this.playerNumber);
				this.playerNumber++;
				this.secondPlayer = new HumanPlayer(pawnGame, playerName2, this.playerNumber);
			} else if(this.mode == Mode.HumainRobot){
				this.firstPlayer = new HumanPlayer(pawnGame, playerName, this.playerNumber);
				this.playerNumber++;
				this.secondPlayer = new AutoPlayer(pawnGame, playerName2, this.playerNumber);
			}
			this.current = this.secondPlayer;
		}
		this.start();
	}

	/**
	 * This method display the grid
	 */
	public void displayTheGrid(){
		this.gameMenu.gamePage(this.grid);
	}


	/**
	 * This method start the game and make the loop that makes the game work
	 */
	public void start() {
		boolean loop = false;
		while(!loop) {
			this.changeCurrent();
			this.displayTheGrid();
			loop = haveWin(this.doMove(this.current.newMove(this.grid)));
			if(loop){
				System.out.println("Le gagnant est "+this.current.name);
				break;
			}
			this.changeCurrent();
			this.displayTheGrid();
			loop = haveWin(this.doMove(this.current.newMove(this.grid)));
			if(loop){
				System.out.println("Le gagnant est "+this.current.name);
				break;
			}
		}
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
	 * Do the move and change the pawn on the grid
	 * @param move The coordinate of pawn to move and where to move him
	 */
	public Pawn doMove(int[] move){
		this.grid[move[2]][move[3]].setPawn(this.grid[move[0]][move[1]].getPawn());
		this.grid[move[0]][move[1]].setToNull();

		// Set the good coordinate Pawn attributes
		this.grid[move[2]][move[3]].getPawn().setxOrigin(move[2]);
		this.grid[move[2]][move[3]].getPawn().setyOrigin(move[3]);

		return this.grid[move[2]][move[3]].getPawn();
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
	public boolean haveWin(Pawn pawnInspected) {
		Square[][] grid = this.grid.clone();
		boolean ret = false;

		if(pawnInspected.getxOrigin() < 10 && pawnInspected.getyOrigin() < 10) {
			if (!grid[pawnInspected.getxOrigin() + 1][pawnInspected.getyOrigin() + 1].isFree()) {
				if (grid[pawnInspected.getxOrigin() + 1][pawnInspected.getyOrigin() + 1].getPawn().getType().equals(pawnInspected.getType())) {
					ret = true;
					grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin()].setToNull();
					haveWin(grid[pawnInspected.getxOrigin() + 1][pawnInspected.getyOrigin() + 1].getPawn());
				}
			}
		}

		if(pawnInspected.getyOrigin() < 10) {
			if (!grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin() + 1].isFree()) {
				if (grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin() + 1].getPawn().getType().equals(pawnInspected.getType())) {
					ret = true;
					grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin()].setToNull();
					haveWin(grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin() + 1].getPawn());
				}
			}
		}

		if(pawnInspected.getxOrigin() > 0 && pawnInspected.getyOrigin() < 10) {
			if (!grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin() + 1].isFree()) {
				if (grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin() + 1].getPawn().getType().equals(pawnInspected.getType())) {
					ret = true;
					grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin()].setToNull();
					haveWin(grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin() + 1].getPawn());
				}
			}
		}

		if(pawnInspected.getxOrigin() > 0) {
			if (!grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin()].isFree()) {
				if (grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin()].getPawn().getType().equals(pawnInspected.getType())) {
					ret = true;
					grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin()].setToNull();
					haveWin(grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin()].getPawn());
				}
			}
		}

		if(pawnInspected.getxOrigin() < 10) {
			if (!grid[pawnInspected.getxOrigin() + 1][pawnInspected.getyOrigin()].isFree()) {
				if (grid[pawnInspected.getxOrigin() + 1][pawnInspected.getyOrigin()].getPawn().getType().equals(pawnInspected.getType())) {
					ret = true;
					grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin()].setToNull();
					haveWin(grid[pawnInspected.getxOrigin() + 1][pawnInspected.getyOrigin()].getPawn());
				}
			}
		}

		if(pawnInspected.getxOrigin() > 0 && pawnInspected.getyOrigin() > 0) {
			if (!grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin() - 1].isFree()) {
				if (grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin() - 1].getPawn().getType().equals(pawnInspected.getType())) {
					ret = true;
					grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin()].setToNull();
					haveWin(grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin() - 1].getPawn());
				}
			}
		}

		if(pawnInspected.getyOrigin() > 0) {
			if (!grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin() - 1].isFree()) {
				if (grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin() - 1].getPawn().getType().equals(pawnInspected.getType())) {
					ret = true;
					grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin()].setToNull();
					haveWin(grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin() - 1].getPawn());
				}
			}
		}

		if(pawnInspected.getxOrigin() < 10 && pawnInspected.getyOrigin() > 0) {
			if (!grid[pawnInspected.getxOrigin() + 1][pawnInspected.getyOrigin() - 1].isFree()) {
				if (grid[pawnInspected.getxOrigin() + 1][pawnInspected.getyOrigin() - 1].getPawn().getType().equals(pawnInspected.getType())) {
					ret = true;
					grid[pawnInspected.getxOrigin()][pawnInspected.getyOrigin()].setToNull();
					haveWin(grid[pawnInspected.getxOrigin() - 1][pawnInspected.getyOrigin() + 1].getPawn());
				}
			}
		}
		return ret;
	}

	/**
	 * Get the grid
	 * @return The grid composed of square
	 */
	public Square[][] getGrid() {
		return grid;
	}

}