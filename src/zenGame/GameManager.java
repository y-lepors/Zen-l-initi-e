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
	 * @return An arrayList of every possible move
	 */
	public int[][] whichMove(int posX, int posY){
		int[][] ret = new int[8][2];
		Type colorPawn = this.grid[posX][posY].getPawn().getType();

		int horizontalMove = this.countPawnHorizontal(posX, posY);
		int verticalMove = this.countPawnVertical(posX, posY);
		int diagonalRightMove = this.countPawnRightDiagonal(posX, posY);
		int diagonalLeftMove = this.countPawnLeftDiagonal(posX, posY);

		// 8 different possibilities

		// UP
		if(upVerticalIsNotBlocked(posX, posY,verticalMove)){
			ret[0][0] = posX;
			ret[0][1] = posY+verticalMove;
		}

		// UP RIGHT DIAGONAL
		if(upRightIsNotBlocked(posX, posY, diagonalRightMove)){
			ret[1][0] = posX+diagonalRightMove;
			ret[1][1] = posY+diagonalRightMove;
		}

		// UP LEFT DIAGONAL

		// LEFT

		// RIGHT

		// DOWN
		if(downVerticalIsNotBlocked(posX, posY,verticalMove)){
			ret[5][0] = posX;
			ret[5][1] = posY-verticalMove;
		}

		// DOWN RIGHT DIAGONAL
		if(downRightIsNotBlocked(posX, posY, diagonalRightMove)){
			ret[6][0] = posX-diagonalRightMove;
			ret[6][1] = posY-diagonalRightMove;
		}
		// DOWN LEFT DIAGONAL

		return ret;
	}

	/**
	 * Return true if the vertical up is blocked by a pawn
	 * @param posX The x coordinate
	 * @param posY The y coordinate
	 * @param verticalMove The number of possible move
	 * @return true if the move is possible
	 */
	public boolean upVerticalIsNotBlocked(int posX, int posY, int verticalMove){
		boolean ret = false;
		Type otherType = this.otherType(posX, posY);
		if((posX) < 11 && (posY+verticalMove) < 11 ){
			if(this.grid[posX][posY+verticalMove].isFree() || this.grid[posX][posY+verticalMove].getPawn().getType().equals(otherType)){
				for(int i = 1 ; i < verticalMove ; i++){
					if(this.grid[posX][posY+i].getPawn().getType().equals(otherType)){
						ret = false;
						break;
					} else {
						ret = true;
					}
				}
			}
		}
		return ret;
	}

	/**
	 * Return true if the vertical down is blocked by a pawn
	 * @param posX The x coordinate
	 * @param posY The y coordinate
	 * @param verticalMove The number of possible move
	 * @return true if the move is possible
	 */
	public boolean downVerticalIsNotBlocked(int posX, int posY, int verticalMove){
		boolean ret = false;
		Type otherType = this.otherType(posX, posY);
		if((posX) < 11 && (posY-verticalMove) < 11 ){
			if(this.grid[posX][posY-verticalMove].isFree() || this.grid[posX][posY-verticalMove].getPawn().getType().equals(otherType)){
				for(int i = 1 ; i < verticalMove ; i++){
					if(this.grid[posX][posY-i].getPawn().getType().equals(otherType)){
						ret = false;
						break;
					} else {
						ret = true;
					}
				}
			}
		}
		return ret;
	}

	public boolean upRightIsNotBlocked(int posX, int posY, int diagonalRightMove){
		boolean ret = false;
		Type otherType = this.otherType(posX, posY);
		if((posX+diagonalRightMove) < 11 && (posY+diagonalRightMove) < 11 ){
			if(this.grid[posX+diagonalRightMove][posY+diagonalRightMove].isFree() || this.grid[posX+diagonalRightMove][posY+diagonalRightMove].getPawn().getType().equals(otherType)){
				for(int i = 1 ; i < diagonalRightMove ; i++){
					if(this.grid[posX+i][posY+i].getPawn().getType().equals(otherType)){
						ret = false;
						break;
					} else {
						ret = true;
					}
				}
			}
		}
		return ret;
	}

	public boolean downRightIsNotBlocked(int posX, int posY, int diagonalRightMove){
		boolean ret = false;
		Type otherType = this.otherType(posX, posY);
		if((posX-diagonalRightMove) < 11 && (posY-diagonalRightMove) < 11 ){
			if(this.grid[posX-diagonalRightMove][posY-diagonalRightMove].isFree() || this.grid[posX-diagonalRightMove][posY-diagonalRightMove].getPawn().getType().equals(otherType)){
				for(int i = 1 ; i < diagonalRightMove ; i++){
					if(this.grid[posX-i][posY-i].getPawn().getType().equals(otherType)){
						ret = false;
						break;
					} else {
						ret = true;
					}
				}
			}
		}
		return ret;
	}


	/**
	 * The averse type
	 * @param posX The x coordinate
	 * @param posY The y coordinate
	 * @return The averse type
	 */
	private Type otherType(int posX, int posY){
		Type ret = this.grid[posX][posY].getPawn().getType();
		if(ret.equals(Type.BLACK)){
			ret = Type.WHITE;
		} else if(ret.equals(Type.WHITE)){
			ret = Type.BLACK;
		} else if(ret.equals(Type.ZEN)){
			ret = this.current.myPawn.get(0).getType();
		}

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
			if(x-i >= 0 && y+i >=0){
				if(!this.grid[x-i][y+i].isFree()){
					ret++;
				}
			}
		}
		return ret;
	}

	/**
	 * Count number of pawn in horizontal direction
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return The number of pawn on this line
	 */
	private int countPawnHorizontal(int x, int y){
		int ret = 0;

		for(int i = 0 ; i < 11 ; i++){
			if(x + i < 11 && y < 11){
				if(!this.grid[x+i][y].isFree()){
					ret++;
				}
			}
			if(x - i >= 0 && y >= 0){
				if(!this.grid[x-i][y].isFree()){
					ret++;
				}
			}
		}
		return ret;
	}

	/**
	 * Count number of pawn in vertical direction
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return The number of pawn on this line
	 */
	private int countPawnVertical(int x, int y){
		int ret = 0;

		for(int i = 0 ; i < 11 ; i++){
			if(x < 11 && y + i < 11){
				if(!this.grid[x][y+i].isFree()){
					ret++;
				}
			}
			if(x >= 0 && y - i >= 0){
				if(!this.grid[x][y-i].isFree()){
					ret++;
				}
			}
		}
		return ret;
	}
}