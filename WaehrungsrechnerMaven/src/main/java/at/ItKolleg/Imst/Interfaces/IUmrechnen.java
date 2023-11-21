package at.ItKolleg.Imst.Interfaces;
import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;

public interface IUmrechnen {
    double umrechnen(String variante, double betrag) throws InvalidVarianteException;
    double getFaktor();

    boolean zustaendig(String variante);
}
