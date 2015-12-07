package com.epam.mentoring;

import com.epam.mentoring.shapes.Shape;
import com.epam.mentoring.shapes.impl.Triangle;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    private static List<Shape> shapes= new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        for (Shape shape:shapes){
            shape.draw(root);
        }
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File("sample.xml");
        Document document = builder.parse(file);
        ElementBuilder elementBuilder = new ElementBuilder(document);
        shapes = elementBuilder.getShapes();
        launch(args);
    }


}
