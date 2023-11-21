package at.ItKolleg.Imst.Observer;
import com.rometools.rome.feed.atom.Content;
import com.rometools.rome.feed.atom.Entry;
import com.rometools.rome.feed.atom.Feed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.WireFeedOutput;
import java.util.Date;

public class AtomFeedObserver implements Observer{

    private Feed feed;

    public AtomFeedObserver() {
        this.feed = new Feed();
        this.feed.setFeedType("atom_1.0");
        this.feed.setTitle("Währungsrechnungen");

    }

    @Override
    public void update(String message) {
        Entry entry = new Entry();
        entry.setTitle("Aktualisierung der Währungsrechner");
        entry.setUpdated(new Date());

        Content summary = new Content();
        summary.setValue(message);
        entry.setSummary(summary);

        this.feed.getEntries().add(entry);
        outputFeed();
    }

    private void outputFeed(){
        WireFeedOutput output = new WireFeedOutput();
        try {
            String atomXml = output.outputString(feed);
            System.out.println(atomXml);
        } catch (FeedException e) {
            e.printStackTrace();
        }
    }
}
