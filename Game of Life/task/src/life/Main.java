package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seed = scanner.nextInt();
        CellsGenerator generator = new RandomCellsGenerator(seed);
        Cells cells = generator.generate(n);
        Grid grid = new Grid(cells);
        for (int i = -1; i < 10; i++) {
            print(grid);
            grid = grid.next();
        }
    }

    public static void print(Grid grid) {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                System.out.print(State.DEAD == cell.state ? "_" : "O");
            }
            System.out.println();
        }
    }
}

