package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map = new RectangularMap(4,4);

    public IWorldMap getMap() {
        return map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public Animal(MapDirection direction, Vector2d initialPosition) {
        this.direction = direction;
        this.position = initialPosition;
    }

    public boolean equals(Animal other) {
        return this.position == other.position & this.direction == other.direction;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public void setDirection(MapDirection direction) {
        this.direction = direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        switch (this.direction){
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

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }


    public void move(MoveDirection direction) {
        int x1 = 0;
        int y1 = 0;
        int x2 = this.map.getWidth();
        int y2 = this.map.getHeight();
        switch (direction) {
            case RIGHT -> this.setDirection(this.direction.next());
            case LEFT -> this.setDirection(this.direction.previous());
            case FORWARD -> {
                Vector2d other = getPosition().add(Objects.requireNonNull(this.getDirection().toUnitVector()));
                if(map.canMoveTo(other)) {
                    if (other.getX() < x1) {
                        this.setPosition(this.position.add(new Vector2d(x2, 0)));
                    } else if (other.getY() < y1) {
                        this.setPosition(this.position.add(new Vector2d(0, y2)));
                    } else if (other.getX() > x2) {
                        this.setPosition(this.position.subtract(new Vector2d(x2, 0)));
                    } else if (other.getY() > y2) {
                        this.setPosition(this.position.subtract(new Vector2d(0, y2)));
                    } else {
                        this.setPosition(this.position.add(Objects.requireNonNull(getDirection().toUnitVector())));
                    }
                }
            }
            case BACKWARD -> {
                Vector2d other = getPosition().subtract(Objects.requireNonNull(this.getDirection().toUnitVector()));
                if (map.canMoveTo(other)){
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
            }
        }
    }

}
