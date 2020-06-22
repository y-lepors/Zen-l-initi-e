package consoleView.frame;

import consoleView.GraphicGameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RulesFrame extends JFrame {

    private JButton backButton;

    /**
     * Initialize and construct the Rules frame
     */
    public RulesFrame(){
        super("Zen L'Initié");
        this.setSize(1200,800);
        this.setContentPane(new RulesFond());
        this.setLayout(new FlowLayout());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        backButton = new JButton("RETOUR",new ImageIcon(this.getClass().getResource("/rss/backButton.png")));


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(1238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(668, Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
        );


    }

    /**
     * Set action listener to the back button
     * @param a Action Listener
     */
    public void setActionListener(ActionListener a){
        this.backButton.addActionListener(a);
    }

    /**
     * Get the back button
     * @return The back JButton
     */
    public JButton getBackButton() {
        return backButton;
    }
}
