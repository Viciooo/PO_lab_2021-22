package agh.ics.oop;

import java.util.*;
public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
        this.xMin = 0;
        this.yMin = 0;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.isOccupied(position));
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
