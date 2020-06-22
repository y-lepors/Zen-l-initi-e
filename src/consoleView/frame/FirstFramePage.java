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

    /**
     * Initialize and create the first frame page with every components
     */
    public FirstFramePage(){
        super("Zen L'Initié");
        this.setSize(1200,800);
        this.setContentPane(new PanelFond());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.playButton = new JButton("JOUER", new ImageIcon(this.getClass().getResource("/rss/playButton.png")));
        this.rulesButton = new JButton("REGLES", new ImageIcon(this.getClass().getResource("/rss/rulesButton.png")));
        this.exitButton = new JButton("QUITTER", new ImageIcon(this.getClass().getResource("/rss/exitButton.png")));
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

    /**
     * Set an action listener to react with the users interactions
     * @param a The action listener
     */
    public void setActionListener(ActionListener a){
        playButton.addActionListener(a);
        rulesButton.addActionListener(a);
        exitButton.addActionListener(a);
    }

    /**
     * Get the exit button
     * @return The exit button
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Get the play button
     * @return The play button
     */
    public JButton getPlayButton() {
        return playButton;
    }

    /**
     * Get the rules button
     * @return The rules button
     */
    public JButton getRulesButton() {
        return rulesButton;
    }
}
