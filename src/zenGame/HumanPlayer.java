package zenGame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * This class allows you to create a human player
 * @author LePors
 * @version 1.0
 */
public class HumanPlayer extends Player {

	/**
	 * Initialize the human player with his pawn list
	 * @param myPawn Player's pawn list
	 * @param name PLayer's name
	 */
	public HumanPlayer(ArrayList<Pawn> myPawn, String name, int playerNumber) {
		super(myPawn, name, playerNumber);
	}

	/**
	 * This class records the movement of the auto player
	 * @return An int tab with int [0] = x and int [1] = y
	 */
	public int[] newMove() {
		final int[] ret = new int[2];
		System.out.println("Au tour de "+this.name);
		boolean i = false;
		do {
				Scanner sc = new Scanner(System.in);
				System.out.println("Donnez votre coordonnées en x :");
				ret[0] = sc.nextInt();
				System.out.println("Donnez votre coordonnées en y :");
				ret[1] = sc.nextInt();
				if (ret[0] >= 0 && ret[0] < ZenGame.height && ret[1] >= 0 && ret[1] < ZenGame.width) {
					i = true;
				}
		} while (!i);
		return ret;
	}

	/**
	 * Check if the move is true
	 * @return true if the move is allowed
	 */
	public boolean verifMove() {
		boolean ret = true;



		return ret;
	}
}