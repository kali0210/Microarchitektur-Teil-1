package at.ItKolleg.Imst.adapter;

import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;
import at.ItKolleg.Imst.Interfaces.ISammelumrechnung;
import at.ItKolleg.Imst.Interfaces.IUmrechnen;

import java.util.Arrays;

public class UmrechnungsAdapter implements ISammelumrechnung {

    private  final IUmrechnen umrechnenAktion;

    public UmrechnungsAdapter(IUmrechnen umrechnen) {
        this.umrechnenAktion = umrechnen;
    }

    @Override
    public double sammelumrechnen(double[] betraege, String variante) throws InvalidVarianteException {
        double summe = 0;
        for (double betrag:betraege) {
            summe = summe + umrechnenAktion.umrechnen(variante, betrag);
        }
        return summe;
    }
}
