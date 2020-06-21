package consoleView.listener;

import consoleView.GraphicGameMenu;
import consoleView.frame.GameFrame;
import consoleView.frame.ModePage;
import zenGame.GraphicType;
import zenGame.Mode;
import zenGame.ZenGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeListenerPage implements ActionListener {

    private ModePage modePage;

    public ModeListenerPage(ModePage modePage){
        this.modePage = modePage;
        modePage.setActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == modePage.getHHButton()){
            modePage.dispose();
            ZenGame zenGame = new ZenGame("Yanis", "Enzo", Mode.HumainHumain, new GraphicGameMenu(), GraphicType.Graphic);
        } else if (e.getSource() == modePage.getHAButton()){
            modePage.dispose();
            ZenGame zenGame = new ZenGame("Yanis", "Enzo", Mode.HumainRobot, new GraphicGameMenu(), GraphicType.Graphic);
        }
    }
}
