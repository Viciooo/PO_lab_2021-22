package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private MoveDirection[] listOfDirections;
    private IWorldMap map;
    private Vector2d[] positionOfAnimal;

    @Override
    public Vector2d[] getPositionOfAnimal() {
        return positionOfAnimal;
    }

    public SimulationEngine(ArrayList<MoveDirection> listOfDirections, IWorldMap mapInstance, Vector2d[] positionOfAnimal) {
        this.listOfDirections = listOfDirections.toArray(new MoveDirection[0]);
        this.map = mapInstance;
        this.positionOfAnimal = positionOfAnimal;
        for (Vector2d v : this.positionOfAnimal) this.map.place(new Animal(this.map, v));
    }

    @Override
    public void run() {
        int m = this.positionOfAnimal.length;
        int n = this.listOfDirections.length;
        for (int i = 0; i < n; i++) {
            Animal bob = (Animal) (this.map.objectAt(this.positionOfAnimal[i % m]));
            if (bob != null) {
                bob.move(this.listOfDirections[i]);
                this.positionOfAnimal[i % m] = bob.getPosition();
                System.out.println(bob.getPosition());
                System.out.println("----------------");
            }
        }
    }
}