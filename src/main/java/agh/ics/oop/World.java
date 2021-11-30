package agh.ics.oop;

import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        System.out.println("start");
        ArrayList<MoveDirection> directions = OptionsParser.parse(args);
        IWorldMap myMap = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, myMap, positions);
        System.out.println(myMap);
        engine.run();
        System.out.println(myMap);
        System.out.println("stop");
    }
}
