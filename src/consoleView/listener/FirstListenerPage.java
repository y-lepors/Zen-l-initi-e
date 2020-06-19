package consoleView.listener;

import consoleView.frame.FirstFramePage;
import consoleView.frame.RulesFrame;
import consoleView.frame.SecondFramePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class FirstListenerPage implements ActionListener {

    FirstFramePage m;
    SecondFramePage s;
    RulesFrame r;

    public FirstListenerPage(FirstFramePage m){
        this.m = m;
        m.setActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == m.getPlayButton()){
            m.dispose();
            s = new SecondFramePage();
            SecondListenerPage secondListenerPage = new SecondListenerPage(s);
        } else if (e.getSource() == m.getRulesButton()){
            m.dispose();
            r = new RulesFrame();
        } else if (e.getSource() == m.getExitButton()){
            exit(0);
        }
    }
}
