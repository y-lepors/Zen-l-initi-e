package consoleView.listener;

import consoleView.frame.FirstFramePage;
import consoleView.frame.ModePage;
import consoleView.frame.SecondFramePage;
import zenGame.GameManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

/**
 * The second listener page
 */
public class SecondListenerPage implements ActionListener {

    FirstFramePage m;
    SecondFramePage s;
    ModePage modePage;

    /**
     * The constructor that initialize the frame and set the action listener
     * @param s Second Page Frame
     */
    public SecondListenerPage(SecondFramePage s){
        this.s = s;
        s.setActionListener(this);

    }

    /**
     * This method is used to react to the action from the user
     * @param e The captured action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == s.getNewGameButton()){
            s.dispose();
            modePage = new ModePage();
            ModeListenerPage modeListenerPage = new ModeListenerPage(modePage);
        } else if (e.getSource() == s.getLoadButton()){
            this.loadGame();
            s.dispose();
            this.loadGame();
        } else if (e.getSource() == s.getBackButton()){
            s.dispose();
            m = new FirstFramePage();
            FirstListenerPage firstListenerPage = new FirstListenerPage(m);
        }
    }

    /**
     * Load the game
     */
    public void loadGame(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "bin file", "bin");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(s.getBackButton());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }
        GameManager gameManager = new GameManager("./data/saves/"+chooser.getSelectedFile().getName());
    }
}
