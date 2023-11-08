package at.ItKolleg.Imst.ChainofResponsibility;

/**
 * Bearbeiter1 ist ein konkreter Bearbeiter in einer Chain of Responsibility.
 * Er versucht, Anfragen zu bearbeiten, die an ihn gerichtet sind, und leitet
 * andere Anfragen an den nächsten Bearbeiter in der Kette weiter.
 */
public class Bearbeiter1 implements Bearbeiter {

    private Bearbeiter nachfolger; // Der Nachfolger in der Chain of Responsibility

    /**
     * Setzt den Nachfolger für diesen Bearbeiter.
     * @param nachfolger Der nächste Bearbeiter in der Kette.
     */
    @Override
    public void setNachfolger(Bearbeiter nachfolger) {
        this.nachfolger = nachfolger;
    }

    /**
     * Bearbeitet die übergebene Anfrage, wenn sie für diesen Bearbeiter bestimmt ist.
     * @param anfrage Die zu bearbeitende Anfrage.
     */
    @Override
    public void anfrageBearbeiten(String anfrage) {
        if ("Bearbeiter1".equals(anfrage)){
            System.out.println("Bearbeiter1 hat die Anfrage bearbeitet.");
        } else if (nachfolger != null) {
            nachfolger.anfrageBearbeiten(anfrage);
        } else {
            System.out.println("Keiner konnte die Anfrage bearbeiten.");
        }
    }
}
