package consoleView.frame;

import consoleView.GraphicGameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Mode frame page
 */
public class ModePage extends JFrame {

    private JButton hHButton;
    private JButton hAButton;

    /**
     * Initialize and create the mode frame page with every components
     */
    public ModePage(){
        super("Zen L'Initié");
        this.setSize(1200,800);
        this.setContentPane(new PanelFond());
        this.setLayout(new FlowLayout());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hHButton = new JButton("Humain vs Humain", new ImageIcon(this.getClass().getResource("/rss/HH.png")));
        hAButton = new JButton("Humain vs robot", new ImageIcon(this.getClass().getResource("/rss/ai.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(359, 359, 359)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hHButton, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(590, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(hHButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(212, Short.MAX_VALUE))
        );
    }

    /**
     * Set an action listener to react with the users interactions
     * @param a The action listener
     */
    public void setActionListener(ActionListener a){
        hHButton.addActionListener(a);
        hAButton.addActionListener(a);
    }

    /**
     * Get the HA button
     * @return The ha button
     */
    public JButton getHAButton() {
        return hAButton;
    }

    /**
     * Get the human human Button
     * @return The HH Button
     */
    public JButton getHHButton() {
        return hHButton;
    }
}
