package at.ItKolleg.Imst.Decorater;

/**
 * Ähnlich wie andere Dekorierer  ügt diese Klasse zusätzliche Funktion
 */
public class PruefungsausschussDecorator extends RolleDecorator {

    /**
     * Konstruiert einen PruefungsausschussDecorator
     *
     * @param schulpersonal Das zu dekorierende ISchulpersonal-Objekt.
     */
    public PruefungsausschussDecorator(ISchulpersonal schulpersonal) {
        super(schulpersonal);
    }

    /**
     * Gibt die erweiterte Rolle des Schulpersonals zurück, einschließlich der Rolle als Prüfungsausschussmitglied.
     * @return Die Rolle des Schulpersonals
     */
    @Override
    public String getRolle() {
        return super.getRolle() + ",Prüfungsausschussmitglied";
    }
}

