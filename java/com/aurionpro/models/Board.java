package com.aurionpro.models;

public class Board {
    private Cell[][] grid;

    public Board() {
        this.grid = new Cell[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = new Cell();
    }

    public void setMark(int row, int col, Mark mark) {
        grid[row][col].setMark(mark);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i][j].getMark() == Mark.EMPTY)
                    return false;
        return true;
    }

    public boolean checkWin(Mark mark) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0].getMark() == mark && grid[i][1].getMark() == mark && grid[i][2].getMark() == mark) return true;
            if (grid[0][i].getMark() == mark && grid[1][i].getMark() == mark && grid[2][i].getMark() == mark) return true;
        }

        if (grid[0][0].getMark() == mark && grid[1][1].getMark() == mark && grid[2][2].getMark() == mark) return true;
        if (grid[0][2].getMark() == mark && grid[1][1].getMark() == mark && grid[2][0].getMark() == mark) return true;

        return false;
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j].toString() + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public void reset() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                cell.reset();
            }
        }
    }
}
