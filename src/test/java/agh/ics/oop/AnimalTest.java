package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    IWorldMap map = new RectangularMap(4, 4);
    Vector2d initialPosition = new Vector2d(2, 2);
    Animal bob = new Animal(map, initialPosition);

    @Test
    public void testMove() {
        bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(), new Vector2d(2, 3));
        bob.move(MoveDirection.LEFT);
        assertEquals(bob.getDirection(), MapDirection.WEST);
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(), MapDirection.NORTH);
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(), MapDirection.EAST);
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(), MapDirection.SOUTH);
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(), MapDirection.WEST);
        bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(), new Vector2d(1, 3));
        bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(), new Vector2d(0, 3));
        bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(), new Vector2d(4, 3));
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(), new Vector2d(0, 3));
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(), MapDirection.NORTH);
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(), new Vector2d(0, 2));
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(), new Vector2d(0, 1));
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(), new Vector2d(0, 0));
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(), new Vector2d(0, 4));
    }

    @Test
    public void testOutOfMapExit() {
        for (int i = 0; i < 3; i++) bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(), new Vector2d(2, 0));

        bob.move(MoveDirection.RIGHT);
        for (int i = 0; i < 3; i++) bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(), new Vector2d(0, 0));

        bob.move(MoveDirection.LEFT);
        for (int i = 0; i < 5; i++) bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(), new Vector2d(0, 0));

    }
}
