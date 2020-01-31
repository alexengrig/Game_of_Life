package life;

import javax.swing.*;

public class GameOfLife extends JFrame {
    private JLabel generationLabel;
    private JLabel aliveLabel;
    private Field field;

    private int generation = 0;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        generationLabel = new JLabel("Generation");
        add(generationLabel);
        aliveLabel = new JLabel("Alive");
        add(aliveLabel);
        field = new Field();
        add(field);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    public void nextGrid(Grid grid) {
        generationLabel.setText("Generation #" + ++generation);
        aliveLabel.setText("Alive: " + grid.getAliveCount());
        field.setGrid(grid);
    }
}
