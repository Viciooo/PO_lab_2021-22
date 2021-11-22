package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private final ArrayList<MoveDirection> moves;
    private final IWorldMap mapInstance;
    private final Vector2d[] animalsPos;

    public SimulationEngine(ArrayList<MoveDirection>  moves, IWorldMap mapInstance, Vector2d[] initialPos) {
        this.moves = moves;
        this.mapInstance = mapInstance;
        this.animalsPos = initialPos;
        for (Vector2d v : this.animalsPos) this.mapInstance.place(new Animal(this.mapInstance, v));
    }

    @Override
    public Vector2d[] getAnimalsPos() {
        return this.animalsPos;
    }

    @Override
    public void run() {
        int movesNo = this.moves.size();
        int animalsNo = this.animalsPos.length;
        for (int i = 0; i < movesNo; i++) {
            if (this.mapInstance.objectAt(this.animalsPos[i % animalsNo]) instanceof Animal) {
                Animal animal = (Animal) (this.mapInstance.objectAt(this.animalsPos[i % animalsNo]));
                animal.move(this.moves.get(i));
                this.animalsPos[i % animalsNo] = animal.getPosition();
            }

        }
    }
}
