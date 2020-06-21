package consoleView.frame;

import consoleView.GraphicGameMenu;
import zenGame.Square;
import zenGame.Type;

import javax.swing.*;

public class GameFrame extends JFrame {

    private JPanel gridPanel;
    private Square[][] grid;

    public GameFrame(Square[][] grid) {
        this.grid = grid;
        this.setName("Zen L'Initiée");
        this.setSize(1200,800);
        this.setContentPane(new PanelFond());
        this.setIconImage(GraphicGameMenu.image.getImage());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.gridPanel = new JPanel();


        gridPanel.setLayout(new java.awt.GridLayout(11, 11));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(277, Short.MAX_VALUE)
                                .addComponent(gridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(47, 47, 47))
        );


        for(int i = 0 ; i < 11; i++){
            for(int j = 0 ; j < 11 ; j++){
                if(grid[i][j].isFree()){
                    gridPanel.add(new JButton("."));
                } else if (grid[i][j].getPawn().getType().equals(zenGame.Type.ZEN)){
                    gridPanel.add(new JButton("ZEN"));
                } else if (grid[i][j].getPawn().getType().equals(zenGame.Type.WHITE)) {
                    gridPanel.add(new JButton("BLANC"));
                } else if (grid[i][j].getPawn().getType().equals(zenGame.Type.BLACK)) {
                    gridPanel.add(new JButton("NOIR"));
                }
            }
        }
    }
}
