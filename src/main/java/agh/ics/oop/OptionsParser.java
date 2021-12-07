package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static ArrayList<MoveDirection> parse(List<String> arr) {
        ArrayList<MoveDirection> setOfDirections = new ArrayList<>();
        for (String i : arr) {
            switch (i) {
                case "f", "forward" -> setOfDirections.add(MoveDirection.FORWARD);
                case "b", "backward" -> setOfDirections.add(MoveDirection.BACKWARD);
                case "l", "left" -> setOfDirections.add(MoveDirection.LEFT);
                case "r", "right" -> setOfDirections.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(i + " is not legal move specification");
            }
        }
        return setOfDirections;
    }
}
