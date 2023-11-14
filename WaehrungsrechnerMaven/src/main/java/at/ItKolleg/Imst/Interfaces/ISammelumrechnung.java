package at.ItKolleg.Imst.Interfaces;

import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;

public interface ISammelumrechnung {

     double sammelumrechnen(double[] betraege, String variante) throws InvalidVarianteException;
}
