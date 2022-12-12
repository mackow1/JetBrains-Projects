package org.example;

abstract class Warships extends Field {

    private int[][] aircraftCarrierPosition = new int[5][2];
    private int[][] battleshipPosition = new int[4][2];
    private int[][] submarinePosition = new int[3][2];
    private int[][] cruiserPosition = new int[3][2];
    private int[][] destroyerPosition = new int[2][2];

    public int[][] getAircraftCarrierPosition() {
        return this.aircraftCarrierPosition;
    }

    public void setAircraftCarrierPosition(int[][] aircraftCarrierPosition) {
        this.aircraftCarrierPosition = aircraftCarrierPosition;
    }

    public int[][] getBattleshipPosition() {
        return this.battleshipPosition;
    }

    public void setBattleshipPosition(int[][] battleshipPosition) {
        this.battleshipPosition = battleshipPosition;
    }

    public int[][] getSubmarinePosition() {
        return this.submarinePosition;
    }

    public void setSubmarinePosition(int[][] submarinePosition) {
        this.submarinePosition = submarinePosition;
    }

    public int[][] getCruiserPosition() {
        return this.cruiserPosition;
    }

    public void setCruiserPosition(int[][] cruiserPosition) {
        this.cruiserPosition = cruiserPosition;
    }

    public int[][] getDestroyerPosition() {
        return this.destroyerPosition;
    }

    public void setDestroyerPosition(int[][] destroyerPosition) {
        this.destroyerPosition = destroyerPosition;
    }



    protected int[][] addShip(int[][] location, int shipLength, GameBoard gameBoard) {
        String[][] gb = gameBoard.getGameBoard();
        int[][] positionArray = new int[shipLength][2];
        int[] startField = location[0];
        int[] endField = location[1];
        if (startField[0] - endField[0] == 0 && startField[1] - endField[1] < 0) {
            for (int i = 0; i < shipLength; i++) {
                gb[startField[0]][startField[1] + i] = "O";
                positionArray[i][0] = startField[0];
                positionArray[i][1] = startField[1] + i;
            }
        } else if (startField[0] - endField[0] == 0 && startField[1] - endField[1] > 0) {
            for (int i = 0; i < shipLength; i++) {
                gb[startField[0]][startField[1] - i] = "O";
                positionArray[i][0] = startField[0];
                positionArray[i][1] = startField[1] - i;
            }
        } else if (startField[1] - endField[1] == 0 && startField[0] - endField[0] < 0) {
            for (int i = 0; i < shipLength; i++) {
                gb[startField[0] + i][startField[1]] = "O";
                positionArray[i][0] = startField[0] + i;
                positionArray[i][1] = startField[1];
            }
        } else if (startField[1] - endField[1] == 0 && startField[0] - endField[0] > 0) {
            for (int i = 0; i < shipLength; i++) {
                gb[startField[0] - i][startField[1]] = "O";
                positionArray[i][0] = startField[0] - i;
                positionArray[i][1] = startField[1];
            }
        }
        return positionArray;
    }

    protected int[][] aircraftCarrier(GameBoard gameBoard) {
        int[][] returnArray = new int[2][2];
        boolean stop = false;
        while (!stop) {
            try {
                returnArray = super.getFieldFromUser();
                if (super.isLocationFieldValid(returnArray[0], returnArray[1], Warship.AIRCRAFT_CARRIER.getLength(), Warship.AIRCRAFT_CARRIER.getName(), gameBoard)) {
                    return returnArray;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return returnArray;
    }

    protected int[][] battleship(GameBoard gameBoard) {
        int[][] returnArray = new int[2][2];
        boolean stop = false;
        while (!stop) {
            try {
                returnArray = super.getFieldFromUser();
                if (super.isLocationFieldValid(returnArray[0], returnArray[1], Warship.BATTLESHIP.getLength(), Warship.BATTLESHIP.getName(), gameBoard)) {
                    return returnArray;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return returnArray;
    }

    protected int[][] submarine(GameBoard gameBoard) {
        int[][] returnArray = new int[2][2];
        boolean stop = false;
        while (!stop) {
            try {
                returnArray = super.getFieldFromUser();
                if (super.isLocationFieldValid(returnArray[0], returnArray[1], Warship.SUBMARINE.getLength(), Warship.SUBMARINE.getName(), gameBoard)) {
                    return returnArray;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return returnArray;
    }

    protected int[][] cruiser(GameBoard gameBoard) {
        int[][] returnArray = new int[2][2];
        boolean stop = false;
        while (!stop) {
            try {
                returnArray = super.getFieldFromUser();
                if (super.isLocationFieldValid(returnArray[0], returnArray[1], Warship.CRUISER.getLength(), Warship.CRUISER.getName(), gameBoard)) {
                    return returnArray;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return returnArray;
    }

    protected int[][] destroyer(GameBoard gameBoard) {
        int[][] returnArray = new int[2][2];
        boolean stop = false;
        while (!stop) {
            try {
                returnArray = super.getFieldFromUser();
                if (super.isLocationFieldValid(returnArray[0], returnArray[1], Warship.DESTROYER.getLength(), Warship.DESTROYER.getName(), gameBoard)) {
                    return returnArray;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return returnArray;
    }
}
