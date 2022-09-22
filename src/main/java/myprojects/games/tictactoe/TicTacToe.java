package myprojects.games.tictactoe;

public class TicTacToe {
    static Player player1 = new Player("You");
    static Player player2 = new Player("Computer");

    public static void makeMove(Figure figure, char[] array) {
        setFigure(figure, array);
    }

    public static String whoIsWinner(char[] array, char typePlayer) {
        char type = combination(array);
        if (type == 'd') {
            return "It is a draw!";
        } else {
            if (type == typePlayer) {
                return player1.getName() + " won!";
            } else {
                return player2.getName() + " won!";
            }
        }
    }

    public static boolean isEnd(char[] array) {
        return combination(array) != 'n';
    }

    public static char combination(char[] array) {
        if (array[4] == array[1] && array[4] == array[7] && array[4] != 'n') {
            return array[4];
        } else if (array[4] == array[3] && array[4] == array[5] && array[4] != 'n') {
            return array[4];
        } else if (array[4] == array[0] && array[4] == array[8] && array[4] != 'n') {
            return array[4];
        } else if (array[4] == array[2] && array[4] == array[6] && array[4] != 'n') {
            return array[4];
        } else if (array[0] == array[1] && array[0] == array[2] && array[0] != 'n') {
            return array[0];
        } else if (array[0] == array[3] && array[0] == array[6] && array[0] != 'n') {
            return array[0];
        } else if (array[8] == array[7] && array[8] == array[6] && array[8] != 'n') {
            return array[8];
        } else if (array[8] == array[5] && array[8] == array[2] && array[8] != 'n') {
            return array[8];
        }

        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (array[i] == 'n') {
                draw = false;
                break;
            }
        }

        if (draw) {
            return 'd';
        } else {
            return 'n';
        }
    }

    public static void setFigure(Figure figure, char[] array) {
        int x = figure.getCoordinates();
        char type = figure.getType();
        array[x] = type;
//        printField(array);
    }

    public static char[] clearField(char[] array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i] = ' ';
            }
        }
        return array;
    }

    public static void printField(char[] array) {
        for (int i = 0; i < 9; i++) {
            if (array[i] == 'n') {
                System.out.print(' ');
            } else {
                System.out.print(array[i]);
            }
            if ((i + 1) % 3 == 0) {
                System.out.print("\n");
            }
        }
    }
}
