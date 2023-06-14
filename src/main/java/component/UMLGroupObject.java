package component;

import layout.Canvas;

import java.awt.*;
import java.util.ArrayList;

public class UMLGroupObject extends UMLBasicObject {
    private final ArrayList<UMLBasicObject> objects = new ArrayList<>();

    public UMLGroupObject(int x, int y, int width, int height) {
        super(x, y, width, height);
        setSelected(true);
    }

    public void addObject(UMLBasicObject object) {
        objects.add(object);
        object.setSelected(false);
        x = getSmallestX();
        y = getSmallestY();
        width = getBiggestX() - x;
        height = getBiggestY() - y;
        ports[0].setLocation(new Point(x + width / 2, y));
        ports[1].setLocation(new Point(x + width / 2, y + height));
        ports[2].setLocation(new Point(x, y + height / 2));
        ports[3].setLocation(new Point(x + width, y + height / 2));
    }

    private int getBiggestY() {
        int biggestY = Integer.MIN_VALUE;
        for (UMLBasicObject object: objects) {
            biggestY = Integer.max(biggestY, object.y + object.height);
        }
        return biggestY;
    }

    private int getBiggestX() {
        int biggestX = Integer.MIN_VALUE;
        for (UMLBasicObject object: objects) {
            biggestX = Integer.max(biggestX, object.x + object.getWidth());
        }
        return biggestX;
    }

    private int getSmallestX() {
        int smallestX = Integer.MAX_VALUE;
        for (UMLBasicObject object: objects) {
            smallestX = Integer.min(smallestX, object.x);
        }
        return smallestX;
    }

    private int getSmallestY() {
        int smallestY = Integer.MAX_VALUE;
        for (UMLBasicObject object: objects) {
            smallestY = Integer.min(smallestY, object.y);
        }
        return smallestY;
    }

    @Override
    public void ungroup() {
        Canvas canvas = Canvas.getInstance();
        for (UMLBasicObject object: objects) {
            object.setGroup(null);
            object.setSelected(true);
            canvas.addSelectedObject(object);
            canvas.addObject((object));
        }
        for (UMLPort port: ports) {
            for (UMLBasicLine line: port.getLines()) {
                canvas.removeLine(line);
            }
            port.getLines().clear();
        }
        setSelected(false);
        canvas.removeObject(this);
        canvas.removeSelectedObject(this);
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        for (UMLBasicObject object: objects) {
            object.move(dx, dy);
        }
        for (UMLPort port: ports) {
            port.move(dx, dy);
        }
    }

    public ArrayList<UMLBasicObject> getObjects() {
        return objects;
    }

    @Override
    public void draw(Graphics g) {

        for (UMLBasicObject object: objects) {
            object.draw(g);
        }

        if (isSelected) {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);

            for (UMLPort port: ports) {
                port.draw(g);
            }
        }
    }

}
