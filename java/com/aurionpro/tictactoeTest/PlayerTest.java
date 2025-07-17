package com.aurionpro.tictactoeTest;

import static org.junit.jupiter.api.Assertions.*;	

import org.junit.jupiter.api.Test;

import com.aurionpro.models.Player;

class PlayerTest {

	 @Test
	    public void testPlayerProperties() {
	        Player player = new Player("Alice", 'X');
	        assertEquals("Alice", player.getName());
	        assertEquals('X', player.getSymbol());
	    }

}
