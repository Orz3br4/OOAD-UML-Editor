package component;

import javax.swing.*;
import java.awt.*;

public abstract class UMLShape extends JComponent {
    protected int x;

    protected int y;
    protected int width;
    protected int height;

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
}
