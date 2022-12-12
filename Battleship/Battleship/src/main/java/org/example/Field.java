package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Field extends GameBoard {

    public int[][] getFieldFromUser() {
        Scanner scn = new Scanner(System.in);
        int[][] fieldArr = new int[2][2];
        boolean stop = false;
        while (!stop) {
            try {
                String[] input = scn.nextLine().split(" ");
                if (input.length == 1) {
                    String field1 = input[0].trim().toUpperCase();
                    if (field1.matches("[A-J][1-9]0?")) {
                        fieldArr[0] = addFieldToArray(field1);
                        stop = true;
                    } else {
                        throw new InputMismatchException("Error! You entered the wrong coordinates! Try again:");
                    }
                } else if (input.length == 2) {
                    String field1 = input[0].trim().toUpperCase();
                    String field2 = input[1].trim().toUpperCase();
                    if (field1.matches("[A-J][1-9]0?") && field2.matches("[A-J][1-9]0?")) {
                        fieldArr[0] = addFieldToArray(field1);
                        fieldArr[1] = addFieldToArray(field2);
                        stop = true;
                    } else {
                        throw new InputMismatchException("Error! You entered the wrong coordinates! Try again:");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return fieldArr;
    }

    public int[] addFieldToArray(String field) {
        int[] fieldArr = new int[2];
        fieldArr[0] = switch (String.valueOf(field.charAt(0))) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            case "D" -> 4;
            case "E" -> 5;
            case "F" -> 6;
            case "G" -> 7;
            case "H" -> 8;
            case "I" -> 9;
            case "J" -> 10;
            default -> 0;
        };
        fieldArr[1] = Integer.parseInt(field.substring(1));
        return fieldArr;
    }

    public boolean isLocationFieldValid(int[] startField, int[] endField, int shipLength, String shipName, GameBoard gameBoard) {
        boolean isValid = false;
        if (startField[0] - endField[0] == 0 && startField[1] - endField[1] < 0 && shipLength - 1 == Math.abs(startField[1] - endField[1])) {
            int counter = 0;
            for (int i = 0; i < shipLength; i++) {
                if (!isFieldAdjacentToOtherShip(startField[0], startField[1] + i, gameBoard)) {
                    counter++;
                } else {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:\n");
                }
            }
            if (counter == shipLength) {
                isValid = true;
            }
        } else if (startField[0] - endField[0] == 0 && startField[1] - endField[1] > 0 && shipLength - 1 == Math.abs(startField[1] - endField[1])) {
            int counter = 0;
            for (int i = 0; i < shipLength; i++) {
                if (!isFieldAdjacentToOtherShip(startField[0], startField[1] - i, gameBoard)) {
                    counter++;
                } else {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:\n");
                }
            }
            if (counter == shipLength) {
                isValid = true;
            }
        } else if (startField[1] - endField[1] == 0 && startField[0] - endField[0] < 0 && shipLength - 1 == Math.abs(startField[0] - endField[0])) {
            int counter = 0;
            for (int i = 0; i < shipLength; i++) {
                if (!isFieldAdjacentToOtherShip(startField[0] + i, startField[1], gameBoard)) {
                    counter++;
                } else {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:\n");
                }
            }
            if (counter == shipLength) {
                isValid = true;
            }
        } else if (startField[1] - endField[1] == 0 && startField[0] - endField[0] > 0 && shipLength - 1 == Math.abs(startField[0] - endField[0])) {
            int counter = 0;
            for (int i = 0; i < shipLength; i++) {
                if (!isFieldAdjacentToOtherShip(startField[0] - i, startField[1], gameBoard)) {
                    counter++;
                } else {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:\n");
                }
            }
            if (counter == shipLength) {
                isValid = true;
            }
        } else {
            if (startField[0] != endField[0] && startField[1] != endField[1]) {
                throw new IllegalArgumentException("\nError! Wrong ship location! Try again:\n");
            } else {
                throw new IllegalArgumentException(String.format("\nError! Wrong length of the %s! Try again:\n", shipName));
            }
        }
        return isValid;
    }

    public boolean isFieldAdjacentToOtherShip(int f1, int f2, GameBoard gameBoard) {
        String[][] gb = gameBoard.getGameBoard();
        return (gb[f1][f2].equals("O") || gb[f1 + 1][f2].equals("O") || gb[f1 + 1][f2 + 1].equals("O") || gb[f1][f2 + 1].equals("O") ||
                gb[f1 - 1][f2 + 1].equals("O") || gb[f1 - 1][f2].equals("O") || gb[f1 - 1][f2 - 1].equals("O") || gb[f1][f2 - 1].equals("O") ||
                gb[f1 + 1][f2 - 1].equals("O"));
    }
}