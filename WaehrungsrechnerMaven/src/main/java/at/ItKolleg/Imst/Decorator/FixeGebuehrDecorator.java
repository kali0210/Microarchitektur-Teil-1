package at.ItKolleg.Imst.Decorator;

import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;
import at.ItKolleg.Imst.wr.WR;

public class FixeGebuehrDecorator extends WRDecorater {

    private final double fixeGebuehr;

    public FixeGebuehrDecorator(WR decoratedWR) {
        super(decoratedWR);
        this.fixeGebuehr = 5;
    }

    @Override
    public double umrechnen(String variante, double betrag) throws InvalidVarianteException {
        double result = super.umrechnen(variante, betrag);
        if (variante.startsWith("EURO2")){
            return result - fixeGebuehr;
        }
        return result;
    }
}
