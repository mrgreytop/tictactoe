package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Map;
import java.util.LinkedHashMap;

public class TicTacToe_Board extends JFrame{
    
    JPanel mainPane = new JPanel(new GridBagLayout());
    JPanel turnPane = new JPanel();
    JPanel gridPane = new JPanel(new GridBagLayout());
    Map<int[], GridCell> gridButtons = new LinkedHashMap<int[], GridCell>();

    JLabel turn;
    Color player1Color = Color.RED;
    Color player2Color = Color.BLUE;

    int playerTurn;
    
    TicTacToe_Engine engine;
    
    
    public TicTacToe_Board(TicTacToe_Engine Engine){
        super("TicTacToe");

        engine = Engine;
        
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
                GridCell b = new GridCell(engine);
                gridPane.add(b, c);

                int[] pos = {i,j};

                gridButtons.put(pos, b);
            }
        }
        turn = new JLabel("Player 1 turn");
        turn.setForeground(player1Color);

        turnPane.add(turn);
        
        setVisible(true);

        playerTurn = 0;
    }

    public void NewTurn(int currentPlayer){
        playerTurn = currentPlayer;

        if (currentPlayer == 1){
            turn.setText("Player 2 turn");
            turn.setForeground(player2Color);
        }else if (currentPlayer == 0){
            turn.setText("Player 1 turn");
            turn.setForeground(player1Color); 
        }

        
        for(GridCell g: gridButtons.values()){
            g.playerTurn = this.playerTurn;
        }

    }

    public void Tie(){
        turn.setText("It's a Tie!");
        turn.setForeground(Color.ORANGE);
    }
}