package Model;

/**
 * The CenterAdmin class represents an administrator of a center.
 */
public class CenterAdmin {
    private int ida;
    private String login;
    private String password;
    private Center center;

    /**
     * Constructs a CenterAdmin object with the specified login, password, and center.
     *
     * @param login    the login of the center admin
     * @param password the password of the center admin
     * @param center   the center associated with the admin
     */
    public CenterAdmin(String login, String password, Center center) {
        this.login = login;
        this.password = password;
        this.center = center;
    }

    /**
     * Returns the ID of the center admin.
     *
     * @return the ID of the center admin
     */
    public int getIda() {
        return ida;
    }

    /**
     * Sets the ID of the center admin.
     *
     * @param ida the ID of the center admin
     */
    public void setIda(int ida) {
        this.ida = ida;
    }

    /**
     * Returns the login of the center admin.
     *
     * @return the login of the center admin
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login of the center admin.
     *
     * @param login the login of the center admin
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns the password of the center admin.
     *
     * @return the password of the center admin
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the center admin.
     *
     * @param password the password of the center admin
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the center associated with the admin.
     *
     * @return the center associated with the admin
     */
    public Center getCenter() {
        return center;
    }

    /**
     * Connects the center admin using the entered login and password.
     * Prints "Connexion réussie !" if the login and password match, otherwise prints "Identifiant ou mot de passe incorrect !".
     * This method will be moved to CenterManager.java.
     *
     * @param enteredLogin    the entered login
     * @param enteredPassword the entered password
     */
    public void seConnecter(String enteredLogin, String enteredPassword) {
        if (enteredLogin.equals(login) && enteredPassword.equals(password)) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Identifiant ou mot de passe incorrect !");
        }
    }
}
