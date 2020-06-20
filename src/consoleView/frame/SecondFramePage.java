package consoleView.frame;

import consoleView.GraphicGameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SecondFramePage extends JFrame {

    private JButton newGameButton;
    private JButton loadButton;
    private JButton backButton;

    public SecondFramePage(){
        super("Zen L'Initiée");
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setContentPane(new PanelFond());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.newGameButton = new JButton("NOUVELLE PARTIE");
        this.loadButton = new JButton("CHARGER");
        this.backButton = new JButton("RETOUR", new ImageIcon("./data/backButton.png"));
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

    public void setActionListener(ActionListener a){
        newGameButton.addActionListener(a);
        loadButton.addActionListener(a);
        backButton.addActionListener(a);
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getBackButton() {
        return backButton;
    }


}
