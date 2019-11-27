package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class TicTacToe_Board extends JFrame{
    
    JPanel mainPane = new JPanel(new GridBagLayout());
    JPanel turnPane = new JPanel();
    JPanel gridPane = new JPanel(new GridBagLayout());
    public Map<int[], JButton> gridButtons = new LinkedHashMap<int[], JButton>();
    
    // public static void main(String[] args) {
    //     new TicTacToe_Board();
    // }
    
    public TicTacToe_Board(){
        super("TicTacToe");
        
        setBounds(400,400,400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container con = this.getContentPane();
        con.add(mainPane);
        
        GridBagConstraints c_top = new GridBagConstraints();
        GridBagConstraints c_bottom = new GridBagConstraints();
        c_top.gridx = 0;
        c_top.gridy = 0;
        c_top.anchor = GridBagConstraints.CENTER;
        c_top.weighty = 0.1;
        c_top.weightx = 1.0;

        c_bottom.gridx = 0;
        c_bottom.gridy = 1;
        c_bottom.fill = GridBagConstraints.BOTH;
        c_bottom.weighty = 0.9;
        c_bottom.weightx = 1.0;

        mainPane.add(turnPane, c_top);
        mainPane.add(gridPane, c_bottom);

        //add buttons to grid
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                
                Insets ins = new Insets(1,1,1,1);
                GridBagConstraints c = new GridBagConstraints(
                    i,j,1,1,1,1,
                    GridBagConstraints.CENTER,
                    GridBagConstraints.BOTH,
                    ins,
                    0,0
                );
                    
                // String label = String.format("Position: %d,%d",i,j);
                JButton b = new JButton();
                gridPane.add(b, c);

                int[] pos = {i,j};

                gridButtons.put(pos, b);
            }
        }

        setVisible(true);
    }

}