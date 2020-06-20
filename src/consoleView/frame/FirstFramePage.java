package consoleView.frame;

import consoleView.GraphicGameMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * First frame page
 */
public class FirstFramePage extends JFrame {


    private JButton playButton;
    private JButton rulesButton;
    private JButton exitButton;
    private ImageIcon image;

    public FirstFramePage(){
        super("Zen L'Initiée");
        this.setSize(1200,800);
        this.setContentPane(new PanelFond());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.playButton = new JButton("JOUER");
        this.rulesButton = new JButton("REGLES");
        this.exitButton = new JButton("QUITTER");
        this.add(playButton);
        this.add(rulesButton);
        this.add(exitButton);



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(375, 375, 375)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rulesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(603, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(278, Short.MAX_VALUE)
                                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rulesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))
        );


    }

    public void setActionListener(ActionListener a){
        playButton.addActionListener(a);
        rulesButton.addActionListener(a);
        exitButton.addActionListener(a);
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getRulesButton() {
        return rulesButton;
    }
}
