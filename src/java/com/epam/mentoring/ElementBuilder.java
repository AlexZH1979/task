package com.epam.mentoring;

import com.epam.mentoring.shapes.Shape;
import com.epam.mentoring.shapes.impl.Quadrangle;
import com.epam.mentoring.shapes.impl.Triangle;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import org.w3c.dom.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


/**
 * Created by Aliaksandr_Zhmaidzia on 12/7/2015.
 */
public class ElementBuilder {

    List<Shape> shapes = new ArrayList<>();

    public ElementBuilder(Document document) {
        visit(document, 0);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void visit(Node node, int level) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i);
            process(childNode, level + 1);
            visit(childNode, level + 1);
        }
    }

    public void process(Node node, int level) {
        for (int i = 0; i < level; i++) {
        }
        if (node instanceof Element) {
            Element e = (Element) node;
            Shape shape = getShape(e);
            if (shape != null) {
                shapes.add(shape);
            }
        }
    }

    private Shape getShape(Element e) {
        String name = e.getTagName();
        Shape shape = null;
        switch (name) {
            case "quadrangle":
                shape = buildQuadrangle(e);
                break;
            case "triangle":
                shape = buildTriangle(e);
            default:
                break;
        }
        return shape;
    }

    private Shape buildTriangle(Element element) {
        NamedNodeMap map = element.getAttributes();
        Point2D a = new Point2D(resolveProperty(map, "a.x"), resolveProperty(map, "a.y"));
        Point2D b = new Point2D(resolveProperty(map, "b.x"), resolveProperty(map, "b.y"));
        Point2D c = new Point2D(resolveProperty(map, "c.x"), resolveProperty(map, "c.y"));
        return new Triangle(a, b, c);
    }

    private Quadrangle buildQuadrangle(Element element) {
        NamedNodeMap map = element.getAttributes();
        Point2D a = new Point2D(resolveProperty(map, "a.x"), resolveProperty(map, "a.y"));
        Point2D b = new Point2D(resolveProperty(map, "b.x"), resolveProperty(map, "b.y"));
        Point2D c = new Point2D(resolveProperty(map, "c.x"), resolveProperty(map, "c.y"));
        Point2D d = new Point2D(resolveProperty(map, "d.x"), resolveProperty(map, "d.y"));
        return new Quadrangle(a, b, c, d);

    }

    private double resolveProperty(NamedNodeMap map, String name) {
        String value = map.getNamedItem(name).getNodeValue();
        return Double.parseDouble(value);
    }
}
