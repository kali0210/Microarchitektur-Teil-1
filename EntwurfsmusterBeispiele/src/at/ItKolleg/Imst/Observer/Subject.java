package at.ItKolleg.Imst.Observer;

/**
 * Das Subject-Interface definiert Methoden für das Hinzufügen, Entfernen und Benachrichtigen von Beobachtern.
 * In einem Observer-Muster
 */
public interface Subject {

    /**
     * Registriert einen Beobachter
     * @param o Das Observer-Objekt
     */
    void registerObserver(Observer o);

    /**
     * Entfernt einen Beobachter
     * @param o Das Observer-Objekt
     */
    void unregisterObserver(Observer o);

    /**
     * Benachrichtigt alle Beobachter
     */
    void notifyObservers();

}
