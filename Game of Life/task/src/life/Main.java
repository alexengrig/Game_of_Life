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
            return "_";
        }
    }
}

interface CellsGenerator {
    Cell[][] generate(Cell[][] cells);
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Cell[][] emptyCells = new Cell[n][n];
        int seed = scanner.nextInt();
        CellsGenerator generator = new RandomCellsGenerator(seed);
        Cell[][] cells = generator.generate(emptyCells);
        Grid grid = new Grid(cells);
        int steps = scanner.nextInt();
        for (int i = -1; i < steps; i++) {
            System.out.println("Step #" + (i + 1));
            grid.print();
            grid = grid.next();
        }
    }
}

class RandomCellsGenerator implements CellsGenerator {
    private final Random random;

    public RandomCellsGenerator(int seed) {
        random = new Random(seed);
    }

    @Override
    public Cell[][] generate(Cell[][] cells) {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                State state = random.nextBoolean() ? State.ALIVE : State.DEAD;
                cells[row][col] = new Cell(row, col, state);
            }
        }
        return cells;
    }
}

class Grid {
    private final Cell[][] cells;

    public Grid(Cell[][] cells) {
        this.cells = cells;
    }

    public Grid next() {
        Cell[][] nextCells = new Cell[this.cells.length][];
        for (int i = 0; i < cells.length; i++) {
            int rowLength = cells[i].length;
            nextCells[i] = new Cell[rowLength];
            for (int j = 0; j < rowLength; j++) {
                Cell cell = cells[i][j];
                State nextState;
                if (cell.state == State.ALIVE && isSurvivor(cell) || cell.state == State.DEAD && isReborn(cell)) {
                    nextState = State.ALIVE;
                } else {
                    nextState = State.DEAD;
                }
                nextCells[i][j] = new Cell(i, j, nextState);
            }
        }
        return new Grid(nextCells);
    }

    private boolean isReborn(Cell cell) {
        int count = countLivingNeighbors(cell);
        return count == 3;
    }

    private boolean isSurvivor(Cell cell) {
        int count = countLivingNeighbors(cell);
        return count == 2 || count == 3;
    }

    private int countLivingNeighbors(Cell cell) {
        int count = 0;
        if (northwest(cell).state == State.ALIVE) count++;
        if (north(cell).state == State.ALIVE) count++;
        if (northeast(cell).state == State.ALIVE) count++;
        if (west(cell).state == State.ALIVE) count++;
        if (east(cell).state == State.ALIVE) count++;
        if (southwest(cell).state == State.ALIVE) count++;
        if (south(cell).state == State.ALIVE) count++;
        if (southeast(cell).state == State.ALIVE) count++;
        return count;
    }

    private Cell northwest(Cell cell) {
        int upRow = back(cell.row, cells.length - 1);
        int leftCol = back(cell.col, cells[upRow].length - 1);
        return cells[upRow][leftCol];
    }

    private Cell north(Cell cell) {
        int upRow = back(cell.row, cells.length - 1);
        int col = back(cell.col, cells[upRow].length - 1);
        return cells[upRow][col];
    }

    private Cell northeast(Cell cell) {
        int upRow = back(cell.row, cells.length - 1);
        int rightCol = forth(cell.col, cells[upRow].length - 1);
        return cells[upRow][rightCol];
    }

    private Cell west(Cell cell) {
        int row = cell.row;
        int leftCol = back(cell.col, cells[row].length - 1);
        return cells[row][leftCol];
    }

    private Cell east(Cell cell) {
        int row = cell.row;
        int rightCol = forth(cell.col, cells[row].length - 1);
        return cells[row][rightCol];
    }

    private Cell southwest(Cell cell) {
        int downRow = forth(cell.row, cells.length - 1);
        int leftCol = back(cell.col, cells[downRow].length - 1);
        return cells[downRow][leftCol];
    }

    private Cell south(Cell cell) {
        int downRow = forth(cell.row, cells.length - 1);
        int col = cell.col;
        return cells[downRow][col];
    }

    private Cell southeast(Cell cell) {
        int downRow = forth(cell.row, cells.length - 1);
        int rightCol = forth(cell.col, cells[downRow].length - 1);
        return cells[downRow][rightCol];
    }

    private int back(int index, int max) {
        int left = index - 1;
        if (left >= 0) {
            return left;
        } else {
            return max;
        }
    }

    private int forth(int index, int max) {
        int right = index + 1;
        if (right <= max) {
            return right;
        } else {
            return 0;
        }
    }

    public void print() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                System.out.print(cell.toPrintString());
            }
            System.out.println();
        }
    }
}

class Cell {
    public final int col;
    public final int row;
    public final State state;

    public Cell(int col, int row, State state) {
        this.col = col;
        this.row = row;
        this.state = state;
    }

    public String toPrintString() {
        return state.toString();
    }
}
