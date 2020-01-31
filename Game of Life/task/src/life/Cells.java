package life;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

public class Cells implements Iterable<Cell[]> {
    private final Cell[][] cells;

    public Cells(Cell[][] cells) {
        this.cells = cells;
    }

    public int length() {
        return cells.length;
    }

    public int length(int rowIndex) {
        return cells[rowIndex].length;
    }

    public Cell get(int rowIndex, int colIndex) {
        return cells[rowIndex][colIndex];
    }

    @NotNull
    @Override
    public Iterator<Cell[]> iterator() {
        return new Iterator<>() {
            private Cell[][] target = Arrays.copyOf(cells, cells.length);
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < target.length;
            }

            @Override
            public Cell[] next() {
                return target[index++];
            }
        };
    }
}
