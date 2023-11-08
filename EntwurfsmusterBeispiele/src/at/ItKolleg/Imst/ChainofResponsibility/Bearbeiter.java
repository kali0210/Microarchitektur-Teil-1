package at.ItKolleg.Imst.ChainofResponsibility;

/**
 * Das Bearbeiter-Interface definiert in einer Chain of Responsibility.
 * Jedes Objekt, das dieses Interface implementiert, ist ein Bearbeiter, der Anfragen verarbeiten oder
 * an den nächsten Bearbeiter in der Kette weiterleiten kann.
 */
public interface Bearbeiter {

    /**
     * Setzt den Nachfolger für diesen Bearbeiter.
     * @param nachfolger Der nächste Bearbeiter in der Kette.
     */
    void setNachfolger(Bearbeiter nachfolger);

    /**
     * Bearbeitet die übergebene Anfrage oder leitet sie an den Nachfolger weiter, falls dieser vorhanden ist
     * und der aktuelle Bearbeiter die Anfrage nicht bearbeitet.
     *
     * @param anfrage Die zu bearbeitende Anfrage.
     */
    void anfrageBearbeiten(String anfrage);
}

