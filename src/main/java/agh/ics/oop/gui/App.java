package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    public void start(Stage primaryStage) {
        List<String> dir = getParameters().getRaw();
        ArrayList<MoveDirection> directions = OptionsParser.parse(dir);

        IWorldMap myMap = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, myMap, positions);
        System.out.println(myMap);
        engine.run();

    System.out.println(myMap);

    primaryStage.setTitle("Simulation Engine");


    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(10,10,10,10));
    gridPane.setGridLinesVisible(true);

    int x = myMap.getxMax() + 1;
    int y = myMap.getyMax() + 1;


        System.out.println(x);
        System.out.println(y);

    for(int i = 0; i<x;i++)
    {
        ColumnConstraints columnConstraints = new ColumnConstraints(50); // width in pixels
        columnConstraints.setPercentWidth(100.0 / x); // percentage of total width
        gridPane.getColumnConstraints().add(columnConstraints);
    }

    for(int i = 0; i<y;i++)
    {
        RowConstraints rowConstraints = new RowConstraints(50);
        rowConstraints.setPercentHeight(100.0 / y);
        gridPane.getRowConstraints().add(rowConstraints);
    }

    for(int i = 0; i<y;i++)
//    {
        for(int j = 0; j<x;j++)

        {
            int x1 = i;

            String text = "";
            if (i == 0 && j == 0) text = "y/x";
            else if (i == 0) text = String.valueOf(j - 1);
            else if (j == 0) text = String.valueOf(y - i - 1);
            else {
                if (myMap.objectAt(new Vector2d(j - 1, i - 1)) != null) {
                    text = myMap.objectAt(new Vector2d(j - 1, i - 1)).toString();
                }
                x1 = y - i;
            }
            Label newLabel = new Label(text);
            GridPane.setConstraints(newLabel, j, x1);
            GridPane.setHalignment(newLabel, HPos.CENTER);
            gridPane.add(newLabel, j, x1);
        }


        Scene scene = new Scene(gridPane, 50 * x, 50 * y);
            primaryStage.setScene(scene);
            primaryStage.show();
    }
    }

//}