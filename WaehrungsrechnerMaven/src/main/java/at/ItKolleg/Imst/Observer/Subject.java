package at.ItKolleg.Imst.Observer;

public interface Subject {
    void addObserver(Observer o);
    void messageObserver(String message);
}
