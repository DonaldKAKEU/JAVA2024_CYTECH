package TestTp10;
import javafx.stage.Application;
import java.awt.*;

public class Pair <X, Y> implements Cloneable, Comparable<Pair<X,Y>> {
    private X x;
    private Y y;

    public X getX(){
        return this.x;
    }
    public Y getY(){
        return this.y;
    }
    public void setX(X g){
        this.x = g;
    }
    public void setY(Y g){
        this.y = g;
    }


    public Pair(X x, Y y){
        this.x = x;
        this.y = y;
    }
     @Override
    public String toString(){
        return "Paire ( " + this.getX() + " ; " + this.getY() + " )\n";
     }

     @Override
    public boolean equals(Object o) {

         if (o instanceof Pair<?, ?>) {
             Pair<?, ?> g = (Pair<?, ?>) o;
             if (this.getX().equals(g.getX()) && this.getY().equals(g.getY()))
                 return true;
         }
         return false;
     }
        public Object clone(){
            Pair<X, Y> x = new Pair<>(this.getX(), this.getY());
            return x;
         }

        public static <Z extends Comparable<Z>> Z plusGrand(Pair<Z, Z> p){

            if(p.getX().compareTo(p.getY()) > 0)
                return  p.getX();
            return  p.getY();
     }

    @Override
    public int compareTo(Pair<X, Y> o) {
        return 0;
    }
}
