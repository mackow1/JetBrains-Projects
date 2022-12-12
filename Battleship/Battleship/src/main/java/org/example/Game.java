package org.example;

import java.util.Scanner;

class Game {
    public void playBattleships() {
        Player player1 = new Player("1");
        Player player2 = new Player("2");

        boardSetup(player1, player1.getName());
        clearScreen();
        boardSetup(player2, player2.getName());
        clearScreen();
        boolean stop = false;
        int num = 1;
        while (!stop) {
            if (num % 2 != 0) {
                player1.printBothBoards();
                System.out.println("Player 1, it's your turn:\n");
                player1.shoot(player1.getPlayerGB(), player2.getPlayerGB());
                num++;
                if (player1.getHitsGB().allXOnBoard()) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    System.exit(0);
                }
                if (player2.checkBoardForSunkenShip(player1.getHitsGB())) System.out.println("You sank a ship! Specify a new target:");
                clearScreen();
            } else {
                player2.printBothBoards();
                System.out.println("Player 2, it's your turn:\n");
                player2.shoot(player2.getPlayerGB(), player1.getPlayerGB());
                num++;
                if (player2.getHitsGB().allXOnBoard()) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    System.exit(0);
                }
                if (player1.checkBoardForSunkenShip(player2.getHitsGB())) System.out.println("You sank a ship! Specify a new target:");
                clearScreen();
            }
        }
    }

    public static void clearScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress Enter and pass the move to another player");
        scanner.nextLine();
        for (int i = 0; i < 40; i++) {
            System.out.println("");
        }
    }

    public static void boardSetup(Player player, String name) {
        System.out.printf("Player %s, place your ships on the game field\n", name);
        player.getPlayerGB().printGameBoard();
        player.addShipsToTheBoard(player.getPlayerGB());
    }
}