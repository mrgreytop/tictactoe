package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import TicTacToe.TicTacToe_Engine;

import java.util.Map;
import java.util.HashMap;

public class GridCell extends JPanel{

    Border normal = BorderFactory.createLineBorder(Color.BLACK);
    Border redBorder = BorderFactory.createLineBorder(Color.RED);
    Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
    Integer playerTurn;
    Boolean canClick;
    Map<Integer, JLabel> m;
    TicTacToe_Engine engine;

    JLabel nought = new JLabel("Nought");
    JLabel cross = new JLabel("Cross");

    public GridCell(TicTacToe_Engine Engine){
        engine = Engine;

        setBorder(normal);
        playerTurn = 0;
        m = new HashMap<Integer, JLabel>();
        m.put(0, cross);
        m.put(1, nought);
        this.addMouseListener(new GridMouseListener());
    }

    public void NewTurn(){
        engine.NewTurn();
    }

    public void addSymbol(){
        setBorder(normal);
        JLabel symbol = m.get(playerTurn);
        this.add(symbol);

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