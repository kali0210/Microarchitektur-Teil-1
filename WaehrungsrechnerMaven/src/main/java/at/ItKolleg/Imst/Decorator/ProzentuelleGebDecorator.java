package at.ItKolleg.Imst.Decorator;

import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;
import at.ItKolleg.Imst.wr.WR;

public class ProzentuelleGebDecorator extends WRDecorater{

    private final double prozentGebuehr;


    public ProzentuelleGebDecorator(WR decoratedWR, double prozentGebuehr) {
        super(decoratedWR);
        this.prozentGebuehr = prozentGebuehr;
    }

        @Override
        public double umrechnen(String variante, double betrag) throws InvalidVarianteException {
            double result = super.umrechnen(variante, betrag);
            return result - (result * prozentGebuehr / 100.0);
        }
}
