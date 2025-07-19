package com.aurionpro.tictactoeTest;

import static org.junit.jupiter.api.Assertions.*;		

import org.junit.jupiter.api.Test;

import com.aurionpro.models.Board;

import com.aurionpro.models.Mark;

import org.junit.jupiter.api.BeforeEach;


public class BoardTest {

    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    void testSetMark() {
        board.setMark(0, 0, Mark.X);
        assertFalse(board.checkWin(Mark.X));
    }

    @Test
    void testRowWin() {
        board.setMark(0, 0, Mark.X);
        board.setMark(0, 1, Mark.X);
        board.setMark(0, 2, Mark.X);
        assertTrue(board.checkWin(Mark.X));
    }

    @Test
    void testColWin() {
        board.setMark(0, 1, Mark.O);
        board.setMark(1, 1, Mark.O);
        board.setMark(2, 1, Mark.O);
        assertTrue(board.checkWin(Mark.O));
    }

    @Test
    void testDiagonalWin() {
        board.setMark(0, 0, Mark.X);
        board.setMark(1, 1, Mark.X);
        board.setMark(2, 2, Mark.X);
        assertTrue(board.checkWin(Mark.X));
    }

    @Test
    void testFullBoard() {
        Mark[][] marks = {
            {Mark.X, Mark.O, Mark.X},
            {Mark.X, Mark.X, Mark.O},
            {Mark.O, Mark.X, Mark.O}
        };
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board.setMark(i, j, marks[i][j]);

        assertTrue(board.isBoardFull());
    }

    @Test
    void testReset() {
        board.setMark(1, 1, Mark.O);
        board.reset();
        assertFalse(board.isBoardFull());
        assertFalse(board.checkWin(Mark.O));
    }
}
