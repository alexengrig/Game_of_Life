package life;

import java.util.Random;
import java.util.Scanner;

enum State {
    ALIVE {
        @Override
        public String toString() {
            return "O";
        }
    },
    DEAD {
        @Override
        public String toString() {
            return " ";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Cell[][] cells = new Cell[n][n];
        int seed = scanner.nextInt();
        Random random = new Random(seed);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                State state = random.nextBoolean() ? State.ALIVE : State.DEAD;
                cells[i][j] = new Cell(state);
            }
        }
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}

class Cell {
    final State state;

    public Cell(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
