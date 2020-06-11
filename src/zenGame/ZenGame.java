package zenGame;

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

	/**
	 * Initialize the player name
	 * @param playerName The first player name
	 * @param playerName2 The second player name
	 */
	public ZenGame(String playerName, String playerName2) {
		this.askGameType();
		if(playerName != null && playerName2 != null){
			this.playerName = playerName;
			this.playerName2 = playerName2;
			pawnGame = new ArrayList<Pawn>();
			this.initializeMode();
			this.initializePawn();
			gamePlay = new GameManager(this.pawnGame, this.playerName, this.playerName2, this.mode);
		} else {
			System.err.println("Name must be initialized");
		}
	}

	/**
	 * Ask the player about the mode
	 */
	private void initializeMode(){
		Mode m = null;
		boolean loop = false;
		while(!loop) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez séléctionner le mode :\n" +
					"1 : HumainHumain \n" +
					"2 : HumainRobot");
			String str = sc.nextLine();

			if(str.equals("1") || str.equals("HumainHumain")){
				m = Mode.HumainHumain;
				System.out.println("Vous avez choisi le mode humain humain");
				loop = true;
			} else if(str.equals("2") || str.equals("HumainRobot")){
				System.out.println("Vous avez choisi le mode humain robot");
				m = Mode.HumainRobot;
				loop = true;
			} else {
				System.err.println("Mauvaise valeur recommencer :");
			}
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

	public void initializePawn(){

	}
}