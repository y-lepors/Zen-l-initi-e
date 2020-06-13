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

	/**
	 * Initialize the player name
	 * @param playerName The first player name
	 * @param playerName2 The second player name
	 */
	public ZenGame(String playerName, String playerName2) {
		this.askGameType();
		if(this.gameType.equals(GraphicType.Console)){
			this.gameMenu = new PrintGameMenu();
		} else if(this.gameType.equals(GraphicType.Graphic)){
			this.gameMenu = new GraphicGameMenu();
			GraphicGameMenu graphicGameMenu = new GraphicGameMenu();
		}
		if(playerName != null && playerName2 != null){
			this.playerName = playerName;
			this.playerName2 = playerName2;
			this.pawnGame = new ArrayList<Pawn>();
			this.initializePawn();
			gamePlay = new GameManager(this.pawnGame, this.playerName, this.playerName2, this.mode);
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
}