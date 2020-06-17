package consoleView;

import zenGame.Mode;
import zenGame.Square;

/**
 * This interface define the game menu
 */
public interface IGameMenu {
    public void printFirstPage();
    public Mode initializeMode();
    public void printSecondPage();
    public void gamePage(Square[][] grid);
    public void rulesPage();
    public void loadPage();
}
