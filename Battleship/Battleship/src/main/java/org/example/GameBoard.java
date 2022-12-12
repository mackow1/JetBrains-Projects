package org.example;

class GameBoard extends Game {

    private final String[][] gameBoard = {{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", ""},
            {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~", ""},
            {"", "", "", "", "", "", "", "", "", "", "", ""}};

    public String[][] getGameBoard() {
        return this.gameBoard;
    }

    public void printGameBoard() {
        String[][] gameBoard = this.gameBoard;
        System.out.println();
        for (String[] s : gameBoard) {
            for (String str : s) {
                System.out.print(str);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean allXOnBoard() {
        String[][] gameBoard = this.getGameBoard();
        int counter = 0;
        for (String[] str : gameBoard) {
            for (String s : str) {
                if (s.equals("X")) counter++;
            }
        }
        return counter == 17;
    }
}