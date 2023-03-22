package shape;

import java.awt.*;

public class ShapeFactory {
    public UMLShape createUMLShape(String type, Point location) {
        if (type.equals(UMLShape.CLASS)) {
            return new UMLClass(location.x, location.y, 50 ,100);
        } else if (type.equals(UMLShape.USE_CASE)) {

        }
        return null;
    }
}
