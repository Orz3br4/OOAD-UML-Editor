package component;

import java.awt.*;
import java.util.ArrayList;

public class UMLPort extends UMLShape {
    private ArrayList<UMLBasicLine> lines = new ArrayList<>();

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

    public void setLocation(Point point) {
        x = point.x;
        y = point.y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        for (UMLBasicLine line: lines) {
            if (line.getStartPort() == this) {
                line.setStartPoint(new Point(x, y));
            } else if (line.getEndPort() == this) {
                line.setEndPoint(new Point(x, y));
            }
        }
    }

    public void addLine(UMLBasicLine line) {
        lines.add(line);
    }

    public void removeLine(UMLBasicLine currentLine) {
        lines.remove(currentLine);
    }

    public ArrayList<UMLBasicLine> getLines() {
        return lines;
    }

}
