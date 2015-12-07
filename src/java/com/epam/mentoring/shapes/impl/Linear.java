package com.epam.mentoring.shapes.impl;

import com.epam.mentoring.shapes.Shape;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

/**
 * Created by Aliaksandr_Zhmaidzia on 12/7/2015.
 */
abstract public class Linear implements Shape{
    protected Line getLine(Point2D start, Point2D end) {
        return new Line(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
