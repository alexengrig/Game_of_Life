package life;

import java.util.Random;

class RandomCellsGenerator implements CellsGenerator {
    private final Random random;

    public RandomCellsGenerator() {
        random = new Random();
    }

    @Override
    public Cell[][] generate(int size) {
        Cell[][] cells = new Cell[size][size];
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                State state = random.nextBoolean() ? State.ALIVE : State.DEAD;
                cells[row][col] = new Cell(row, col, state);
            }
        }
        return cells;
    }
}
