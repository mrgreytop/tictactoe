package TicTacToe;

import java.awt.*;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CanvasImage extends JLabel{
    
    Image pic;
    ImageIcon icon;
    String filepath;
    

    public CanvasImage(String f){
        filepath = f;

        try {
            InputStream is = new BufferedInputStream(new FileInputStream(
                    filepath));
            pic = ImageIO.read(is);
            icon  = new ImageIcon(pic);
            this.setIcon(icon);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // public static void main(String[] args){
    //     JFrame mainf = new JFrame();
    //     mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     JPanel pan = new JPanel();

    //     CanvasImage canv = new CanvasImage(
    //         "C:/Users/tompr/OneDrive/coding/TicTacToe/tictactoe/build/TicTacToe/nought.gif"
    //     );

    //     mainf.add(pan);
    //     pan.add(canv);
    //     // canv.paint();

    //     mainf.setSize(400,400);
    //     mainf.setVisible(true);
    // }
}