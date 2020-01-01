package life;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JLabel generationLabel;
    private JLabel aliveLabel;
    private JPanel gridPanel;

    public MainWindow() throws HeadlessException {
        super("Game of Life");
        initWindow();
        initContent();
    }

    private void initWindow() {
        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initContent() {
        generationLabel = new JLabel("Generation");
        generationLabel.setName("generationLabel");
        add(generationLabel);
        aliveLabel = new JLabel("Alive");
        aliveLabel.setName("aliveLabel");
        add(aliveLabel);
        gridPanel = new JPanel();
        gridPanel.setSize(400, 300);
        add(gridPanel);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    public void updateGeneration(int generation) {
        generationLabel.setText("Generation #" + generation);
    }

    public void updateAlive(int numberOfAlive) {
        aliveLabel.setText("Alive: " + numberOfAlive);
    }

    public void updateCells(Cell[][] cells) {
        Graphics graphics = gridPanel.getGraphics();
        graphics.drawLine(10, 10, 50, 50);
        gridPanel.paint(graphics);
    }
}
