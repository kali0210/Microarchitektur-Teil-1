package at.ItKolleg.Imst;
import at.ItKolleg.Imst.Decorator.FixeGebuehrDecorator;
import at.ItKolleg.Imst.Decorator.ProzentuelleGebDecorator;
import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;
import at.ItKolleg.Imst.Interfaces.IUmrechnen;
import at.ItKolleg.Imst.Observer.AtomFeedObserver;
import at.ItKolleg.Imst.Observer.LogObserver;
import at.ItKolleg.Imst.adapter.UmrechnungsAdapter;
import at.ItKolleg.Imst.chainofresponsibility.EURO2DOLLAR;
import at.ItKolleg.Imst.chainofresponsibility.EURO2YEN;
import at.ItKolleg.Imst.wr.WR;

public class Main {
    public static void main(String[] args) {

        WR yen = new EURO2YEN();

        WR dollar = new EURO2DOLLAR.Builder().mitFaktor(1.2)
                .mitNaechsteKettenMitglied(yen).
                build();

        try {
            System.out.println(dollar.umrechnen("EURO2DOLLAR", 100));
            System.out.println(yen.umrechnen("EUR2YEN", 50));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        WR euro2dollarRechner = new EURO2DOLLAR.Builder()
                .mitFaktor(1.2)
                .mitNaechsteKettenMitglied(yen)
                .build();


        WR euro2dollarProzent = new ProzentuelleGebDecorator(euro2dollarRechner, 0.5);
        WR euro2dollarFixGeb = new FixeGebuehrDecorator(euro2dollarRechner);

        try {
            System.out.println("100€ in Dollar mit Prozentbeühren" + euro2dollarProzent.umrechnen("EURO2DOLLAR", 100));
            System.out.println("100€ in Dollar mit Fixegebühren" + euro2dollarFixGeb.umrechnen("EURO2DOLLAR", 100));
        } catch (InvalidVarianteException e) {
            throw new RuntimeException(e);
        }

        //Adapter
        IUmrechnen euro2dollar = new EURO2DOLLAR.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(yen).build();
        UmrechnungsAdapter umrechnungsAdapter = new UmrechnungsAdapter(euro2dollar);

        double[] betraege = {150.50, 120.30, 90.10};
        try {
            System.out.println(umrechnungsAdapter.sammelumrechnen(betraege, "EURO2DOLLAR"));
        }catch (InvalidVarianteException e){
            throw new RuntimeException(e);
        }

        IUmrechnen dollar2 = new EURO2DOLLAR.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(yen).build();

        AtomFeedObserver afo = new AtomFeedObserver();
        LogObserver log = new LogObserver();

        if (dollar2 instanceof WR){
            ((WR)dollar2).addObserver(log);
            ((WR)dollar2).addObserver(afo);
        }

        try {
            dollar2.umrechnen("EURO2DOLLAR", 100);
        } catch (InvalidVarianteException e){
            e.printStackTrace();
        }
    }
}
