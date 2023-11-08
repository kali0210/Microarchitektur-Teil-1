package at.ItKolleg.Imst.Interfaces;

import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;

public interface ISammelumrechnung {

    public double sammelumrechnen(double[] betraege, String variante) throws InvalidVarianteException;
}
