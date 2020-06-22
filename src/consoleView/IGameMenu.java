package consoleView;

import zenGame.GameManager;
import zenGame.Mode;
import zenGame.Square;

/**
 * This interface define the game menu
 * @author LePors
 * @version 1.0
 */
public interface IGameMenu {
    public void printFirstPage();
    public Mode initializeMode();
    public void printSecondPage();
    public void gamePage(Square[][] grid, GameManager gameManager);
    public void rulesPage();
    public void loadPage();
    public void endGamePage();
    public int[] askCoordinate();
}
