package zenGame;

import java.io.Serializable;

/**
 * This class is used to create a Pawn
 * @author LePors
 * @version 1.0
 */
public class Pawn implements Serializable {
	private Type type;
	private int xOrigin;
	private int yOrigin;
	private boolean isAlive;

	/**
	 * Initialize the pawn
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @param type The pawn color
	 */
	public Pawn(int x, int y, Type type) {
		if(x < ZenGame.width && x >= 0 && y < ZenGame.height && y >= 0 && type != null){
			this.xOrigin = x;
			this.yOrigin = y;
			this.type = type;
			this.isAlive = true;
		}
	}

	/**
	 * This method is used to change the coordinate of pawn
	 */
	public void newMove(int x, int y) {
		if(x < 11 && y < 11 && x >= 0 && x >= 0){
			this.xOrigin = x;
			this.yOrigin = y;
		}
	}

	/**
	 * This method is used to eliminate a pawn
	 */
	public void eliminatePawn() {
		this.isAlive = false;
	}

	/**
	 * Get the pawn type
	 * @return the pawn type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Get x origin
	 * @return The X origin
	 */
	public int getxOrigin() {
		return xOrigin;
	}

	/**
	 * Get the y origin
	 * @return The Y origin
	 */
	public int getyOrigin() {
		return yOrigin;
	}

	/**
	 * Set the x origin
	 * @param xOrigin The x coordinate
	 */
	public void setxOrigin(int xOrigin) {
		this.xOrigin = xOrigin;
	}

	/**
	 * Set the y origin
	 * @param yOrigin The y coordinate
	 */
	public void setyOrigin(int yOrigin) {
		this.yOrigin = yOrigin;
	}
}