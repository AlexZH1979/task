package com.epam.mentoring.shapes.impl;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.Line;

/**
 * Created by Aliaksandr_Zhmaidzia on 12/7/2015.
 */
public class Quadrangle extends Linear {

    private final Line AB;
    private final Line BC;
    private final Line CD;
    private final Line DA;

    public Quadrangle(Point2D a, Point2D b, Point2D c, Point2D d) {
        this.AB = getLine(a,b);
        this.BC = getLine(b,c);
        this.CD = getLine(c,d);
        this.DA = getLine(d,a);
    }


    @Override
    public void draw(Group root) {
        root.getChildren().add(AB);
        root.getChildren().add(BC);
        root.getChildren().add(CD);
        root.getChildren().add(DA);
    }
}
