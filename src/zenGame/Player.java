package zenGame;

import javax.swing.*;
import java.io.Serializable;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

/**
 * This class allows you to create a player
 * @author LePors
 * @version 1.0
 */
public abstract class Player implements Serializable {

	ArrayList<Pawn> myPawn;
	private Type myColor;
	protected String name;
	protected GraphicType gameType;
	private GameManager gameManager;
	private Square[][] grid;


	/**
	 * Initialize the player and his pawn list
	 * @param pawnGame The pawnGame list
	 * @param name The player name
	 * @param playerNumber The player Number
	 * @param gameType The gameType
	 * @param gameManager The gameManager
	 */
	public Player(ArrayList<Pawn> pawnGame, String name, int playerNumber, GraphicType gameType, GameManager gameManager) {
		this.gameManager = gameManager;
		this.gameType = gameType;
		if (name != null && pawnGame != null) {
			this.name = name;
			this.myPawn = new ArrayList<Pawn>();
			for (Pawn p : pawnGame) {
				if (playerNumber == 0) {
					if (p.getType().equals(Type.WHITE) || p.getType().equals(Type.ZEN)) {
						this.myPawn.add(p);
						this.myColor = Type.WHITE;
					}
				} else if (playerNumber == 1) {
					for (Pawn p2 : pawnGame) {
						if (p2.getType().equals(Type.BLACK) || p.getType().equals(Type.ZEN)) {
							this.myPawn.add(p2);
							this.myColor = Type.BLACK;
						}
					}
				}
			}
		}
	}

	/**
	 * {abstract}
	 * @return An array composed of coordinate
	 * @param grid The grid
	 */
	public abstract int[] newMove(Square[][] grid);

	/**
	 * Get the player's color
	 *
	 * @return The player's color
	 */
	public Type getMyColor() {
		return myColor;
	}

	/**
	 * Eliminate a pawn in current pawn list
	 *
	 * @param pawn The pawn to eliminate from list
	 */
	public void eliminateAPawn(Pawn pawn) {
		this.myPawn.remove(pawn);
	}

	public int[] askCoordinate() {
		int[] ret = new int[2];
		String s;
		boolean i = false;

		try {
			while (!i) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Donnez votre coordonnées en y :");
				s = sc.nextLine();
				if (s.equals("sq")) {
					System.out.println("Donnez le nom du fichier de sauvegarde :");
					s = sc.nextLine();
					this.gameManager.saveGame("./data/saves/" + s + ".bin");
					exit(0);
				} else {
					ret[0] = parseInt(s);
				}
				System.out.println("Donnez votre coordonnées en x :");
				s = sc.nextLine();
				if (s.equals("sq")) {

					exit(0);
				} else {
					ret[1] = parseInt(s);
				}
				if (ret[0] >= 0 && ret[0] < 11 && ret[1] >= 0 && ret[1] < 11) {
					i = true;
				}
			}
		} catch (Exception ex) {
		}
		return ret;
	}

	/**
	 * Ask the coordinate with JOptionPane
	 * @return An array with the coordinate
	 */
	public int[] graphicAskCoordinate() {
		int[] ret = new int[2];
		boolean stop = false;
		boolean i = false;
		while (!i) {
			String s = (JOptionPane.showInputDialog("Donnez votre coordonnées en y"));
			ret[0] = parseInt(s);
			ret[1] = parseInt(JOptionPane.showInputDialog("Donnez votre coordonnées en x"));
			if (ret[0] >= 0 && ret[0] < 11 && ret[1] >= 0 && ret[1] < 11) {
				i = true;
			}
		}


		return ret;
	}

}