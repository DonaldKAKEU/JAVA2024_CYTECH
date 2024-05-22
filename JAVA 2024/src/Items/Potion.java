package Items;

public class Potion  extends Items{

    /**
     * quantite de potion present dans la goude en Litre
     * rajoute des point de vie a l'utilisateur
    */
    private int quantite;

    public Potion() {
        super();
        this.quantite = 10;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
