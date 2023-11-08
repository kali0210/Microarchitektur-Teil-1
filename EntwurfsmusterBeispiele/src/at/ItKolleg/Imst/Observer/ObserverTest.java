package at.ItKolleg.Imst.Observer;

public class ObserverTest {
    public static void main(String[] args) {

        // Erstelle ein neues NachrichtenAgentur-Objekt
        NachrichtenAgentur observable = new NachrichtenAgentur();

        // Erstelle ein neues NewsChannel-Objekt
        NewsChannel observer = new NewsChannel();


        observable.registerObserver(observer);

        // Setze eine Nachricht bei der NachrichtenAgentur.
        observable.setNews("Breaking News: Observer in Java");

        // Meldet den Observer von der NachrichtenAgentur ab.
        observable.unregisterObserver(observer);
    }
}
