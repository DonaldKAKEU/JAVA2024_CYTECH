package Items;

public class ArmeDefensive extends Arme{

    /**
     * niveau de degradation d'une arme, à 0 l'items disparâit de l'inventaire du gamer
     */
    private int degradation;

    public ArmeDefensive(int coef, String libelle) {
        super(coef, libelle);
        this.degradation = 10;
    }

    public int getDegradation() {
        return degradation;
    }

    public void setDegradation(int degradation) {
        this.degradation = degradation;
    }

}
