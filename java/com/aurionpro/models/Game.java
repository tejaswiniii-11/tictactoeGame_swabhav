package com.aurionpro.models;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;

    public Game(Player player1, Player player2) {
        board = new Board();
        players = new Player[]{player1, player2};
        currentPlayerIndex = 0;
    }

    public void play() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            board.printBoard();
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getMark() + ")");

            try {
                System.out.print("Enter row and column (0-2): ");
                int row = sc.nextInt();
                int col = sc.nextInt();

                validateInput(row, col);

                board.setMark(row, col, currentPlayer.getMark());

                if (board.checkWin(currentPlayer.getMark())) {
                    board.printBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                }

                if (board.isBoardFull()) {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayerIndex = (currentPlayerIndex + 1) % 2;

            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                sc.nextLine(); // clear buffer
            }
        }
    }

    private void validateInput(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3)
            throw new IllegalArgumentException("Row and column must be between 0 and 2.");
    }

    public void resetGame() {
        board.reset();
        currentPlayerIndex = 0;
    }
}
