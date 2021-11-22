package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals;
    protected abstract Vector2d getLowerLeft();
    protected abstract Vector2d getUpperRight();
    protected int xMin;
    protected int yMin;
    protected int xMax;
    protected int yMax;

    public AbstractWorldMap() {

        this.animals = new ArrayList<>();
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

    public String toString() {
        MapVisualizer animalsMap = new MapVisualizer(this);

        return animalsMap.draw(getLowerLeft(), getUpperRight());
    }
}