package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    public void testMove() {
        Animal bob = new Animal(MapDirection.NORTH,new Vector2d(2,2));
        bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(),new Vector2d(2,3));
        bob.move(MoveDirection.LEFT);
        assertEquals(bob.getDirection(),MapDirection.WEST);
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(),MapDirection.NORTH);
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(),MapDirection.EAST);
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(),MapDirection.SOUTH);
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(),MapDirection.WEST);
        bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(),new Vector2d(1,3));
        bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(),new Vector2d(0,3));
        bob.move(MoveDirection.FORWARD);
        assertEquals(bob.getPosition(),new Vector2d(4,3));
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(),new Vector2d(0,3));
        bob.move(MoveDirection.RIGHT);
        assertEquals(bob.getDirection(),MapDirection.NORTH);
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(),new Vector2d(0,2));
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(),new Vector2d(0,1));
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(),new Vector2d(0,0));
        bob.move(MoveDirection.BACKWARD);
        assertEquals(bob.getPosition(),new Vector2d(0,4));

    }
}