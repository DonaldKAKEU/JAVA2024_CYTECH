package Decor;

import Exceptions.BadCleException;
import Interfaces.Traversable;
import Items.Cle;

import javax.sound.sampled.Port;
import java.util.Objects;

public class Porte extends ElementDecor implements Traversable {

    /**
     * Representé par un rectangle
     */

    private static final String couleur = "Rouge";

    /**
     * Class Cle representé par un code
     */
    private final Cle cle;

    private boolean estOuvert;

    public Porte(Cle cle){
        super();
        this.cle = cle;
        this.estOuvert = false;
    }


    public Cle getCle() {
        return cle;
    }

    public boolean getEstOuvert() {
        return estOuvert;
    }

    public void setEstOuvert(boolean b){
        this.estOuvert = b;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Porte) {
            Porte porte = (Porte) o;
            return this.getCle() == porte.getCle();
        }

        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cle, estOuvert);
    }

    @Override
    public void ouvrir(Cle cle) throws BadCleException{
        if(cle != this.getCle()) {
            throw new BadCleException("BAD Cle^^^^^^^^^^");
        }
        this.setEstOuvert(true);
    }

    @Override
    public void fermer() {
        this.setEstOuvert(false);
    }
}
