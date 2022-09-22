package myprojects.games.tictactoe;

import myprojects.games.Coordinates;

public class Figure {
    private final int coordinates;
    private final char type;

    public Figure(char type, int coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public int getCoordinates() {return coordinates;}
    public char getType() {return type;}
}
