package zenGame;

import consoleView.IGameMenu;
import consoleView.PrintGameMenu;
import consoleView.frame.GameFrame;
import consoleView.listener.GameFrameListener;

import java.io.*;
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
	 Initialize every variables
	 * @param pawnGame The list of pawn
	 * @param playerName The first player name
	 * @param playerName2 The second player name
	 * @param gameMenu The gameMenu
	 * @param grid The grid
	 * @param mode The mode
	 * @param gameType The gameType
	 */
	public GameManager(ArrayList<Pawn> pawnGame, String playerName, String playerName2, IGameMenu gameMenu, Square[][] grid, Mode mode, GraphicType gameType) {
		this.grid = grid;
		this.gameMenu = gameMenu;
		this.mode = mode;
		this.gameType = gameType;
		if(pawnGame != null && playerName != null && playerName2 != null){
			this.pawnGame = pawnGame;
			if(this.mode == Mode.HumainHumain){
				this.firstPlayer = new HumanPlayer(pawnGame, playerName, this.playerNumber, gameType,this);
				this.playerNumber++;
				this.secondPlayer = new HumanPlayer(pawnGame, playerName2, this.playerNumber, gameType, this);
			} else if(this.mode == Mode.HumainRobot){
				this.firstPlayer = new HumanPlayer(pawnGame, playerName, this.playerNumber, gameType,this);
				this.playerNumber++;
				this.secondPlayer = new AutoPlayer(pawnGame, playerName2, this.playerNumber, gameType,this);
			}
			this.current = this.secondPlayer;
		}
		this.start();
	}

	/**
	 * This constructor is used to launch a save game
	 * @param path The path from file to load
	 */
	public GameManager(String path){
		this.loadGame(path);
	}

	/**
	 * This method display the grid
	 */
	public void displayTheGrid(){
		if(this.gameType.equals(GraphicType.Console)) {
			this.gameMenu.gamePage(this.grid, this);
		} else if (this.gameType.equals(GraphicType.Graphic)){
			this.gameMenu.gamePage(this.grid, this);
		}
	}


	/**
	 * This method start the game and make the loop that makes the game work
	 */
	public void start() {
		boolean loop = false;
		this.displayTheGrid();
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

	/**
	 * Save this object into a file.
	 * @param savePath The path of the file.
	 */
	public void saveGame(String savePath) {
		if (savePath != null && !savePath.isEmpty()) {
			try {
				FileOutputStream fileOut = new FileOutputStream(savePath);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);

				out.writeObject(this);

				out.close();
				fileOut.close();

				System.out.println("[*] Game saved in ".concat(savePath));
			} catch (IOException i) {
				i.printStackTrace();
			}
		}
	}

	/**
	 * Load the game object
	 * @param gamePath The file to load
	 * @return true if everything is good else false
	 */
	public boolean loadGame(String gamePath) {
		boolean loaded = false;

		if (gamePath != null && !gamePath.isEmpty()) {
			GameManager gameManager = null;
			try {
				FileInputStream fileIn = new FileInputStream(gamePath);
				ObjectInputStream in = new ObjectInputStream(fileIn);

				gameManager = (GameManager) in.readObject();

				in.close();
				fileIn.close();
			} catch (IOException err) {
				System.out.println("Error loadGame(gamePath): Cannot open the file at ".concat(gamePath));
			} catch (ClassNotFoundException err) {
				System.out.println("Error loadGame(gamePath): Error while extracting objects.");
			}

			if (gameManager != null) {
				this.setGameMenu(gameManager.getGameMenu());
				this.setGameType(gameManager.getGameType());
				this.setGrid(gameManager.getGrid());
				this.setMode(gameManager.getMode());
				this.setCurrent(gameManager.getCurrent());
				this.setFirstPlayer(gameManager.getFirstPlayer());
				this.setSecondPlayer(gameManager.getSecondPlayer());
				this.setPawnGame(gameManager.getPawnGame());
				this.setPlayerNumber(gameManager.getPlayerNumber());
				System.out.println("[*] Game loaded.");
				this.start();
				loaded = true;
			}
		}
		return loaded;
	}


	/**
	 * Get the mode
	 * @return The mode
	 */
	public Mode getMode() {
		return mode;
	}

	/**
	 * Get the game menu
	 * @return The game menu
	 */
	public IGameMenu getGameMenu() {
		return gameMenu;
	}

	/**
	 * Get the game type
	 * @return The game type
	 */
	public GraphicType getGameType() {
		return gameType;
	}

	/**
	 * Get the pawn Game
	 * @return The pawnGame
	 */
	public ArrayList<Pawn> getPawnGame() {
		return pawnGame;
	}

	/**
	 * Get the playerNumber
	 * @return The playerNumber
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * Get the current player
	 * @return The current player
	 */
	public Player getCurrent() {
		return current;
	}

	/**
	 * Get the first player
	 * @return The first player
	 */
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	/**
	 * Get the second player
	 * @return The second player
	 */
	public Player getSecondPlayer() {
		return secondPlayer;
	}

	/**
	 * Set the pawnGame
	 * @param pawnGame The pawnGame
	 */
	public void setPawnGame(ArrayList<Pawn> pawnGame) {
		this.pawnGame = pawnGame;
	}

	/**
	 * Set the mode
	 * @param mode The mode
	 */
	public void setMode(Mode mode) {
		this.mode = mode;
	}

	/**
	 * Set the gameType
	 * @param gameType The graphicType
	 */
	public void setGameType(GraphicType gameType) {
		this.gameType = gameType;
	}

	/**
	 * Set the grid
	 * @param grid The grid composed of Square
	 */
	public void setGrid(Square[][] grid) {
		this.grid = grid;
	}

	/**
	 * Set the game Menu
	 * @param gameMenu The game menu
	 */
	public void setGameMenu(IGameMenu gameMenu) {
		this.gameMenu = gameMenu;
	}

	/**
	 * Set the current player
	 * @param current The current player to set
	 */
	public void setCurrent(Player current) {
		this.current = current;
	}

	/**
	 * Set the first player
	 * @param firstPlayer The first player to set
	 */
	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	/**
	 * Set the second player
	 * @param secondPlayer The second player to set
	 */
	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}


	/**
	 * Set the player number
	 * @param playerNumber The player number to set
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
}