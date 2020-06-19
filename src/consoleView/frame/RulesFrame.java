package consoleView.frame;

import consoleView.GraphicGameMenu;

import javax.swing.*;
import java.awt.*;

public class RulesFrame extends JFrame {

    private JTextArea rulesText;

    public RulesFrame(){
        super("Zen L'Initiée");
        this.setSize(1200,800);
        this.setContentPane(new PanelFond());
        this.setLayout(new FlowLayout());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(rulesText);
        rulesText = new JTextArea("fhsuifh");

    }
}
