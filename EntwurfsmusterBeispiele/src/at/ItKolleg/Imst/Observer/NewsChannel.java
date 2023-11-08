package at.ItKolleg.Imst.Observer;

/**
 * Die Klasse NewsChannel implementiert das Observer Interface
 */
public class NewsChannel implements Observer {
    private String news;

    /**
     * Aktualisiert den Nachrichtenkanal mit der neuesten Nachricht
     * @param news Die Nachricht die vom Subject gesendet wird.
     */
    @Override
    public void update(String news) {
        this.news = news;
        displayNews();
    }

    /**
     * Zeigt die neuesten Nachrichten an
     */
    private void displayNews() {
        System.out.println("Newschannel updated with news: " + news);
    }
}

