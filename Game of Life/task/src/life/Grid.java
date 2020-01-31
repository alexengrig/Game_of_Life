package life;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Grid implements Iterable<Cell[]> {
    private final Cells cells;

    public Grid(Cells cells) {
        this.cells = cells;
    }

    public Grid next() {
        Cell[][] nextCells = new Cell[cells.length()][];
        for (int row = 0; row < cells.length(); row++) {
            nextCells[row] = new Cell[cells.length(row)];
            for (int col = 0; col < cells.length(row); col++) {
                Cell cell = cells.get(row, col);
                State newState;
                State state = cell.state;
                if (state == State.ALIVE && isSurvivor(cell) || state == State.DEAD && isReborn(cell)) {
                    newState = State.ALIVE;
                } else {
                    newState = State.DEAD;
                }
                Cell nextCell = new Cell(row, col, newState);
                nextCells[row][col] = nextCell;
            }
        }
        return new Grid(new Cells(nextCells));
    }

    private boolean isReborn(Cell cell) {
        int count = countAlive(cell);
        return count == 3;
    }

    private boolean isSurvivor(Cell cell) {
        int count = countAlive(cell);
        return count == 2 || count == 3;
    }

    private int countAlive(Cell cell) {
        int count = 0;
        int row = cell.row;
        int rowLength = cells.length();
        int upRow = back(row, rowLength);
        int downRow = forth(row, rowLength);
        int col = cell.col;
        int colLength = cells.length(row);
        int leftCol = back(col, colLength);
        int rightCol = forth(col, colLength);
        State state = State.ALIVE;
        Cell northwest = cells.get(upRow, leftCol);
        if (northwest.state == state) count++;
        Cell north = cells.get(upRow, col);
        if (north.state == state) count++;
        Cell northeast = cells.get(upRow, rightCol);
        if (northeast.state == state) count++;
        Cell west = cells.get(row, leftCol);
        if (west.state == state) count++;
        Cell east = cells.get(row, rightCol);
        if (east.state == state) count++;
        Cell southwest = cells.get(downRow, leftCol);
        if (southwest.state == state) count++;
        Cell south = cells.get(downRow, col);
        if (south.state == state) count++;
        Cell southeast = cells.get(downRow, rightCol);
        if (southeast.state == state) count++;
        return count;
    }

    private int back(int index, int length) {
        int back = index - 1;
        if (back >= 0) {
            return back;
        } else {
            return length - 1;
        }
    }

    private int forth(int index, int length) {
        int forth = index + 1;
        if (forth < length) {
            return forth;
        } else {
            return 0;
        }
    }

    @NotNull
    @Override
    public Iterator<Cell[]> iterator() {
        return cells.iterator();
    }
}
