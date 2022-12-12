package org.example;

class Player extends Warships {
    private String name;
    private GameBoard playerGB = new GameBoard();
    private GameBoard hitsGB = new GameBoard();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public GameBoard getPlayerGB() {
        return this.playerGB;
    }

    public GameBoard getHitsGB() {
        return this.hitsGB;
    }

    public boolean shoot(GameBoard hitsGB, GameBoard opponentGB) {
        int[] fieldOfAttack = super.getFieldFromUser()[0];
        int f1 = fieldOfAttack[0];
        int f2 = fieldOfAttack[1];
        if (opponentGB.getGameBoard()[f1][f2].equals("O")) {
            this.hitsGB.getGameBoard()[f1][f2] = "X";
            opponentGB.getGameBoard()[f1][f2] = "X";
            System.out.println("You hit a ship!");
            return true;
        } else if (opponentGB.getGameBoard()[f1][f2].equals("X")) {
            System.out.println("You hit a ship!");
            return false;
        } else {
            this.hitsGB.getGameBoard()[f1][f2] = "M";
            opponentGB.getGameBoard()[f1][f2] = "M";
            System.out.println("You missed!");
            return false;
        }
    }

    public void addShipsToTheBoard(GameBoard playerGB) {
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):\n");
        super.setAircraftCarrierPosition(super.addShip(super.aircraftCarrier(this.getPlayerGB()), Warship.AIRCRAFT_CARRIER.getLength(), playerGB));
        playerGB.printGameBoard();
        System.out.println("Enter the coordinates of the Battleship (4 cells):\n");
        super.setBattleshipPosition(super.addShip(battleship(this.getPlayerGB()), Warship.BATTLESHIP.getLength(), playerGB));
        playerGB.printGameBoard();
        System.out.println("Enter the coordinates of the Submarine (3 cells):\n");
        super.setSubmarinePosition(super.addShip(submarine(this.getPlayerGB()), Warship.SUBMARINE.getLength(), playerGB));
        playerGB.printGameBoard();
        System.out.println("Enter the coordinates of the Cruiser (3 cells):\n");
        super.setCruiserPosition(super.addShip(cruiser(this.getPlayerGB()), Warship.CRUISER.getLength(), playerGB));
        playerGB.printGameBoard();
        System.out.println("Enter the coordinates of the Destroyer (2 cells):\n");
        super.setDestroyerPosition(super.addShip(destroyer(this.getPlayerGB()), Warship.DESTROYER.getLength(), playerGB));
        playerGB.printGameBoard();
    }

    public boolean checkBoardForSunkenShip(GameBoard gameBoard) {
        if (this.isShipSank(super.getAircraftCarrierPosition(), Warship.AIRCRAFT_CARRIER.getLength(), gameBoard) && Warship.AIRCRAFT_CARRIER.isAlive()) {
            Warship.AIRCRAFT_CARRIER.setAlive(false);
            return true;
        } else if (this.isShipSank(super.getBattleshipPosition(), Warship.BATTLESHIP.getLength(), gameBoard) && Warship.BATTLESHIP.isAlive()) {
            Warship.BATTLESHIP.setAlive(false);
            return true;
        } else if (this.isShipSank(super.getSubmarinePosition(), Warship.SUBMARINE.getLength(), gameBoard) && Warship.SUBMARINE.isAlive()) {
            Warship.SUBMARINE.setAlive(false);
            return true;
        } else if (this.isShipSank(super.getCruiserPosition(), Warship.CRUISER.getLength(), gameBoard) && Warship.CRUISER.isAlive()) {
            Warship.CRUISER.setAlive(false);
            return true;
        } else if (this.isShipSank(super.getDestroyerPosition(), Warship.DESTROYER.getLength(), gameBoard) && Warship.DESTROYER.isAlive()) {
            Warship.DESTROYER.setAlive(false);
            return true;
        } else {
            return false;
        }
    }

    public boolean isShipSank(int[][] shipPosition, int shipLength, GameBoard gameBoard) {
        String[][] gb = gameBoard.getGameBoard();
        int counter = 0;
        for (int[] i : shipPosition) {
            if (gb[i[0]][i[1]].equals("X")) counter++;
        }
        return counter == shipLength;
    }

    public void printBothBoards() {
        getHitsGB().printGameBoard();
        System.out.println("---------------------");
        getPlayerGB().printGameBoard();
    }
}