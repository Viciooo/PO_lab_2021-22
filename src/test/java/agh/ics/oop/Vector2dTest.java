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
        assertEquals("(3, 5)", new Vector2d(7, -1).toString());
        assertNotEquals("(3, 5)", new Vector2d(3, 5).toString());
    }

    @Test
    public void testPrecedes() {
        assertTrue(new Vector2d(1, 2).precedes(new Vector2d(3, 4)));
        assertTrue(new Vector2d(1, 2).precedes(new Vector2d(3, 5)));
        assertFalse(new Vector2d(1, 5).precedes(new Vector2d(7, 6)));
        assertFalse(new Vector2d(1, 5).precedes(new Vector2d(1, 9)));
    }

    @Test
    public void testFollows() {
        assertTrue(new Vector2d(5, 6).follows(new Vector2d(5, 5)));
        assertTrue(new Vector2d(3, 9).follows(new Vector2d(2, 1)));
        assertFalse(new Vector2d(2, 8).follows(new Vector2d(1, 3)));
        assertFalse(new Vector2d(14342, 4342).follows(new Vector2d(2326, 73232)));
    }

    @Test
    public void testUpperRight() {
        assertEquals(new Vector2d(3, 4).upperRight(new Vector2d(4, 3)), new Vector2d(4, 4));
        assertEquals(new Vector2d(6, 9).upperRight(new Vector2d(3, 5)), new Vector2d(3, 6));
        assertNotEquals(new Vector2d(44, 72).upperRight(new Vector2d(58, 42)), new Vector2d(58, 72));
        assertNotEquals(new Vector2d(88, 50).upperRight(new Vector2d(63, 42)), new Vector2d(88, 50));
    }

    @Test
    public void testLowerLeft() {
        assertEquals(new Vector2d(3, 4).lowerLeft(new Vector2d(4, 3)), new Vector2d(3, 3));
        assertEquals(new Vector2d(6, 9).lowerLeft(new Vector2d(3, 5)), new Vector2d(3, 5));
        assertNotEquals(new Vector2d(44, 72).lowerLeft(new Vector2d(58, 42)), new Vector2d(44, 42));
        assertNotEquals(new Vector2d(88, 50).lowerLeft(new Vector2d(63, 42)), new Vector2d(63, 42));
    }

    @Test
    public void testAdd() {
        assertEquals(new Vector2d(3, 4).add(new Vector2d(4, 3)), new Vector2d(3, 3));
        assertEquals(new Vector2d(6, 9).add(new Vector2d(3, 5)), new Vector2d(3, 5));
        assertNotEquals(new Vector2d(4, 2).add(new Vector2d(8, 4)), new Vector2d(12, 6));
        assertNotEquals(new Vector2d(8, 0).add(new Vector2d(3, 4)), new Vector2d(11, 4));
    }

    @Test
    public void testSubtract() {
        assertEquals(new Vector2d(3, 2).subtract(new Vector2d(1, 1)), new Vector2d(2, 1));
        assertEquals(new Vector2d(10, 2).subtract(new Vector2d(1, 2)), new Vector2d(9, 0));
        assertNotEquals(new Vector2d(10, 2).subtract(new Vector2d(1, -6)), new Vector2d(9, 8));
        assertNotEquals(new Vector2d(-1, -2).subtract(new Vector2d(-3, -4)), new Vector2d(2, 2));
    }

    @Test
    public void testOpposite() {
        assertEquals(new Vector2d(5, -7).opposite(), new Vector2d(-5, 7));
        assertEquals(new Vector2d(-3, 2).opposite(), new Vector2d(3, -2));
        assertNotEquals(new Vector2d(-2, 1).opposite(), new Vector2d(-2, -1));
        assertNotEquals(new Vector2d(6, 9).opposite(), new Vector2d(3, -9));
    }
}
