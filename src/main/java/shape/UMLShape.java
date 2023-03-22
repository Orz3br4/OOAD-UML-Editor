package shape;

import javax.swing.*;
import java.awt.*;

public abstract class UMLShape extends JComponent {
    private int x, y;
    private int width, height;
    private boolean isSelected = false;

    public UMLShape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public abstract void paint(Graphics g);

    public boolean contains(Point p) {
        return getBounds().contains(p);
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
