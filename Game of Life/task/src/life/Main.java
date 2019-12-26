package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seed = scanner.nextInt();
        CellsGenerator generator = new RandomCellsGenerator(seed);
        Cell[][] cells = generator.generate(n);
        Grid grid = new Grid(cells);
        int steps = scanner.nextInt();
        for (int i = 0; i < steps; i++) {
            grid = grid.next();
        }
        grid.print();
    }
}

