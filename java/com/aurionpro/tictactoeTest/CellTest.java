package com.aurionpro.tictactoeTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.aurionpro.models.*;

public class CellTest {

	@Test
	void testInitialMarkIsEmpty() {
		Cell cell = new Cell();
		assertEquals(Mark.EMPTY, cell.getMark());
	}

	@Test
	void testSetMarkOnce() {
		Cell cell = new Cell();
		cell.setMark(Mark.X);
		assertEquals(Mark.X, cell.getMark());
	}

	@Test
	void testSetMarkTwiceThrowsException() {
		Cell cell = new Cell();
		cell.setMark(Mark.X);
		assertThrows(IllegalStateException.class, () -> cell.setMark(Mark.O));
	}

	@Test
	void testResetCell() {
		Cell cell = new Cell();
		cell.setMark(Mark.X);
		cell.reset();
		assertEquals(Mark.EMPTY, cell.getMark());
	}
}
