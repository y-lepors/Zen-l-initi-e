package zenGame;

import consoleView.GraphicGameMenu;
import consoleView.IGameMenu;
import consoleView.PrintGameMenu;

import javax.swing.*;
import java.util.*;

/**
 * This method is used to choose the game mode and initialize variables about the game
 * @author LePors
 * @version 1.0
 */
public class ZenGame {

	private GameManager gamePlay;
	private Mode mode;
	private ArrayList<Pawn> pawnGame;
	private String playerName;
	private String playerName2;
	private GraphicType gameType;
	private IGameMenu gameMenu;
	protected Square[][] grid;
	public final static int width = 11;
	public final static int height = 11;

	/**
	 * Initialize the player name
	 * @param playerName The first player name
	 * @param playerName2 The second player name
	 */
	public ZenGame(String playerName, String playerName2) {

		if(playerName != null && playerName2 != null){
			this.playerName = playerName;
			this.playerName2 = playerName2;
			this.pawnGame = new ArrayList<Pawn>();
			this.initializePawn();
			this.initializeGrid();
			this.askGameType();
			if(this.gameType.equals(GraphicType.Console)){
				this.gameMenu = new PrintGameMenu(this.grid);
			} else if(this.gameType.equals(GraphicType.Graphic)){
				this.gameMenu = new GraphicGameMenu();
				GraphicGameMenu graphicGameMenu = new GraphicGameMenu();
			}
			gamePlay = new GameManager(this.pawnGame, this.playerName, this.playerName2, this.mode, this.gameMenu, this.grid);
		} else {
			System.err.println("Name must be initialized");
		}
	}


	/**
	 * Ask the user about the graphic type
	 * @return The graphic type to use
	 */
	public void askGameType() {

		Object[] type = {"Console", "Graphic"};
		int index = JOptionPane.showOptionDialog(null,
				"Quel mode de jeu ?",
				"Mode de jeu",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				new ImageIcon("./data/logo_Zen.png"), type, type[0]);
		if(index == 0){
			this.gameType = GraphicType.Console;
		} else {
			this.gameType = GraphicType.Graphic;
		}
		System.out.println(gameType);
	}

	/**
	 * Initialize every pawn
	 */
	public void initializePawn(){
		// WHITE PAWN
		pawnGame.add(new Pawn(0,0,Type.WHITE));
		pawnGame.add(new Pawn(0,5,Type.WHITE));
		pawnGame.add(new Pawn(2,7,Type.WHITE));
		pawnGame.add(new Pawn(2,3,Type.WHITE));
		pawnGame.add(new Pawn(4,1,Type.WHITE));
		pawnGame.add(new Pawn(6,1,Type.WHITE));
		pawnGame.add(new Pawn(8,3,Type.WHITE));
		pawnGame.add(new Pawn(10,5,Type.WHITE));
		pawnGame.add(new Pawn(8,7,Type.WHITE));
		pawnGame.add(new Pawn(6,9,Type.WHITE));
		pawnGame.add(new Pawn(4,9,Type.WHITE));
		pawnGame.add(new Pawn(10,10,Type.WHITE));

		//BLACK PAWN
		pawnGame.add(new Pawn(10,0,Type.BLACK));
		pawnGame.add(new Pawn(5,0,Type.BLACK));
		pawnGame.add(new Pawn(7,2,Type.BLACK));
		pawnGame.add(new Pawn(9,4,Type.BLACK));
		pawnGame.add(new Pawn(9,6,Type.BLACK));
		pawnGame.add(new Pawn(7,8,Type.BLACK));
		pawnGame.add(new Pawn(5,10,Type.BLACK));
		pawnGame.add(new Pawn(3,8,Type.BLACK));
		pawnGame.add(new Pawn(1,6,Type.BLACK));
		pawnGame.add(new Pawn(1,4,Type.BLACK));
		pawnGame.add(new Pawn(3,2,Type.BLACK));
		pawnGame.add(new Pawn(0,10,Type.BLACK));

		// ZEN PAWN
		pawnGame.add(new Pawn(5,5,Type.ZEN));
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
}