package life;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int seed = scanner.nextInt();
        CellsGenerator generator = new RandomCellsGenerator(seed);
        Cell[][] cells = generator.generate(n);
        Grid grid = new Grid(cells);
        for (int generation = 0; generation <= 10; generation++) {
            clear();
            System.out.println("Generation #" + generation);
            System.out.println("Alive: " + grid.getNumberOfAlive());
            grid.print();
            grid = grid.next();
        }
    }

    private static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

