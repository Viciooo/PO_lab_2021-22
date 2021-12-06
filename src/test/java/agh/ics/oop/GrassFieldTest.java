package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    IWorldMap map = new GrassField(10);
    Animal Hänsel = new Animal(map, new Vector2d(2, 2));
    Animal Gretel = new Animal(map, new Vector2d(4, 7));
    Animal Hexe = new Animal(map, new Vector2d(3, 1));

    @Test
    void canMoveTo() {
        map.place(Hänsel);
        map.place(Gretel);
        map.place(Hexe);
        assertFalse(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(3, 0)));
        assertFalse(map.canMoveTo(new Vector2d(4, 7)));
        assertFalse(map.canMoveTo(new Vector2d(3, 1)));
    }

    @Test
    void place() {
        Animal Schneewittchen = new Animal(map, new Vector2d(4, 7));
        assertTrue(map.place(Hänsel));
        assertTrue(map.place(Gretel));
        assertTrue(map.place(Hexe));
        assertThrows(IllegalArgumentException.class,() -> map.place(Schneewittchen), "Schneewittchen can not be placed :(");
    }

    @Test
    void isOccupied() {
        map.place(Hänsel);
        map.place(Gretel);
        map.place(Hexe);
        assertTrue(map.isOccupied(Hänsel.getPosition()));
        assertTrue(map.isOccupied(Gretel.getPosition()));
        assertTrue(map.isOccupied(Hexe.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(2, 1)));
        assertFalse(map.isOccupied(new Vector2d(6, 2)));
        assertFalse(map.isOccupied(new Vector2d(3, 0)));
    }

    @Test
    void objectAt() {
        map.place(Hänsel);
        map.place(Gretel);
        map.place(Hexe);
        assertEquals(map.objectAt(Hänsel.getPosition()), Hänsel);
        assertEquals(map.objectAt(Gretel.getPosition()), Gretel);
        assertEquals(map.objectAt(Hexe.getPosition()), Hexe);
    }
}