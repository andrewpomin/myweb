package myprojects.games.tictactoe;

public class Player {
    private final String name;
    private char figure;
    private boolean isWinner;

    Player(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public void setFigure(char figure) {this.figure = figure;}
    public char getFigure() {return figure;}
    public void setWinner(boolean winner) {this.isWinner = winner;}
    public boolean isWinner() {return isWinner;}
}
