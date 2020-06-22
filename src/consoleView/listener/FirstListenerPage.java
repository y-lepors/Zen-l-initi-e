package consoleView.listener;

import consoleView.frame.FirstFramePage;
import consoleView.frame.RulesFrame;
import consoleView.frame.SecondFramePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

/**
 * The first page listener
 */
public class FirstListenerPage implements ActionListener {

    FirstFramePage m;
    SecondFramePage s;
    RulesFrame r;

    /**
     * The constructor that initialize the frame and set the action listener
     * @param m The FirstFramePage
     */
    public FirstListenerPage(FirstFramePage m){
        this.m = m;
        m.setActionListener(this);

    }

    /**
     * This method is used to react to the action from the user
     * @param e The captured action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == m.getPlayButton()){
            m.dispose();
            s = new SecondFramePage();
            SecondListenerPage secondListenerPage = new SecondListenerPage(s);
        } else if (e.getSource() == m.getRulesButton()){
            m.dispose();
            r = new RulesFrame();
            RulesListenerPage rulesListenerPage = new RulesListenerPage(r);
        } else if (e.getSource() == m.getExitButton()){
            exit(0);
        }
    }
}
