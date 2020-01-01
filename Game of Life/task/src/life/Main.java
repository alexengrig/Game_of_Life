package life;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MainWindow window = new MainWindow();
        CellsGenerator generator = new RandomCellsGenerator();
        Cell[][] cells = generator.generate(20);
        Grid grid = new Grid(cells);
        for (int generation = 0; generation <= 1000; generation++) {
            System.out.println("Generation " + generation);
            window.updateGeneration(generation);
            window.updateAlive(grid.getNumberOfAlive());
            window.updateCells(grid.getCells());
            grid = grid.next();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

