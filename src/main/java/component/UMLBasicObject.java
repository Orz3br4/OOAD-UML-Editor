package component;

import javax.swing.*;
import java.awt.*;

public abstract class UMLBasicObject extends UMLShape {
    public static final String CLASS = "class";
    public static final String USE_CASE = "useCase";
    protected String objName = "Object Name";
    protected int depth = 0;
    protected boolean isSelected = false;
    protected  UMLPort[] ports = new UMLPort[4];

    public UMLBasicObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        ports[0] = new UMLPort(new Point(x + width / 2, y));
        ports[1] = new UMLPort(new Point(x + width / 2, y + height));
        ports[2] = new UMLPort(new Point(x, y + height / 2));
        ports[3] = new UMLPort(new Point(x + width, y + height / 2));
    }

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


    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
