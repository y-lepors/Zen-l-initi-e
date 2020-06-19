package consoleView.listener;

import consoleView.frame.FirstFramePage;
import consoleView.frame.RulesFrame;
import consoleView.frame.SecondFramePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class SecondListenerPage implements ActionListener {

    FirstFramePage m;
    SecondFramePage s;
    RulesFrame r;

    public SecondListenerPage(SecondFramePage s){
        this.s = s;
        s.setActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == s.getNewGameButton()){
            s.dispose();
            s = new SecondFramePage();
        } else if (e.getSource() == s.getLoadButton()){
            m.setVisible(false);
            r = new RulesFrame();
        } else if (e.getSource() == s.getBackButton()){
            s.dispose();
            m = new FirstFramePage();
            FirstListenerPage firstListenerPage = new FirstListenerPage(m);
        }
    }
}
