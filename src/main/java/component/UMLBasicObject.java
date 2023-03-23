package component;

import javax.swing.*;
import java.awt.*;

public abstract class UMLBasicObject extends UMLShape {
    public static final String CLASS = "class";
    public static final String USE_CASE = "useCase";
    protected String objName = "Object Name";
    protected int depth;
    protected boolean isSelected = false;
    protected  UMLPort[] ports = new UMLPort[4];

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
