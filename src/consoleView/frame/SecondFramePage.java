package consoleView.frame;

import consoleView.GraphicGameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Second frame page
 */
public class SecondFramePage extends JFrame {

    private JButton newGameButton;
    private JButton loadButton;
    private JButton backButton;

    /**
     * Initialize and create the second frame page with every components
     */
    public SecondFramePage(){
        super("Zen L'Initié");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setContentPane(new PanelFond());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.newGameButton = new JButton("NOUVELLE PARTIE");
        this.loadButton = new JButton("CHARGER");
        this.backButton = new JButton("RETOUR", new ImageIcon(this.getClass().getResource("/rss/backButton.png")));
        this.add(this.newGameButton);
        this.add(this.loadButton);
        this.add(this.backButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(375, 375, 375)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(603, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(278, Short.MAX_VALUE)
                                .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))
        );
    }

    /**
     * Set an action listener to react with the users interactions
     * @param a The action listener
     */
    public void setActionListener(ActionListener a){
        newGameButton.addActionListener(a);
        loadButton.addActionListener(a);
        backButton.addActionListener(a);
    }

    /**
     * Get the new game button
     * @return The new game JButton
     */
    public JButton getNewGameButton() {
        return newGameButton;
    }

    /**
     * Get the load button
     * @return The load JButton
     */
    public JButton getLoadButton() {
        return loadButton;
    }

    /**
     * Get the back button
     * @return The back JButton
     */
    public JButton getBackButton() {
        return backButton;
    }


}
