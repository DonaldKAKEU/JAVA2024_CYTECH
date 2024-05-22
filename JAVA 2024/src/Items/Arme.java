package Items;

public  abstract class Arme extends Items{

    /**
     * entier mutiplication ou demultiplicateur(arme defensive) à la puissance de l'utilisateur pour porter un coup
     */
    private int coef;

    private String libelle;

    public Arme(int coef, String libelle){
        this.coef = coef;
        this.libelle = libelle;
    }

    public int getCoef() {
        return coef;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String Libelle) {
        this.libelle = libelle;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

}
