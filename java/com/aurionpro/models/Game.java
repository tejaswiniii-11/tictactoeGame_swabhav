package com.aurionpro.models;

import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private final Scanner scanner;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        Player currentPlayer = player1;
        while (true) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter row (0, 1, 2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0, 1, 2): ");
            int col = scanner.nextInt();

            if (!board.makeMove(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println("Congratulations!! " + currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("It's a draw! Better Luck next time ;)");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}

