package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {
    public static void parse(String[] arr, ArrayList<MoveDirection> setOfDirections){
        for (String i: arr){
            switch (i) {
                case "f", "forward" -> setOfDirections.add(MoveDirection.FORWARD);
                case "b", "backward" -> setOfDirections.add(MoveDirection.BACKWARD);
                case "l", "left" -> setOfDirections.add(MoveDirection.LEFT);
                case "r", "right" -> setOfDirections.add(MoveDirection.RIGHT);
            }
        }
    }
}
