package at.ItKolleg.Imst.Decorator;

import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;
import at.ItKolleg.Imst.wr.WR;

public abstract class WRDecorater extends WR {

    protected WR decoratedWR;

    public WRDecorater(WR decoratedWR) {
        this.decoratedWR = decoratedWR;
    }

    @Override
    public double umrechnen(String variante, double betrag) throws InvalidVarianteException {
        return decoratedWR.umrechnen(variante, betrag);
    }

    @Override
    public double getFaktor() {
        return decoratedWR.getFaktor();
    }

    @Override
    public boolean zustaendig(String variante) {
        return decoratedWR.zustaendig(variante);
    }


}
