package com.aurionpro.tests;

import java.util.Scanner;
import com.aurionpro.models.*;

public class GameDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter name of Player 1: ");
            String name1 = sc.nextLine();
            System.out.print("Enter name of Player 2: ");
            String name2 = sc.nextLine();

            Player p1 = new Player(name1, Mark.X);
            Player p2 = new Player(name2, Mark.O);

            Game game = new Game(p1, p2);

            while (true) {
                game.play();

                System.out.print("Do you want to play again? (yes/no): ");
                String input = sc.next().trim().toLowerCase();

                if (!input.equals("yes")) {
                    System.out.println("Thank you for playing!");
                    break;
                }

                game.resetGame();
            }
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
