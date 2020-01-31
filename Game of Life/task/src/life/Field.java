package life;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class Field extends JPanel {
    private Grid grid;

    public Field() {
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (grid == null) {
            return;
        }
        int height = getHeight();
        int width = getWidth();
        int length = Math.min(height, width);
        int count = grid.size();
        int size = length / count;
        g.setColor(Color.BLACK);
        Iterator<Cell[]> iterator = grid.iterator();
        for (int i = 0, y = 0; i < count; i++, y += size) {
            Cell[] row = iterator.next();
            for (int j = 0, x = 0; j < row.length; j++, x += size) {
                Cell cell = row[j];
                if (State.DEAD == cell.state) {
                    g.drawRect(x, y, size, size);
                } else {
                    g.fillRect(x, y, size, size);
                }
            }
        }
    }
}
