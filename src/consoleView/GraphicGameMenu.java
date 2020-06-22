package consoleView;

import consoleView.frame.FirstFramePage;
import consoleView.frame.GameFrame;
import consoleView.frame.SecondFramePage;
import consoleView.listener.FirstListenerPage;
import consoleView.listener.GameFrameListener;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import zenGame.GameManager;
import zenGame.Mode;
import zenGame.Square;
import zenGame.ZenGame;

import javax.swing.*;
import java.io.Serializable;

/**
 * The graphic game menu manager
 */
public class GraphicGameMenu implements IGameMenu, Serializable {

    private Square[][] grid;
    private int nbX, nbY;
    public final static ImageIcon image = new ImageIcon(GraphicGameMenu.class.getResource("/rss/logoVoid.png"));
    private GameFrame gameFrame;
    private GameManager gameManager;

    /**
     * Initialize the graphicGameMenu
     */
    public GraphicGameMenu(){

    }

    /**
     * Used to display the first page
     */
    @Override
    public void printFirstPage() {
       FirstFramePage firstFramePage = new FirstFramePage();
       FirstListenerPage firstListenerPage = new FirstListenerPage(firstFramePage);
    }

    /**
     * Initialize the mode | BUT NOT USED
     * @return The mode
     */
    @Override
    public Mode initializeMode() {
        return Mode.HumainHumain;
    }

    /**
     * Used to display the secondFramePage | BUT NOT USED
     */
    @Override
    public void printSecondPage(){
        SecondFramePage secondFramePage = new SecondFramePage();
    }

    /**
     * Used to display the game page
     * @param grid The grid to display
     * @param gameManager The GameManager
     */
    @Override
    public void gamePage(Square[][] grid, GameManager gameManager) {
        this.gameManager = gameManager;
        this.grid = grid;
        if(this.gameFrame != null) {
            this.gameFrame.dispose();
        }
        this.gameFrame = new GameFrame(this.grid);
        this.gameFrame.repaint();
        GameFrameListener gameFrameListener = new GameFrameListener(gameFrame, this.gameManager,this.grid);
    }


    /**
     * Display rules page | BUT NOT USED
     */
    @Override
    public void rulesPage() {

    }

    /**
     * Display load page | BUT NOT USED
     */
    @Override
    public void loadPage() {

    }

    /**
     * Display endGamePage | BUT NOT USED
     */
    @Override
    public void endGamePage() {

    }

    /**
     * ASK COORDINATE | BUT NOT USED
     * @return An array with new coordinate
     */
    @Override
    public int[] askCoordinate() {
        return new int[0];
    }
}
