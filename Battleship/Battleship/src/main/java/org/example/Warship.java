package org.example;

public enum Warship {

    AIRCRAFT_CARRIER("Aircraft Carrier", 5, true),
    BATTLESHIP("Battleship", 4, true),
    SUBMARINE("Submarine", 3, true),
    CRUISER("Cruiser", 3, true),
    DESTROYER("Destroyer", 2, true);
    private final String name;
    private final int length;
    private boolean alive;
    Warship(String name, int length, boolean alive) {
        this.name = name;
        this.length = length;
        this.alive = alive;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}