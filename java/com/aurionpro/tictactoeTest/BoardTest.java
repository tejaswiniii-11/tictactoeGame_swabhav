package com.aurionpro.tictactoeTest;

import static org.junit.jupiter.api.Assertions.*;	

import org.junit.jupiter.api.Test;

import com.aurionpro.models.Board;


class BoardTest {

	 @Test
	    public void testMakeMove_ValidMove_ReturnsTrue() {
	        Board board = new Board();
	        boolean result = board.makeMove(0, 0, 'X');
	        assertTrue(result);
	    }

	    @Test
	    public void testMakeMove_InvalidMove_ReturnsFalse() {
	        Board board = new Board();
	        board.makeMove(0, 0, 'X');
	        boolean result = board.makeMove(0, 0, 'O'); // Already occupied
	        assertFalse(result);
	    }

	    @Test
	    public void testCheckWin_RowWin_ReturnsTrue() {
	        Board board = new Board();
	        board.makeMove(1, 0, 'X');
	        board.makeMove(1, 1, 'X');
	        board.makeMove(1, 2, 'X');
	        assertTrue(board.checkWin('X'));
	    }

	    @Test
	    public void testCheckWin_ColWin_ReturnsTrue() {
	        Board board = new Board();
	        board.makeMove(0, 2, 'O');
	        board.makeMove(1, 2, 'O');
	        board.makeMove(2, 2, 'O');
	        assertTrue(board.checkWin('O'));
	    }

	    @Test
	    public void testCheckWin_DiagonalWin_ReturnsTrue() {
	        Board board = new Board();
	        board.makeMove(0, 0, 'X');
	        board.makeMove(1, 1, 'X');
	        board.makeMove(2, 2, 'X');
	        assertTrue(board.checkWin('X'));
	    }

	    @Test
	    public void testIsFull_WhenBoardIsFull_ReturnsTrue() {
	        Board board = new Board();
	        char[] moves = {'X', 'O'};
	        int index = 0;
	        for (int i = 0; i < 3; i++)
	            for (int j = 0; j < 3; j++)
	                board.makeMove(i, j, moves[index++ % 2]);
	        assertTrue(board.isFull());
	    }

	    @Test
	    public void testIsFull_WhenBoardIsNotFull_ReturnsFalse() {
	        Board board = new Board();
	        board.makeMove(0, 0, 'X');
	        assertFalse(board.isFull());
	    }

}
