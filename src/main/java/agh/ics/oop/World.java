package agh.ics.oop;

import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        Animal bob = new Animal(MapDirection.NORTH,new Vector2d(2,2));
        ArrayList<MoveDirection> setOfDirections= new ArrayList<MoveDirection>();
        System.out.println("start");
        OptionsParser.parse(args,setOfDirections);
        for (MoveDirection i: setOfDirections){
            bob.move(i);
            System.out.println(bob);
        }
        System.out.println("stop");
    }
}