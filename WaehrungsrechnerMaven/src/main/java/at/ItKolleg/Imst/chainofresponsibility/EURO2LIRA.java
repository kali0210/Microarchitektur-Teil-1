package at.ItKolleg.Imst.chainofresponsibility;

import at.ItKolleg.Imst.wr.WR;

public class EURO2LIRA extends WR {

    @Override
    public double getFaktor() {
        return 30.41;
    }

    @Override
    public boolean zustaendig(String variante) {
        if (variante.equals("EURO2LIRA")) {
            return true;
        } else {
            return false;
        }
    }
}
