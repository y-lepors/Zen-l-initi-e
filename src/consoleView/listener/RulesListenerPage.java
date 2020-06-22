package consoleView.listener;

import consoleView.frame.FirstFramePage;
import consoleView.frame.RulesFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The rules page listener
 */
public class RulesListenerPage implements ActionListener {

    private RulesFrame r;
    private FirstFramePage m;

    /**
     * The constructor that initialize the frame and set the action listener
     * @param r Rules Frame
     */
    public RulesListenerPage(RulesFrame r){
        this.r = r;
        r.setActionListener(this);
    }


    /**
     * This method is used to react to the action from the user
     * @param e The captured action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == r.getBackButton()){
            r.dispose();
            m = new FirstFramePage();
            FirstListenerPage firstListenerPage = new FirstListenerPage(m);
        }
    }
}
