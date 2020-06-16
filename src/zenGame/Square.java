package zenGame;

/**
 * This class is used to create the square
 * @author LePors
 * @version 1.0
 */
public class Square {

	private int x;
	private int y;
	private Pawn pawn;
	private char charType;

	/**
	 * Initialize the square
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Square(int x, int y) {
		if(x < ZenGame.width && x >= 0 && y < ZenGame.height && y >= 0){
			this.x = x;
			this.y = y;
			this.pawn = null;
			this.charType = '.';
		}
	}

	/**
	 * Set the pawn
	 * @param pawn The pawn to set
	 */
	public void setPawn(Pawn pawn) {
		this.pawn = pawn;
		if(this.pawn.getType().equals(Type.ZEN)){
			this.charType = 'Z';
		} else if(this.pawn.getType().equals(Type.BLACK)){
			this.charType = 'N';
		} else if(this.pawn.getType().equals(Type.WHITE)){
			this.charType = 'B';
		} else if(this.pawn.getType().equals(null)) {
			this.charType = '.';
		}
	}

	/**
	 * This method return true if the square is free
	 * @return true if the square is free
	 */
	public boolean isFree() {
		boolean ret = true;
		if(this.pawn != null){
			ret = false;
		}
		return ret;
	}

	/**
	 * Get char type
	 * @return The char
	 */
	public char getCharType() {
		return charType;
	}

	/**
	 * Get the X coordinate
	 * @return The X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the y coordinate
	 * @return The X coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Get the pawn
	 * @return The pawn
	 */
	public Pawn getPawn() {
		return pawn;
	}
}