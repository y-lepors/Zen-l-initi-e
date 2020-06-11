package zenGame;

/**
 * This class is used to create the square
 * @author LePors
 * @version 1.0
 */
public class Square {

	private boolean free;
	private int x;
	private int y;

	/**
	 * Initialize the square
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public Square(int x, int y) {
		if(x < GameManager.width && x >= 0 && y < GameManager.height && y >= 0){
			this.x = x;
			this.y = y;
			this.free = true;
		}
	}

	/**
	 * This method set the free to false
	 */
	public void setBusy() {
		this.free = false;
	}

	/**
	 * This method return true if the square is free
	 * @return true if the square is free
	 */
	public boolean isFree() {
		boolean ret = false;
		if(this.free){
			ret = true;
		}
		return ret;
	}

	/**
	 * Get the free
	 * @return true if is free
	 */
	public boolean getFree(){
		return this.free;
	}
}