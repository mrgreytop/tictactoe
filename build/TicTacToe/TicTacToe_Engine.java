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

        player1Pos = new ArrayList<int[]>();
        player2Pos = new ArrayList<int[]>();

        playerTurn = 0; //0 is cross' turn; 1 is nought's turn
        
        WinConditions = new ArrayList<ArrayList<int[]>>();
        MakeWinCon();
        // printWinCond();
    }
    
    public void NewTurn(){
        numTurns++;
        Boolean win = CheckWin(playerTurn);

        if(win){
            board.Winner(playerTurn);
        }else{
            if(numTurns>=9){
                board.Tie();
            }else{
                playerTurn = 1 - playerTurn;
                board.NewTurn(playerTurn);
            }
        }

    }

    public Boolean CheckWin(Integer currentPlayer){
        ArrayList<int[]> Pos = new ArrayList<int[]>();
        if(currentPlayer == 0){
            Pos = player1Pos;
        }else if(currentPlayer == 1){
            Pos = player2Pos;
        }
        int count = 0;
        for(ArrayList<int[]> cond: WinConditions){
            count = 0;
            for(int[] p1: cond){
                for(int[] p2: Pos){
                    if(p1.equals(p2)){
                        count++;
                        if(count >=3){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    void MakeWinCon(){
        //horiztonals and verticals
        for(int j = 0; j<2; j++){
            for (int i = 0; i < 3; i++) {
                ArrayList<int[]> tmp = new ArrayList<int[]>();

                for(GridCell g: board.gridButtons){
                    if(g.position[j]==i){
                        tmp.add(g.position);
                    }
                }
                WinConditions.add(tmp);
            }   
        }
        //diagonals

        ArrayList<int[]> diag1 = new ArrayList<int[]>();
        ArrayList<int[]> diag2 = new ArrayList<int[]>();

        for (GridCell g : board.gridButtons) {
            if(g.position[0] == g.position[1]){
                diag1.add(g.position);
            }
            if(g.position[0]+g.position[1] == 2){
                diag2.add(g.position);
            }
        }
        WinConditions.add(diag1);
        WinConditions.add(diag2);
    }

    void printWinCond(){
        for(ArrayList<int[]> a: WinConditions){
            int[][] b = new int[a.size()][2];
            b = a.toArray(b);
            String msg = Arrays.deepToString(b);
            System.out.println(msg);
        }
    }
}