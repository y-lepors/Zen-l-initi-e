package consoleView.listener;

import consoleView.frame.FirstFramePage;
import consoleView.frame.RulesFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesListenerPage implements ActionListener {

    private RulesFrame r;
    private FirstFramePage m;

    public RulesListenerPage(RulesFrame r){
        this.r = r;
        r.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == r.getBackButton()){
            r.dispose();
            m = new FirstFramePage();
            FirstListenerPage firstListenerPage = new FirstListenerPage(m);
        }
    }
}
