package consoleView.listener;

import consoleView.frame.FirstFramePage;
import consoleView.frame.ModePage;
import consoleView.frame.SecondFramePage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class SecondListenerPage implements ActionListener {

    FirstFramePage m;
    SecondFramePage s;
    ModePage modePage;

    public SecondListenerPage(SecondFramePage s){
        this.s = s;
        s.setActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == s.getNewGameButton()){
            s.dispose();
            modePage = new ModePage();
            ModeListenerPage modeListenerPage = new ModeListenerPage(modePage);
        } else if (e.getSource() == s.getLoadButton()){
            s.dispose();
        } else if (e.getSource() == s.getBackButton()){
            s.dispose();
            m = new FirstFramePage();
            FirstListenerPage firstListenerPage = new FirstListenerPage(m);
        }
    }
}
