package consoleView.frame;

import consoleView.GraphicGameMenu;

import javax.swing.*;
import java.awt.*;

public class ModePage extends JFrame {

    private JButton HHButton;
    private JButton HAButton;

    public ModePage(){
        super("Zen L'Initiée");
        this.setSize(1200,800);
        this.setContentPane(new PanelFond());
        this.setLayout(new FlowLayout());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
