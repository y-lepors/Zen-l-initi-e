package consoleView.frame;

import consoleView.GraphicGameMenu;
import zenGame.GameManager;
import zenGame.Square;
import zenGame.Type;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * The game frame
 */
public class GameFrame extends JFrame implements Serializable {

    private JPanel gridPanel;
    private Square[][] grid;
    private JButton[][] jButtons = new JButton[11][11];
    private JButton saveButton;

    /**
     * Initialize and create the game frame page with every components
     * @param grid The grid to display
     */
    public GameFrame(Square[][] grid) {
        this.grid = grid;
        this.setName("Zen L'Initié");
        this.setSize(1200,800);
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(ImageIO.read(new File("./data/background.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel contentPane = new JLabel(icon) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(getIcon() != null)
                    g.drawImage(
                            ((ImageIcon)getIcon()).getImage(), 0, 0,
                            getWidth(), getHeight(), null);
            }
        };

        this.setContentPane(contentPane);


        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saveButton = new JButton("Sauvegarder et quitter");


        this.gridPanel = new JPanel();


        gridPanel.setLayout(new java.awt.GridLayout(11, 11));


        monGroupLayout layout = new monGroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(47, 47, 47))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
        );

        for(int i = 0 ; i < 11; i++){
            for(int j = 0 ; j < 11 ; j++){
                if(grid[i][j].isFree()){
                    jButtons[i][j] = new JButton();
                    gridPanel.add(jButtons[i][j]);
                } else if (grid[i][j].getPawn().getType().equals(zenGame.Type.ZEN)){
                    jButtons[i][j] = new JButton("ZEN");
                    jButtons[i][j].setBackground(Color.RED);
                    gridPanel.add(jButtons[i][j]);
                } else if (grid[i][j].getPawn().getType().equals(zenGame.Type.WHITE)) {
                    jButtons[i][j] = new JButton("BLANC");
                    jButtons[i][j].setBackground(Color.WHITE);
                    gridPanel.add(jButtons[i][j]);
                } else if (grid[i][j].getPawn().getType().equals(zenGame.Type.BLACK)) {
                    jButtons[i][j] = new JButton("NOIR");
                    jButtons[i][j].setBackground(Color.BLACK);
                    gridPanel.add(jButtons[i][j]);
                }
            }
        }
    }

    /**
     * Set an action listener to react with the users interactions
     * @param a The action listener
     */
    public void setActionListener(ActionListener a){
        saveButton.addActionListener(a);
        for(int i = 0 ; i < 11; i++){
            for(int j = 0 ; j < 11 ; j++) {
                jButtons[i][j].addActionListener(a);
            }
        }
    }

    /**
     * Get the array of JButtons
     * @return The array of JButton
     */
    public JButton[][] getjButtons() {
        return jButtons;
    }

    /**
     * Get the saving button
     * @return The save button
     */
    public JButton getSaveButton() {
        return saveButton;
    }
}
