package agh.ics.oop;

public class World {
    public static void run(Direction[] arr) {
        for (Direction i : arr) {
            switch (i) {
                case FORWARD:
                    System.out.println("Do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Do tyłu");
                    break;
                case RIGHT:
                    System.out.println("W prawo");
                    break;
                case LEFT:
                    System.out.println("W lewo");
                    break;
                default:
                    break;

            }
        }
    }

    public static void main(String[] args) {
        System.out.println("System wystartował");
        Direction[] arr = new Direction[args.length];
        for (int i=0;i < args.length;i++) {
            switch (args[i]) {
                case "f":
                    arr[i] = Direction.FORWARD;
                    break;
                case "b":
                    arr[i] = Direction.BACKWARD;
                    break;
                case "r":
                    arr[i] = Direction.RIGHT;
                    break;
                case "l":
                    arr[i] = Direction.LEFT;
                    break;
                default:
                    arr[i] = Direction.NONE;

            }
        }
        run(arr);
        System.out.println("System zakończył działanie");
    }
}

