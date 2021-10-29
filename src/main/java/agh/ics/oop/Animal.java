package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Animal(MapDirection direction, Vector2d position) {
        this.direction = direction;
        this.position = position;
    }
//
//    public boolean equals(Animal other) {
//        if(this.position == other.position & this.direction == other.direction)return true;
//        else return false;
//    }

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
        return "direction=" + direction +
                ", position=" + position;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }


    public void move(MoveDirection direction){
        int x1 = 0;
        int y1 = 0;
        int x2 = 4;
        int y2 = 4;
        switch (direction){
            case RIGHT -> this.setDirection(this.direction.next());
            case LEFT -> this.setDirection(this.direction.previous());

            case FORWARD -> {
                Vector2d other = getPosition().add(this.getDirection().toUnitVector());
                if (other.getX() < x1){
                    this.setPosition(this.position.add(new Vector2d(x2,0)));
                }
                else if (other.getY() < y1){
                    this.setPosition(this.position.add(new Vector2d(0, y2)));
                }
                else if (other.getX() > x2){
                    this.setPosition(this.position.subtract(new Vector2d(x2,0)));
                }
                else if (other.getY() > y2){
                    this.setPosition(this.position.subtract(new Vector2d(0, y2)));
                }
                else{
                    this.setPosition(this.position.add(getDirection().toUnitVector()));
                }
            }
            case BACKWARD ->{
                Vector2d other = getPosition().subtract(this.getDirection().toUnitVector());
                if (other.getX() < x1){
                    this.setPosition(this.position.add(new Vector2d(x2,0)));
                }
                else if (other.getY() < y1){
                    this.setPosition(this.position.add(new Vector2d(0, y2)));
                }
                else if (other.getX() > x2){
                    this.setPosition(this.position.subtract(new Vector2d(x2,0)));
                }
                else if (other.getY() > y2){
                    this.setPosition(this.position.subtract(new Vector2d(0, y2)));
                }
                else{
                    this.setPosition(this.position.subtract(getDirection().toUnitVector()));
                }
            }
        }
    }

}
