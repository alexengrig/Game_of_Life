package life;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class GameOfLife extends JFrame {
    private JLabel generationLabel;
    private JLabel aliveLabel;
    private JButton runButton;
    private JButton resetButton;
    private Field field;

    private int generation = 0;
    private boolean paused = true;

    private Grid grid;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
        initComponents();
        initGrid();
        control();
    }

    private void initComponents() {
        generationLabel = new JLabel("Generation");
        generationLabel.setName("GenerationLabel");
        add(generationLabel);
        aliveLabel = new JLabel("Alive");
        aliveLabel.setName("AliveLabel");
        add(aliveLabel);
        runButton = new JButton(paused ? "Pause" : "Resume");
        runButton.setName("PlayToggleButton");
        runButton.addActionListener(e -> {
            paused = !paused;
            runButton.setText(paused ? "Pause" : "Resume");
        });
        add(runButton);
        resetButton = new JButton("Reset");
        resetButton.setName("ResetButton");
        resetButton.addActionListener(e -> reset());
        add(resetButton);
        field = new Field();
        add(field);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    private void initGrid() {
        int n = 20;
        int seed = 8;
        CellsGenerator generator = new RandomCellsGenerator(seed);
        Cells cells = generator.generate(n);
        grid = new Grid(cells);
    }

    private void control() {
        try {
            while (grid.getAliveCount() != 0) {
                nextGrid(grid);
                grid = grid.next();
                do {
                    TimeUnit.MILLISECONDS.sleep(500);
                } while (!isPaused());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void reset() {
        generation  = 0;
        initGrid();
    }

    public void nextGrid(Grid grid) {
        generationLabel.setText("Generation #" + ++generation);
        aliveLabel.setText("Alive: " + grid.getAliveCount());
        field.setGrid(grid);
    }

    public boolean isPaused() {
        return paused;
    }
}
