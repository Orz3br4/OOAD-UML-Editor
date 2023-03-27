package component;

import java.awt.*;

public class UMLComposition extends UMLBasicLine {
    public UMLComposition(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);

        Point v = new Point(startPoint.x - endPoint.x, startPoint.y- endPoint.y );
        int vLength = (int) Math.hypot(v.x, v.y);

        Point p1 = new Point(
                (int) ((v.x * Math.cos(Math.PI / 4) - v.y * Math.sin(Math.PI / 4)) / vLength * 12 + endPoint.x),
                (int) ((v.x * Math.sin(Math.PI / 4) + v.y * Math.cos(Math.PI / 4)) / vLength * 12 + endPoint.y)
        );

        Point p2 = new Point(
                (int) ((v.x * Math.cos(-Math.PI / 4) - v.y * Math.sin(-Math.PI / 4)) / vLength * 12 + p1.x),
                (int) ((v.x * Math.sin(-Math.PI / 4) + v.y * Math.cos(-Math.PI / 4)) / vLength * 12 + p1.y)
        );

        Point p3 = new Point(
                (int) ((v.x * Math.cos(-Math.PI / 4) - v.y * Math.sin(-Math.PI / 4)) / vLength * 12 + endPoint.x),
                (int) ((v.x * Math.sin(-Math.PI / 4) + v.y * Math.cos(-Math.PI / 4)) / vLength * 12 + endPoint.y)
        );

        g.setColor(Color.WHITE);
        g.fillPolygon(
                new int[] {p1.x, p2.x, p3.x, endPoint.x},
                new int[] {p1.y, p2.y, p3.y, endPoint.y},
                4);

        g.setColor(Color.BLACK);
        g.drawPolygon(
                new int[] {p1.x, p2.x, p3.x, endPoint.x},
                new int[] {p1.y, p2.y, p3.y, endPoint.y},
                4);
    }
}
