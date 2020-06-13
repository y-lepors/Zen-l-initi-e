package consoleView;

import zenGame.Mode;

public interface IGameMenu {
    public void printFirstPage();
    public Mode initializeMode();
    public void printSecondPage();
    public void GamePage();
}
