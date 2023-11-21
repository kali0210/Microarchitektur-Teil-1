package at.ItKolleg.Imst;
import at.ItKolleg.Imst.Decorator.FixeGebuehrDecorator;
import at.ItKolleg.Imst.Decorator.ProzentuelleGebDecorator;
import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;
import at.ItKolleg.Imst.Interfaces.IUmrechnen;
import at.ItKolleg.Imst.Observer.AtomFeedObserver;
import at.ItKolleg.Imst.Observer.LogObserver;
import at.ItKolleg.Imst.Observer.Observer;
import at.ItKolleg.Imst.adapter.UmrechnungsAdapter;
import at.ItKolleg.Imst.chainofresponsibility.EURO2DOLLAR;
import at.ItKolleg.Imst.chainofresponsibility.EURO2LIRA;
import at.ItKolleg.Imst.chainofresponsibility.EURO2YEN;
import at.ItKolleg.Imst.wr.WR;

public class Main {
    public static void main(String[] args) {

        // Chain of Responsibility
        WR yen = new EURO2YEN();
        WR lira = new EURO2LIRA();
        WR eur2dollar = new EURO2DOLLAR.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(yen).build();
        eur2dollar.addChain(lira);

        // Decorator
        WR eurProzent = new ProzentuelleGebDecorator(eur2dollar, 0.10);
        WR fixGeb = new FixeGebuehrDecorator(eur2dollar);

        // Builder
        IUmrechnen eur2usdnew = new EURO2DOLLAR.Builder().mitNaechsteKettenMitglied(yen).build();

        //Adapter für IUmrechnen und ISammelumrechnung
        IUmrechnen eur2dollar3 = new EURO2DOLLAR.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(yen).build();
        UmrechnungsAdapter umrechnungsAdapter = new UmrechnungsAdapter(eur2dollar3);
        double [] betraege = {10.50, 20.90, 80.99};

        //Observer
        Observer atom = new AtomFeedObserver();
        Observer log = new LogObserver();

        // Casting: Das wird die Methode verwenden können
        // Prueft ob eur2dollar3 in WR-Klasse gibt
        if (eur2dollar3 instanceof WR)
        {
            ((WR)eur2dollar3).addObserver(log);
            ((WR)eur2dollar3).addObserver(atom);
        }

        //Testung
        try {
            System.out.println(eur2dollar.umrechnen("EUR2YEN", 10));
            System.out.println(eur2dollar.umrechnen("EURO2DOLLAR", 10));

            System.out.println(fixGeb.umrechnen("EUR2YEN", 10));
            System.out.println(eurProzent.umrechnen("EURO2DOLLAR", 10));

            System.out.println(eur2usdnew.umrechnen("EURO2DOLLAR", 10));
            System.out.println(umrechnungsAdapter.sammelumrechnen(betraege, "EURO2DOLLAR"));
        } catch (InvalidVarianteException e) {
            throw new RuntimeException(e);
        }
    }
}
