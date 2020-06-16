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
	public GameManager(ArrayList<Pawn> pawnGame, String playerName, String playerName2, Mode mode, IGameMenu gameMenu, Square[][] grid) {
		this.description();
		this.grid = grid;
		this.gameMenu = gameMenu;
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
		}
		this.displayTheGrid();
	}

	/**
	 * This method display the grid
	 */
	public void displayTheGrid(){
		this.gameMenu.gamePage();
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

	/**
	 * Get the grid
	 * @return The grid composed of square
	 */
	public Square[][] getGrid() {
		return grid;
	}

	/**
	 * Verif every possible move and return an ArrayList with every move
	 * @param posX The posX
	 * @param posY The posY
	 * @return A arrayList of every possible move
	 */
	public ArrayList<String> whichMove(int posX, int posY){
		ArrayList<String> ret = new ArrayList<String>();

		if(posX < 10 && posY < 10 && posX > 0 && posY > 0){
			if(this.grid[posX + 1][posY + 1].isFree()){
				ret.add((posX+1) + "," + (posY+1));
			} else if(this.grid[posX + 1][posY + 1].getPawn().equals(Type.BLACK)){
				ret.add((posX+1) + "," + (posY+1));
			} else if(this.grid[posX + 1][posY + 1].getPawn().equals(Type.WHITE)){

			}
			if (this.grid[posX + 1][posY].isFree()){
				ret.add((posX +1)+ ","+posY);
			}
			if(this.grid[posX][posY +1].isFree()) {
				ret.add(posX+","+(posY+1));
			}
			if(this.grid[posX - 1][posY - 1].isFree()){
				ret.add((posX-1)+","+(posY-1));
			}
			if(this.grid[posX][posY - 1].isFree()){
				ret.add(posX+","+(posY-1));
			}
			if(this.grid[posX - 1][posY].isFree()){
				ret.add((posX-1)+","+posY);
			}
			if(this.grid[posX + 1][posY - 1].isFree()){
				ret.add((posX+1)+","+(posY-1));
			}
			if(this.grid[posX - 1][posY + 1].isFree()){
				ret.add((posX-1)+","+(posY+1));
			}
		}

		else if(posX == 10 && posY < 10 && posY > 0){
			if(this.grid[posX - 1][posY - 1].isFree()){
				ret.add((posX-1)+","+(posY-1));
			}
			if(this.grid[posX][posY + 1].isFree()){
				ret.add((posX)+","+(posY+1));
			}
			if(this.grid[posX][posY - 1].isFree()){
				ret.add((posX)+","+(posY-1));
			}
			if(this.grid[posX - 1][posY].isFree()){
				ret.add((posX-1)+","+(posY));
			}
			if(this.grid[posX - 1][posY + 1].isFree()){
				ret.add((posX-1)+","+(posY+1));
			}
		}

		else if(posX == 0 && posY < 10 && posY > 0){
			if(this.grid[posX + 1][posY + 1].isFree()){
				ret.add((posX+1)+","+(posY+1));
			}
			if(this.grid[posX][posY + 1].isFree()){
				ret.add((posX)+","+(posY+1));
			}
			if(this.grid[posX][posY - 1].isFree()){
				ret.add((posX)+","+(posY-1));
			}
			if(this.grid[posX + 1][posY].isFree()){
				ret.add((posX+1)+","+(posY));
			}
			if(this.grid[posX + 1][posY - 1].isFree()){
				ret.add((posX+1)+","+(posY-1));
			}
		}

		else if(posY == 0 && posX < 10 && posX > 0){
			if(this.grid[posX + 1][posY + 1].isFree()){
				ret.add((posX+1)+","+(posY+1));
			}
			if(this.grid[posX][posY + 1].isFree()){
				ret.add((posX)+","+(posY+1));
			}
			if(this.grid[posX-1][posY + 1].isFree()){
				ret.add((posX-1)+","+(posY+1));
			}
			if(this.grid[posX + 1][posY].isFree()){
				ret.add((posX+1)+","+(posY));
			}
			if(this.grid[posX - 1][posY].isFree()){
				ret.add((posX-1)+","+(posY));
			}
		}

		else if(posY == 10 && posX < 10 && posX > 0){
			if(this.grid[posX + 1][posY - 1].isFree()){
				ret.add((posX+1)+","+(posY-1));
			}
			if(this.grid[posX][posY - 1].isFree()){
				ret.add((posX)+","+(posY-1));
			}
			if(this.grid[posX-1][posY - 1].isFree()){
				ret.add((posX-1)+","+(posY-1));
			}
			if(this.grid[posX + 1][posY].isFree()){
				ret.add((posX+1)+","+(posY));
			}
			if(this.grid[posX - 1][posY].isFree()){
				ret.add((posX-1)+","+(posY));
			}
		}

		 else if(posX == 0 && posY == 0){
			if(this.grid[posX + 1][posY + 1].isFree()){
				ret.add((posX+1)+","+(posY+1));
			}
			if(this.grid[posX + 1][posY].isFree()){
				ret.add((posX+1)+","+(posY));
			}
			if(this.grid[posX][posY + 1].isFree()){
				ret.add((posX)+","+(posY + 1));
			}
		}

		else if(posX == 10 && posY == 0){
			if(this.grid[posX - 1][posY + 1].isFree()){
				ret.add((posX-1)+","+(posY+1));
			}
			if(this.grid[posX - 1][posY].isFree()){
				ret.add((posX-1)+","+(posY));
			}
			if(this.grid[posX][posY + 1].isFree()){
				ret.add((posX)+","+(posY + 1));
			}
		}

		 else if(posX == 0 && posY == 10){
			if(this.grid[posX + 1][posY - 1].isFree()){
				ret.add((posX+1)+","+(posY-1));
			}
			if(this.grid[posX + 1][posY].isFree()){
				ret.add((posX+1)+","+(posY));
			}
			if(this.grid[posX][posY - 1].isFree()){
				ret.add((posX)+","+(posY - 1));
			}
		}

		else if(posX == 10 && posY == 10){
			if(this.grid[posX - 1][posY - 1].isFree()){
				ret.add((posX-1)+","+(posY-1));
			}
			if(this.grid[posX - 1][posY].isFree()){
				ret.add((posX-1)+","+(posY));
			}
			if(this.grid[posX][posY - 1].isFree()){
				ret.add((posX)+","+(posY - 1));
			}
		}

		return ret;
	}

	/**
	 * Calculated how many pawn are on the line choose
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return The number of pawn on this line
	 */
	public ArrayList<String> howManyPawnOnTheLine(int x, int y){
		ArrayList<String> ret = new ArrayList<String>();






		return ret;
	}

	/**
	 * Count the number of pawn from the left to right diagonal
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return The number of pawn on this diagonal
	 */
	private int countPawnRightDiagonal(int x, int y){
		int ret = 0;

		for(int i = 0 ; i < 11 ; i++){
			if(x+i < 11 && y+i < 11){
				if(!this.grid[x+i][y+i].isFree()){
					ret++;
				}
			}
		}

		for(int i = 10 ; i >= 0 ; i--){
			if(x-i >= 0 && y-i >=0){
				if(!this.grid[x-i][y-i].isFree()){
					ret++;
				}
			}
		}

		return ret;
	}

	/***
	 * Count the number of pawn from the right to left diagonal
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return The number of pawn on this diagonal
	 */
	private int countPawnLeftDiagonal(int x, int y){
		int ret = 0;

		for(int i = 0 ; i < 11 ; i++){
			if(x+i < 11 && y-i < 11){
				if(!this.grid[x+i][y-i].isFree()){
					ret++;
				}
			}
		}

		for(int i = 10 ; i >= 0 ; i--){
			if(x-i >= 0 && y+i >=0){
				if(!this.grid[x-i][y+i].isFree()){
					ret++;
				}
			}
		}

		return ret;
	}
}