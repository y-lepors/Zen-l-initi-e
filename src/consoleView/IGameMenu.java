package consoleView;

import zenGame.Mode;

/**
 * This interface define the game menu
 */
public interface IGameMenu {
    public void printFirstPage();
    public Mode initializeMode();
    public void printSecondPage();
    public void gamePage();
    public void rulesPage();
    public void loadPage();
}
