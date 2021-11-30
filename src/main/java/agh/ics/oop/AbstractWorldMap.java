package agh.ics.oop;


import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals;

    protected abstract Vector2d getLowerLeft();

    protected abstract Vector2d getUpperRight();

    protected int xMin;
    protected int yMin;
    protected int xMax;
    protected int yMax;

    public AbstractWorldMap() {
        this.animals = new LinkedHashMap<>();
    }

    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

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
            this.animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (this.animals.containsKey(position)) return this.animals.get(position);
        return null;
    }

    public String toString() {
        MapVisualizer animalsMap = new MapVisualizer(this);

        return animalsMap.draw(getLowerLeft(), getUpperRight());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }
}