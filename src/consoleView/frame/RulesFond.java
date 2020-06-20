package consoleView.frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Display the Rules Frame
 */
public class RulesFond extends JPanel {

    Image image;

    /**
     * Initialize the panel
     */
    RulesFond(){
        try {
            image = ImageIO.read(new File("./data/rulesBackGround.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Draw the image on the panel
     * @param g The graphics
     */
    public void paintComponent(Graphics g){
        g.drawImage(image, 0,0,null);
    }
}
