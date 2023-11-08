package at.ItKolleg.Imst.Decorater;

/**
 * Der RolleDecorator implementiert das Interface, ohne dessen Klasse zu ändern.
 *  Decorator Entwurfsmuster
 */
public class RolleDecorator implements ISchulpersonal {
    // Das zu dekorierende ISchulpersonal-Objekt wird als geschützte Instanzvariable gespeichert.
    protected ISchulpersonal schulpersonal;

    /**
     * Konstruktor für RolleDecorator
     * @param schulpersonal Das zu dekorierende ISchulpersonal-Objekt.
     */
    public RolleDecorator(ISchulpersonal schulpersonal) {
        this.schulpersonal = schulpersonal;
    }

    /**
     * Diese Methode gibt die Rolle des dekorierten Schulpersonals zurück.
     * @return Die Rolle des Schulpersonals als String.
     */
    @Override
    public String getRolle() {
        // Delegation des Aufrufs an das dekorierte ISchulpersonal-Objekt.
        return schulpersonal.getRolle();
    }
}
