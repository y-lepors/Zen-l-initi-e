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

	/**
	 * Initialize the square
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Square(int x, int y) {
		if(x < GameManager.width && x >= 0 && y < GameManager.height && y >= 0){
			this.x = x;
			this.y = y;
			pawn = null;
		}
	}

	/**
	 * Set the pawn
	 * @param pawn The pawn to set
	 */
	public void setPawn(Pawn pawn) {
		this.pawn = pawn;
	}

	/**
	 * This method return true if the square is free
	 * @return true if the square is free
	 */
	public boolean isFree() {
		boolean ret = false;
		if(this.pawn != null){
			ret = true;
		}
		return ret;
	}
}