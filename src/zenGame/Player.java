package zenGame;

import java.util.*;

/**
 * This class allows you to create a player
 * @author LePors
 * @version 1.0
 */
public abstract class Player {

	ArrayList<Pawn> myPawn;
	private Type myColor;
	protected String name;


	/**
	 * Initialize the player and his pawn list
	 * @param pawnGame List of pawn
	 * @param name Player's name
	 */
	public Player(ArrayList<Pawn> pawnGame, String name, int playerNumber) {
		if(name != null && pawnGame != null){
			this.name = name;
			this.myPawn = new ArrayList<Pawn>();
			for (Pawn p : pawnGame){
				if(playerNumber == 0){
					if(p.getType().equals(Type.WHITE)){
						this.myPawn.add(p);
						this.myColor = Type.WHITE;
					}
				} else if(playerNumber == 1){
					for (Pawn p2 : pawnGame){
						if(p2.getType().equals(Type.BLACK)){
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
	 */
	public abstract int[] newMove();

	/**
	 * Check the move
	 * @return true if the move is good
	 */
	public boolean verifMove() {
		// TODO - implement Player.verifMove
		throw new UnsupportedOperationException();
	}


}