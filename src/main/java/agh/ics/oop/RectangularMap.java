package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width, height;
    private List<Animal> animals;

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalsPos = animal.getPosition();
        if (!(this.isOccupied(animalsPos))) {
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
        Vector2d vector1 = new Vector2d(0, 0);
        Vector2d vector2 = new Vector2d(this.width, this.height);
        return animalsMap.draw(vector1, vector2);
    }
}
