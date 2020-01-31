package life;

public class Cell {
    public final int row;
    public final int col;
    public final State state;

    public Cell(int row, int col, State state) {
        this.row = row;
        this.col = col;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", state=" + state +
                '}';
    }
}
