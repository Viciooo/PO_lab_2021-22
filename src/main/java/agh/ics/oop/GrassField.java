package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap {
    private List<Grass> fields;


    public GrassField(int n) {
//        this.animals = new ArrayList<>();
        this.fields = new ArrayList<>();
        int maxLen = (int) Math.sqrt(n * 10);
        while (this.fields.size() < n) {
            int x = ThreadLocalRandom.current().nextInt(0, maxLen);
            int y = ThreadLocalRandom.current().nextInt(0, maxLen);
            Vector2d pos = new Vector2d(x, y);
            boolean duplicate = false;
            for (Grass g : this.fields) {
                if (g.getPosition().equals(pos)) {
                    duplicate = true;
                    break;
                }
            }
            if (!(duplicate)) this.fields.add(new Grass(new Vector2d(x, y)));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) || objectAt(position) instanceof Grass;
    }

    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) return true;
        for (Grass g : this.fields) {
            if (g.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object animalCheck = super.objectAt(position);
        if (animalCheck != null) return animalCheck;
        for (Grass g : this.fields) {
            if (g.getPosition().equals(position)) return g;
        }
        return null;
    }

    public Vector2d getLowerLeft() {
        for (Grass g : this.fields) {
            this.xMin = Math.min(xMin, g.getPosition().getX());
            this.yMin = Math.min(yMin, g.getPosition().getY());
        }

        for (Vector2d v : this.animals.keySet()) {
            this.xMin = Math.min(xMin, this.animals.get(v).getPosition().getX());
            this.yMin = Math.min(yMin, this.animals.get(v).getPosition().getY());
        }
        return new Vector2d(this.xMin, this.yMin);
    }

    public Vector2d getUpperRight() {
        for (Grass g : this.fields) {
            this.xMax = Math.max(xMax, g.getPosition().getX());
            this.yMax = Math.max(yMax, g.getPosition().getY());
        }
        for (Vector2d v : this.animals.keySet()) {
            this.xMax = Math.max(xMax, this.animals.get(v).getPosition().getX());
            this.yMax = Math.max(yMax, this.animals.get(v).getPosition().getY());
        }
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

