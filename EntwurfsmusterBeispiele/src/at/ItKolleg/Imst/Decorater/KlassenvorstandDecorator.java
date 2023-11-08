package at.ItKolleg.Imst.Decorater;

/**
 * Der KlassenvorstandDecorator erweitert ein ISchulpersonal-Objekt um die Rolle eines Klassenvorstands.
 */
public class KlassenvorstandDecorator extends RolleDecorator {

    /**
     * Konstruiert einen KlassenvorstandDecorator
     *
     * @param schulpersonal Das zu dekorierende ISchulpersonal-Objekt.
     */
    public KlassenvorstandDecorator(ISchulpersonal schulpersonal) {
        super(schulpersonal);
    }

    /**
     * Gibt die erweiterte Rolle des Schulpersonals zurück, einschließlich der Rolle als Klassenvorstand.
     * @return Die Rolle des Schulpersonals, ergänzt um ", Klassenvorstand".
     */
    @Override
    public String getRolle() {
        return super.getRolle() + ", Klassenvorstand";
    }
}
