package agh.ics.oop;

import java.util.*;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    private final IWorldMap map;
    private List<IPositionChangeObserver> observers;

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.observers = new LinkedList<>();
    }

    public void setDirection(MapDirection direction) {
        this.direction = direction;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }


    public String toString() {
        switch (this.direction) {
            case NORTH -> {
                return "N";
            }
            case SOUTH -> {
                return "S";
            }
            case EAST -> {
                return "E";
            }
            case WEST -> {
                return "W";
            }
        }
        return "Error";
    }

    public void move(MoveDirection direction) {
        int x1 = this.map.getxMin();
        int y1 = this.map.getyMin();
        int x2 = this.map.getxMax();
        int y2 = this.map.getyMax();
        Vector2d oldPos = this.position;
        switch (direction) {
            case RIGHT -> this.setDirection(this.direction.next());
            case LEFT -> this.setDirection(this.direction.previous());
            case FORWARD -> {
                Vector2d other = getPosition().add(Objects.requireNonNull(this.getDirection().toUnitVector()));
                if (map.canMoveTo(other)) {
                    if (other.getX() < x1) {
                        System.out.println("a");
                        this.setPosition(this.position.add(new Vector2d(x2, 0)));
                    } else if (other.getY() < y1) {
                        System.out.println("b");
                        this.setPosition(this.position.add(new Vector2d(0, y2)));
                    } else if (other.getX() > x2) {
                        System.out.println("c");
                        this.setPosition(this.position.subtract(new Vector2d(x2, 0)));
                    } else if (other.getY() > y2) {
                        System.out.println("d");
                        this.setPosition(this.position.subtract(new Vector2d(0, y2)));
                    } else {
                        System.out.println("e");
                        this.setPosition(this.position.add(Objects.requireNonNull(getDirection().toUnitVector())));
                    }
                }
                positionChanged(oldPos, this.position);
            }
            case BACKWARD -> {
                Vector2d other = getPosition().subtract(Objects.requireNonNull(this.getDirection().toUnitVector()));
                if (map.canMoveTo(other)) {
                    if (other.getX() < x1) {
                        this.setPosition(this.position.add(new Vector2d(x2, 0)));
                    } else if (other.getY() < y1) {
                        this.setPosition(this.position.add(new Vector2d(0, y2)));
                    } else if (other.getX() > x2) {
                        this.setPosition(this.position.subtract(new Vector2d(x2, 0)));
                    } else if (other.getY() > y2) {
                        this.setPosition(this.position.subtract(new Vector2d(0, y2)));
                    } else {
                        this.setPosition(this.position.subtract(Objects.requireNonNull(getDirection().toUnitVector())));
                    }
                }
                positionChanged(oldPos, this.position);
            }
        }
    }

    void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver obs : this.observers) obs.positionChanged(oldPosition, newPosition);
    }
}