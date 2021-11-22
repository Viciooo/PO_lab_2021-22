package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void runTest() {
        ArrayList<MoveDirection> directions1 = OptionsParser.parse("f f f f f f f f f f f f l r f f f f f f".split(" "));
        IWorldMap map1 = new RectangularMap(7, 7);
        Vector2d[] positions1 = {new Vector2d(0, 0), new Vector2d(6, 3), new Vector2d(5, 7)};
        IEngine engine1 = new SimulationEngine(directions1, map1, positions1);
        engine1.run();
        Vector2d[] expectedResults1 = {new Vector2d(6,4), new Vector2d(0,7), new Vector2d(5,5)};
        Vector2d[] actualResults1 = engine1.getAnimalsPos();
        assertArrayEquals(expectedResults1, actualResults1);
    }
}