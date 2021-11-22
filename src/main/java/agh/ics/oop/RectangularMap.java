package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final List<Animal> animals;
    private final int xMin;
    private final int yMin;
    private final int xMax;
    private final int yMax;

    public RectangularMap(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
        this.xMin = 0;
        this.yMin = 0;
        this.animals = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a : this.animals) {
            if (a.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal a : this.animals) {
            if (a.getPosition().equals(position)) return a;
        }
        return null;
    }

    public Vector2d getLowerLeft() {
        return new Vector2d(xMin, yMin);
    }

    public Vector2d getUpperRight() {
        return new Vector2d(this.xMax, this.yMax);
    }

    @Override
    public int getxMin() {
        return xMin;
    }

    @Override
    public int getyMin() {
        return yMin;
    }

    @Override
    public int getxMax() {
        return xMax;
    }

    @Override
    public int getyMax() {
        return yMax;
    }
}
