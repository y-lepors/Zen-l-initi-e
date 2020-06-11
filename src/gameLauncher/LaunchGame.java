package gameLauncher;

import zenGame.ZenGame;

/**
 * This class is used to launch the game
 * @author LePors
 * @version 1.0
 */
public class LaunchGame {

	private GraphicType gameType;

	/**
	 * The entry points of the program
	 * @param args
	 */
	public static void main(String[] args) {
		ZenGame zenGame = new ZenGame("Yanis", "Enzo");
	}

	/**
	 * Ask the user about the graphic type
	 * @return The graphic type to use
	 */
	public GraphicType askGameType() {
		// TODO - implement LaunchGame.askGameType
		throw new UnsupportedOperationException();
	}

	/**
	 * Set game type
	 */
	public void setGameType(GraphicType gameType) {
		this.gameType = gameType;
	}
}