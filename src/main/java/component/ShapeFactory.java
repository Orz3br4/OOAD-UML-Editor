package component;

import java.awt.*;

public class ShapeFactory {
    public UMLBasicObject createUMLShape(String type, Point location) {
        if (type.equals(UMLBasicObject.CLASS)) {
            return new UMLClass(location.x, location.y, 100 ,150);
        } else if (type.equals(UMLBasicObject.USE_CASE)) {
            return new UMLUseCase(location.x, location.y, 150, 100);
        }
        return null;
    }
}
