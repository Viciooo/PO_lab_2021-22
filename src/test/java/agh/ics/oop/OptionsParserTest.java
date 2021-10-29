package agh.ics.oop;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    public static void testParse(){
        Animal bob = new Animal(MapDirection.NORTH,new Vector2d(2,2));
        ArrayList<MoveDirection> setOfDirections= new ArrayList<>();
        String[] args = {"f","b","l","r","forward","backward","left","right","a","c","test","f"};
        OptionsParser.parse(args,setOfDirections);
        bob.move(setOfDirections.get(0));
        assertEquals(bob.getPosition(),new Vector2d(2,3));
        bob.move(setOfDirections.get(1));
        assertEquals(bob.getPosition(),new Vector2d(2,2));
        bob.move(setOfDirections.get(2));
        assertEquals(bob.getDirection(),MapDirection.WEST);
        bob.move(setOfDirections.get(3));
        assertEquals(bob.getDirection(),MapDirection.NORTH);
        bob.move(setOfDirections.get(4));
        assertEquals(bob.getPosition(),new Vector2d(2,3));
        bob.move(setOfDirections.get(5));
        assertEquals(bob.getPosition(),new Vector2d(2,2));
        bob.move(setOfDirections.get(6));
        assertEquals(bob.getDirection(),MapDirection.WEST);
        bob.move(setOfDirections.get(7));
        assertEquals(bob.getDirection(),MapDirection.NORTH);
        bob.move(setOfDirections.get(8));
        assertEquals(bob.getPosition(),new Vector2d(2,3));
    }
}