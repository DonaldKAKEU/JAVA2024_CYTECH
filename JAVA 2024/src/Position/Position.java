package Position;

import java.util.Objects;

public  abstract class Position {

    private double x;

    private double y;

    //constructeurs
    public Position(){
        this.x = 0;
        this.y = 0;
    }

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    //getters et setters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {

        if( o instanceof Position) {
            Position position = (Position) o;
            return position.getX() == this.getX() && position.getY() == this.getY();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
