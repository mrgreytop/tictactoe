package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;



public class TicTacToe_Engine{

    ArrayList<String> players;

    TicTacToe_Board board;
    int playerTurn;
    int numTurns;

    ArrayList<int[]> player1Pos;
    ArrayList<int[]> player2Pos;

    ArrayList<ArrayList<int[]>> WinConditions;

    public static void main(String[] args){
        new TicTacToe_Engine();
        
    }

    public TicTacToe_Engine(){
        board = new TicTacToe_Board(this);

        players = new ArrayList<String>();
        player.add("crosses");
        player.add("noughts");
        placedSymbols = new LinkedHashMap<int[], String>();

        playerTurn = 0; //0 is cross' turn; 1 is nought's turn
        
        WinConditions = new ArrayList<ArrayList<int[]>>();
        MakeWinCon();
    }
    
    public void NewTurn(){
        numTurns++;
        if(numTurns>=9){
            board.Tie();
        }else{
            playerTurn = 1 - playerTurn;
            board.NewTurn(playerTurn);
        }
    }

    public Boolean CheckWin(Integer currentPlayer){
        if(currentPlayer == 0){
            ArrayList<int[]> Pos = ArrayList<int[]> player1Pos;
        }else if(currentPlayer == 1){
            ArrayList<int[]> Pos = ArrayList<int[]> player2Pos;
        }

        for(ArrayList<int[]> win: WinConditions){
            
            for(int[] pos : Pos){

            }
        }
        
    }

    void MakeWinCon(){
        //horiztonals and verticals
        for(int j = 0; j<2; j++){
            for (int i = 0; i < 3; i++) {
                ArrayList<int[]> tmp = new ArrayList<int[]>();

                for(int[] pos: board.gridButtons.keySet()){
                    if(pos[j]==i){
                        tmp.add(pos);
                    }
                }
                WinConditions.add(tmp);
            }   
        }
        //diagonals

        for(int[] pos: board.gridButtons.keySet()){
            ArrayList<int[]> diag1 = new ArrayList<int[]>();
            ArrayList<int[]> diag2 = new ArrayList<int[]>();
            if(pos[0] == pos[1]){
                diag1.add(pos);
            }
            if(pos[0]+pos[1] == 2){
                diag2.add(pos);
            }
        }
        WinConditions.add(diag1);
        WinConditions.add(diag2);
    }
}