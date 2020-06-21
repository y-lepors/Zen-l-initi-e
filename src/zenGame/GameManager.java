package zenGame;

import consoleView.IGameMenu;
import consoleView.PrintGameMenu;
import consoleView.frame.GameFrame;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * This class is used to manage the game
 * @author LePors
 * @version 1.0
 */
public class GameManager implements Serializable {

	private Player firstPlayer;
	private Player secondPlayer;
	private Player current;
	protected Square[][] grid;
	private ArrayList<Pawn> pawnGame;
	public int playerNumber = 0;
	private Mode mode;
	private IGameMenu gameMenu;
	ArrayList<Pawn> pawnList;
	ArrayList<Pawn> pawnListWinner;
	ArrayList<Pawn> winnerList;
	private GraphicType gameType;


	/**
	 * Initialize every variables
	 * @param pawnGame The list of pawn
	 * @param playerName The first player name
	 * @param playerName2 The second player name
	 */
	public GameManager(ArrayList<Pawn> pawnGame, String playerName, String playerName2, IGameMenu gameMenu, Square[][] grid, Mode mode, GraphicType gameType) {
		this.grid = grid;
		this.gameMenu = gameMenu;
		this.mode = mode;
		this.gameType = gameType;
		if(pawnGame != null && playerName != null && playerName2 != null){
			this.pawnGame = pawnGame;
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
		if(this.gameType.equals(GraphicType.Console)) {
			this.gameMenu.gamePage(this.grid);
		} else if (this.gameType.equals(GraphicType.Graphic)){
			//GameFrame gameFrame = new GameFrame(this.grid);
		}
	}


	/**
	 * This method start the game and make the loop that makes the game work
	 */
	public void start() {
		boolean loop = false;
		while(!loop) {
			this.changeCurrent();
			this.displayTheGrid();
			this.doMove(this.current.newMove(this.grid));
			loop = this.haveWin();
			if(loop){
				System.out.println("Le gagnant est : "+this.current.name);
				break;
			}
			this.changeCurrent();
			this.displayTheGrid();
			this.doMove(this.current.newMove(this.grid));
			loop = this.haveWin();
			if(loop){
				System.out.println("Le gagnant est : "+this.current.name);
				break;
			}
		}
		this.endOfGame();
	}

	/**
	 * This method stop the game
	 */
	public void endOfGame() {
		this.gameMenu.endGamePage();
	}

	/**
	 * Do the move and change the pawn on the grid
	 * @param move The coordinate of pawn to move and where to move him
	 */
	public void doMove(int[] move){

		if(this.grid[move[2]][move[3]].isFree()) {
			this.grid[move[2]][move[3]].setPawn(this.grid[move[0]][move[1]].getPawn());
			this.grid[move[0]][move[1]].setToNull();
		} else if(!this.grid[move[2]][move[3]].isFree()) {
			if(this.grid[move[2]][move[3]].getPawn().getType().equals(Type.ZEN)) {
				this.pawnGame.remove(this.grid[move[2]][move[3]].getPawn());
				this.firstPlayer.myPawn.remove(this.grid[move[2]][move[3]].getPawn());
				this.secondPlayer.myPawn.remove(this.grid[move[2]][move[3]].getPawn());
			} else if(this.grid[move[2]][move[3]].getPawn().getType().equals(Type.WHITE)){
				this.pawnGame.remove(this.grid[move[2]][move[3]].getPawn());
				this.firstPlayer.myPawn.remove(this.grid[move[2]][move[3]].getPawn());
			} else if (this.grid[move[2]][move[3]].getPawn().getType().equals(Type.BLACK)){
				this.pawnGame.remove(this.grid[move[2]][move[3]].getPawn());
				this.secondPlayer.myPawn.remove(this.grid[move[2]][move[3]].getPawn());
			}

			this.grid[move[2]][move[3]].setPawn(this.grid[move[0]][move[1]].getPawn());
			this.grid[move[0]][move[1]].setToNull();
		}


		// Set the good coordinate Pawn attributes
		this.grid[move[2]][move[3]].getPawn().setxOrigin(move[2]);
		this.grid[move[2]][move[3]].getPawn().setyOrigin(move[3]);
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
	 * Get the grid
	 * @return The grid composed of square
	 */
	public Square[][] getGrid() {
		return grid;
	}

	/**
	 * Check if a player have win
	 * @return True if a player have win
	 */
	public boolean haveWin(){
		this.pawnList = new ArrayList<>();

		this.pawnListWinner = this.current.myPawn;

		pawnList.addAll(pawnListWinner);

		this.winnerList = new ArrayList<>();
		return haveWin(pawnList.get(1).getxOrigin(), pawnList.get(1).getyOrigin());
	}

	/**
	 * Check if a player have win with the coordinate of pawn to check
	 * @param posX The x coordinate of pawn to check
	 * @param posY The y coordinate of pawn to check
	 * @return true if a player win
	 */
	public boolean haveWin(int posX, int posY){
		boolean ret = false;

		int[][] listCase = pawnSideWin(posX, posY);
		for(int i = 0 ; i < listCase.length ; i++){
			for(Pawn p : this.pawnList){
				if(listCase[i][0] == p.getxOrigin() && listCase[i][1] == p.getyOrigin()){
					if(!this.winnerList.contains(p)){
						this.winnerList.add(p);
						haveWin(p.getxOrigin(), p.getyOrigin());
					}
				}
			}
		}
		if(this.winnerList.size() == this.pawnList.size()){
			ret = true;
		}
		return ret;
	}

	/**
	 * Put in array every possible side win
	 * @param x The x coordinate from pawn to analyse
	 * @param y The y coordinate from pawn to analyse
	 * @return An array with every possibilities
	 */
	public int[][] pawnSideWin(int x, int y) {

		int[][] listCase = null ;

		if (x == 0 && y == 0) { //Coin haut gauche
			listCase = new int[][]{{x + 1, y}, {x + 1, y + 1}, {x, y + 1}};
		} else if (x == 10 && y == 0) { //Coin haut droite
			listCase = new int[][]{{x - 1, y}, {x, y + 1}, {x - 1, y + 1}};
		} else if (x == 0 && y == 10) { //Coin bas gauche
			listCase = new int[][]{{x + 1, y - 1}, {x + 1, y}, {x, y - 1}};
		} else if (x == 10 && y == 10) { //Coin bas droite
			listCase = new int[][]{{x, y - 1}, {x - 1, y - 1}, {x - 1, y}};
		} else if (x == 0 && (y > 0 && y < 10)) { //Colonne gauche
			listCase = new int[][]{{x, y - 1}, {x + 1, y - 1}, {x + 1, y},{x, y + 1}, {x + 1, y + 1}};
		} else if (x == 10 && (y > 0 && y < 10)) {    //Colonne droite
			listCase = new int[][]{{x, y - 1}, {x - 1, y - 1}, {x - 1, y},{x, y + 1}, {x - 1, y + 1}};
		} else if ((x > 0 && x < 10) && y == 0) {     //Ligne du haut
			listCase = new int[][]{{x - 1, y}, {x - 1, y + 1}, {x, y + 1},{x + 1, y}, {x + 1, y + 1}};
		} else if ((x > 0 && x < 10) && y == 10) { //Ligne du bas
			listCase = new int[][]{{x, y-1}, {x - 1, y}, {x - 1, y - 1},{x + 1, y}, {x + 1, y - 1}};
		} else if ((x > 0 && x < 10) && (y > 0 && y < 10)) {
			listCase = new int[][]{{x, y-1}, {x - 1, y - 1}, {x+1, y - 1},{x - 1, y}, {x + 1, y},{x,y+1},{x-1,y+1},{x+1,y+1}};
		}
		return listCase;
	}


}