package at.ItKolleg.Imst.Observer;

/**
 * Das Observer-Interface die von Beobachtern implementiert wird.

 */
public interface Observer {

    /**
     * Wird vom Subject aufgerufen
     * @param message Die Nachricht das vom Subject gesendet wird.
     */
    void update(String message);

}
