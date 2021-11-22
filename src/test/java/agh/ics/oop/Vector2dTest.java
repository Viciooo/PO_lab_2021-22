package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void testEquals() {
        assertEquals(new Vector2d(2, 1), new Vector2d(2, 1));
        assertNotEquals(new Vector2d(2, 1), new Vector2d(3, 7));
    }

    @Test
    public void testToString() {
        assertEquals("(3,5)", new Vector2d(3, 5).toString());
    }

    @Test
    public void testPrecedes() {
        assertTrue(new Vector2d(3, 4).precedes(new Vector2d(1, 2)));
        assertTrue(new Vector2d(5, 5).precedes(new Vector2d(3, 5)));
        assertFalse(new Vector2d(10, 5).precedes(new Vector2d(7, 6)));
    }

    @Test
    public void testFollows() {
        assertTrue(new Vector2d(5, 5).follows(new Vector2d(5, 6)));
        assertTrue(new Vector2d(2, 1).follows(new Vector2d(3, 9)));
        assertFalse(new Vector2d(10, 3).follows(new Vector2d(2, 8)));
    }

    @Test
    public void testUpperRight() {
        assertEquals(new Vector2d(3, 4).upperRight(new Vector2d(4, 3)), new Vector2d(4, 4));
        assertEquals(new Vector2d(6, 9).upperRight(new Vector2d(3, 5)), new Vector2d(6, 9));
        assertEquals(new Vector2d(44, 72).upperRight(new Vector2d(58, 42)), new Vector2d(58, 72));
        assertNotEquals(new Vector2d(88, 50).upperRight(new Vector2d(63, 42)), new Vector2d(88, 42));
    }

    @Test
    public void testLowerLeft() {
        assertEquals(new Vector2d(3, 4).lowerLeft(new Vector2d(4, 3)), new Vector2d(3, 3));
        assertEquals(new Vector2d(6, 9).lowerLeft(new Vector2d(3, 5)), new Vector2d(3, 5));
        assertNotEquals(new Vector2d(44, 72).lowerLeft(new Vector2d(58, 42)), new Vector2d(44, 58));
        assertNotEquals(new Vector2d(88, 50).lowerLeft(new Vector2d(63, 42)), new Vector2d(63, 50));
    }

    @Test
    public void testAdd() {
        assertEquals(new Vector2d(3, 4).add(new Vector2d(4, 3)), new Vector2d(7, 7));
        assertEquals(new Vector2d(6, 9).add(new Vector2d(3, 5)), new Vector2d(9, 14));
    }

    @Test
    public void testSubtract() {
        assertEquals(new Vector2d(3, 2).subtract(new Vector2d(1, 1)), new Vector2d(2, 1));
        assertEquals(new Vector2d(10, 2).subtract(new Vector2d(1, 2)), new Vector2d(9, 0));
        assertNotEquals(new Vector2d(10, 2).subtract(new Vector2d(1, -6)), new Vector2d(9, 6));
    }

    @Test
    public void testOpposite() {
        assertEquals(new Vector2d(5, -7).opposite(), new Vector2d(-5, 7));
        assertEquals(new Vector2d(-3, 2).opposite(), new Vector2d(3, -2));
        assertNotEquals(new Vector2d(-2, 1).opposite(), new Vector2d(-2, -1));
        assertNotEquals(new Vector2d(6, 9).opposite(), new Vector2d(3, -9));
    }
}
