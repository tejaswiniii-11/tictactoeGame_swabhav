package com.aurionpro.tests;

import java.util.Scanner;

import com.aurionpro.models.Game;
import com.aurionpro.models.Player;

public class GameDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🎮 Welcome to Tic-Tac-Toe!");

        System.out.print("Enter name for Player 1 (X): ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1, 'X');

        System.out.print("Enter name for Player 2 (O): ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2, 'O');

        Game game = new Game(player1, player2);
        game.start();

        scanner.close();
    }
}

