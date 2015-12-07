package com.epam.mentoring.shapes.impl;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.Line;

/**
 * Created by Aliaksandr_Zhmaidzia on 12/7/2015.
 */
public class Triangle extends Linear {
    private final Line AB;
    private final Line BC;
    private final Line CA;

    public Triangle(Point2D a, Point2D b, Point2D c) {
        this.AB = getLine(a, b);
        this.BC = getLine(b, c);
        this.CA = getLine(c, a);
    }

    @Override
    public void draw(Group root) {
        root.getChildren().add(AB);
        root.getChildren().add(BC);
        root.getChildren().add(CA);
    }
}
