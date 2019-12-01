package TicTacToe;

import java.awt.*;
import java.awt.event.*;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.IOException;
// import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Map;
import java.util.HashMap;

public class GridCell extends JPanel{

    Border normal = BorderFactory.createLineBorder(Color.BLACK);
    Border redBorder = BorderFactory.createLineBorder(Color.RED);
    Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
    Integer playerTurn;
    Boolean canClick;
    Map<Integer, CanvasImage> m;
    TicTacToe_Engine engine;
    int[] position;
    CanvasImage nought;
    CanvasImage cross;


    public GridCell(TicTacToe_Engine Engine, int[] Position){
        engine = Engine;
        position = Position;

        setBorder(normal);

        playerTurn = 0;

        cross = new CanvasImage(
                "C:/Users/tompr/OneDrive/coding/TicTacToe/tictactoe/build/TicTacToe/cross.gif"    
        );
        nought = new CanvasImage(
                "C:/Users/tompr/OneDrive/coding/TicTacToe/tictactoe/build/TicTacToe/nought.gif"
        );
        m = new HashMap<Integer, CanvasImage>();
        m.put(0, cross);
        m.put(1, nought);

        this.addMouseListener(new GridMouseListener());

        // BoardManager mgr = new BoardManager()
        // this.setLayout(mgr);
    }

    public void NewTurn(){
        engine.NewTurn();
    }

    public void addSymbol(){
        setBorder(normal);
        CanvasImage symbol = m.get(playerTurn);
        this.add(symbol);

        if(playerTurn == 0){
            engine.player1Pos.add(position);
        }else if (playerTurn == 1){
            engine.player2Pos.add(position);
        }
        
        MouseListener[] l = getMouseListeners();
        this.removeMouseListener(l[0]);
        NewTurn();
    }

    class GridMouseListener implements MouseListener{
        
        public void mouseClicked(MouseEvent e) {
            if(canClick){
                addSymbol();
            }
        }
        
        public void mouseEntered(MouseEvent e) {
            if(playerTurn==0){
                setBorder(redBorder);
            }else if(playerTurn == 1){
                setBorder(blueBorder);
            }
            canClick = true;
        }
        public void mouseExited(MouseEvent e) {
            java.awt.Point p = new java.awt.Point(e.getPoint());
            if(!getVisibleRect().contains(p)){
                canClick = false;
                setBorder(normal);
            }
        }

        public void mouseReleased(MouseEvent e){}

        public void mousePressed(MouseEvent e){}
    }

}