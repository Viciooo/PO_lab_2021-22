package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {
    ArrayList<MoveDirection> directions = OptionsParser.parse("f f b l r l f f f".split(" "));
    IWorldMap map = new RectangularMap(7, 7);
    Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(6, 3), new Vector2d(5, 7)};
    IEngine engine = new SimulationEngine(directions, map, positions);
    Vector2d[] finalPositions = { new Vector2d(7,1) ,new Vector2d(7,4), new Vector2d(4,6)};

    @Test
    void run() {
        engine.run();
        Vector2d[] result = engine.getPositionOfAnimal();
        assertEquals(finalPositions[0], result[0]);
        assertEquals(finalPositions[1], result[1]);
        assertEquals(finalPositions[2], result[2]);
    }
}
