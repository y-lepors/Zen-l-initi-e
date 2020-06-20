package consoleView.frame;

import consoleView.GraphicGameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModePage extends JFrame {

    private JButton hHButton;
    private JButton hAButton;

    public ModePage(){
        super("Zen L'Initiée");
        this.setSize(1200,800);
        this.setContentPane(new PanelFond());
        this.setLayout(new FlowLayout());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hHButton = new JButton("Humain vs Humain", new ImageIcon("./data/HH.png"));
        hAButton = new JButton("Humain vs robot", new ImageIcon("./data/ai.png"));

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

    public void setActionListener(ActionListener a){
        hHButton.addActionListener(a);
        hAButton.addActionListener(a);
    }

    public JButton getHAButton() {
        return hAButton;
    }

    public JButton getHHButton() {
        return hHButton;
    }
}
