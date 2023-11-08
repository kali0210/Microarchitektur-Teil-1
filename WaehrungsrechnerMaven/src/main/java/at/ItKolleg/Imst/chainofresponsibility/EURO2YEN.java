package at.ItKolleg.Imst.chainofresponsibility;

import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;
import at.ItKolleg.Imst.wr.WR;

public class EURO2YEN extends WR {
    @Override
    public double getFaktor() {
        return 1.2;
    }

    @Override
    public boolean zustaendig(String variante) {
        if (variante.equals("EUR2YEN")) {
            return true;
        } else {
            return false;
        }
    }

}

