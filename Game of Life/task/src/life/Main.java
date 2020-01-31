package life;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 20;
        int seed = 8;
        int steps = 20;
        CellsGenerator generator = new RandomCellsGenerator(seed);
        Cells cells = generator.generate(n);
        Grid grid = new Grid(cells);
        GameOfLife gameOfLife = new GameOfLife();
        for (int i = -1; i < steps; i++) {
            gameOfLife.nextGrid(grid);
            grid = grid.next();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

