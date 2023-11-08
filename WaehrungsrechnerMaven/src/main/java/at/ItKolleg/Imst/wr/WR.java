package at.ItKolleg.Imst.wr;
import at.ItKolleg.Imst.Interfaces.IUmrechnen;
import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;
import at.ItKolleg.Imst.Observer.Observer;
import at.ItKolleg.Imst.Observer.Subject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class WR implements IUmrechnen, Subject {

    private WR next;

    private List<Observer> observers = new ArrayList<>();

    public double umrechnen(String variante, double betrag) throws InvalidVarianteException {
        if (this.zustaendig(variante))
        {
            double ergebnis = betrag * getFaktor();
            String message = createMessage(betrag, variante, ergebnis);
            messageObserver(message);
            return ergebnis;
        }
        else if (next != null)
        {
            return next.umrechnen(variante, betrag);
        }
        throw new InvalidVarianteException();
    }

    public WR getNext() {
        return next;
    }

    public void addChain(WR next) {
        if (this.next == null)
        {
            this.next = next;
        }
        else
        {
            this.next.addChain(next);
        }
    }

    public void removeChain(WR removeChain)
    {
        if (this.next == removeChain) {
            this.next = this.next.next;
        }
        else if (this.next != null)
        {
            this.next.removeChain(removeChain);
        }
    }

    @Override
    public abstract double getFaktor();

    @Override
    public abstract boolean zustaendig(String variante);

    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    @Override
    public void messageObserver(String message){
        for (Observer observer:observers) {
            observer.update(message);
        }
    }

    private String createMessage(double originalMenge, String waehrung, double umrechnungswaehrung){
        String zeitstempel = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return String.format("Umrechnung wurde durchgeführt: %s %.2f € %s zu %.2f $  ",zeitstempel, originalMenge, waehrung, umrechnungswaehrung);
    }

}
