package consoleView.frame;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * This class is used to set a background on the menu frame
 * @author LePors
 */
public class PanelFond extends JPanel {
    Image image;

    /**
     * Initialize the panel
     */
    PanelFond(){
        try {
            image = ImageIO.read(new File("./data/background.png"));
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