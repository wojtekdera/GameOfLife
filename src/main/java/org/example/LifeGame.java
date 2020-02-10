package org.example;

import lombok.Data;

@Data
public class LifeGame {
    private int row;
    private int column;
    private Cell[][] board;

    public LifeGame(int row, int column) {
        this.row = row;
        this.column = column;
        board = new Cell[row][column];
    }
    public void showBoard(){

        for (Cell row[] : board){
            for (Cell element : row){
                System.out.print(element.getStateChar() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int neighbors(int x, int y){ //count neighbors of the cell
        int neightbors = 0;

        for (int i = x-1 ; i <= x+1 ; i++){
            if (i < 0 || i > row-1) continue;    //continue if the range is exceeded
            for (int j = y-1 ; j <= y+1 ; j++){
                if(j < 0 || j > column-1 || (i==x && j==y)) continue;   //continue if the range is exceeded
                if(board[i][j].isState()) neightbors++;   //if neighbor is alive add one
            }
        }
        return neightbors;
    }

    public void showNeighborsBoard() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(neighbors(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void nextGeneration(){
        Cell[][] tempBoard = new Cell[row][column];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if((neighbors(i, j) > 3 ) || (neighbors(i, j) < 2 ))
                {
                    tempBoard[i][j] = new Cell(false);
                }
                else if((neighbors(i, j) == 2) || (neighbors(i, j) == 3))
                {
                    tempBoard[i][j] = new Cell(true);
                }
            }
        }

        //copy values to original array
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                this.board[i][j].setState(tempBoard[i][j].isState());
            }
        }

    }



    public void createDefaulfBoard(){

        for (int i=0; i < column ; i++){
            for (int j=0; j < row ; j++){
                board[i][j] = new Cell(false);
            }
        }

        // tworzymy populację początkową (standardowy Exploder)

            board[5][5] = new Cell(true);
            board[5][7] = new Cell(true);
            board[5][9] = new Cell(true);

        board[6][5] = new Cell(true);
        board[6][9] = new Cell(true);

        board[7][5] = new Cell(true);
        board[7][9] = new Cell(true);

        board[8][5] = new Cell(true);
        board[8][9] = new Cell(true);

        board[9][5] = new Cell(true);
        board[9][7] = new Cell(true);
        board[9][9] = new Cell(true);


    }


}
