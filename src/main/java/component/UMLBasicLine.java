package component;

import java.awt.*;

public abstract class UMLBasicLine extends UMLShape {
    public static final String ASSOCIATION = "Association";
    public static final String GENERALIZATION = "Generalization";
    public static final String COMPOSITION = "Composition";
    protected Point startPoint;
    protected Point endPoint;
    protected UMLPort startPort = null;
    protected UMLPort endPort = null;

    public UMLBasicLine(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public UMLPort getStartPort() {
        return startPort;
    }

    public void setStartPort(UMLPort startPort) {
        this.startPort = startPort;
    }

    public UMLPort getEndPort() {
        return endPort;
    }

    public void setEndPort(UMLPort endPort) {
        this.endPort = endPort;
    }

}
