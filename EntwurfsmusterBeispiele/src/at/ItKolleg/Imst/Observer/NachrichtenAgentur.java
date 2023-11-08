package at.ItKolleg.Imst.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Die NachrichtenAgentur Klasse implementiert das Subject Interface
 */
public class NachrichtenAgentur implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String news;

    /**
     * Setzt die neuesten Nachrichten
     * @param news Die neuen Nachrichten
     */
    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    /**
     * Fügt einen Observer zur Beobachterliste hinzu
     * @param o Der Observer der zur Liste hinzugefügt werden
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Entfernt einen Observer aus der Liste
     * @param o Der Observer der aus der Liste entfernt werden soll.
     */
    @Override
    public void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Benachrichtigt alle Observer über die aktuellen Nachrichten.
     */
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(news);
        }
    }
}
