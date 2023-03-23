package component;

import java.awt.*;

public class ShapeFactory {
    public UMLBasicObject createUMLObject(String type, Point location) {
        if (type.equals(UMLBasicObject.CLASS)) {
            return new UMLClass(location.x, location.y, 100 ,150);
        } else if (type.equals(UMLBasicObject.USE_CASE)) {
            return new UMLUseCase(location.x, location.y, 150, 100);
        } else {
            return null;
        }
    }

    public UMLBasicLine createUMLLine(String type, Point startPoint, Point endPoint) {
        if (type.equals(UMLBasicLine.ASSOCIATION)) {
            return new UMLAssociation(startPoint, endPoint);
        } else if (type.equals(UMLBasicLine.GENERALIZATION)) {
            return new UMLGeneralization(startPoint, endPoint);
        } else if (type.equals(UMLBasicLine.COMPOSITION)) {
            return new UMLComposition(startPoint, endPoint);
        } else {
            return null;
        }
    }
}
