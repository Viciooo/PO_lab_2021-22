package agh.ics.oop;

import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
//        Animal bob = new Animal(MapDirection.NORTH, new Vector2d(2, 2));
//        ArrayList<MoveDirection> setOfDirections = new ArrayList<>();
        System.out.println("start");
        ArrayList<MoveDirection> directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(7, 7);
        Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(6, 3), new Vector2d(5, 7)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map);
        engine.run();
        System.out.println(map);
        Vector2d[] positionsFinal = engine.getPositionOfAnimal();
        System.out.println(positionsFinal[0]+" "+positionsFinal[1]+" "+positionsFinal[2]);
        System.out.println("stop");
    }
}
