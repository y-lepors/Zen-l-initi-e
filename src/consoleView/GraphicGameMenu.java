package consoleView;

import consoleView.frame.FirstFramePage;
import consoleView.frame.SecondFramePage;
import consoleView.listener.FirstListenerPage;
import zenGame.Mode;
import zenGame.Square;

import javax.swing.*;

public class GraphicGameMenu implements IGameMenu {

    private Square[][] grid;
    private int nbX, nbY;
    public final static ImageIcon image = new ImageIcon("./data/logoVoid.png");

    public GraphicGameMenu(Square[][] grid){
        this.grid = grid;
        this.nbX = grid.length;
        this.nbY = grid[0].length;
        this.printFirstPage();
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
}
