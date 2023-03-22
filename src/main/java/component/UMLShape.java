package component;

import javax.swing.*;
import java.awt.*;

public abstract class UMLShape extends JComponent {
    public static final String CLASS = "class";
    public static final String USE_CASE = "useCase";
    protected String objName = "Object Name";
    protected int x;
    protected int y;
    protected int width, height;
    protected int depth;
    protected boolean isSelected = false;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public abstract void draw(Graphics g);

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
