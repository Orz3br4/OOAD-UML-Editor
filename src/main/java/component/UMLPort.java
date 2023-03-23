package component;

import java.awt.*;

public class UMLPort extends UMLShape {
    public UMLPort(Point location) {
        x = location.x;
        y = location.y;
        width = 5;
        height = 5;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x - width / 2, y - height / 2, width, height);
    }

    public boolean contains(Point p) {
        return getBounds().contains(p);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public Point getLocation() {
        return new Point(getX(), getY());
    }
}
