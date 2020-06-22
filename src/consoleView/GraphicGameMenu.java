package consoleView;

import consoleView.frame.FirstFramePage;
import consoleView.frame.GameFrame;
import consoleView.frame.SecondFramePage;
import consoleView.listener.FirstListenerPage;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import zenGame.Mode;
import zenGame.Square;
import zenGame.ZenGame;

import javax.swing.*;

public class GraphicGameMenu implements IGameMenu {

    private Square[][] grid;
    private int nbX, nbY;
    public final static ImageIcon image = new ImageIcon("./data/logoVoid.png");

    public GraphicGameMenu(){
    }

    @Override
    public void printFirstPage() {
       FirstFramePage firstFramePage = new FirstFramePage();
       FirstListenerPage firstListenerPage = new FirstListenerPage(firstFramePage);
    }

    @Override
    public Mode initializeMode() {
        return Mode.HumainHumain;
    }

    @Override
    public void printSecondPage(){
        SecondFramePage secondFramePage = new SecondFramePage();
    }

    @Override
    public void gamePage(Square[][] grid) {
        GameFrame gameFrame = new GameFrame(grid);
    }


    @Override
    public void rulesPage() {

    }

    @Override
    public void loadPage() {

    }

    @Override
    public void endGamePage() {

    }

    @Override
    public int[] askCoordinate() {
        return new int[0];
    }
}
