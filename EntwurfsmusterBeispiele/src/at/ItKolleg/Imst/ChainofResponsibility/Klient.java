package at.ItKolleg.Imst.ChainofResponsibility;

public class Klient {

    public static void main(String[] args) {

        //Erstellen der Bearbeiter
        Bearbeiter bearbeiter1 = new Bearbeiter1();
        Bearbeiter bearbeiter2 = new Bearbeiter2();

        //Verkettung: Bearbeiter verweist auf Bearbeiter als Nachfolger
        bearbeiter1.setNachfolger(bearbeiter2);

        //Klient startet die Anfrage
        bearbeiter1.anfrageBearbeiten("Bearbeiter1");
        bearbeiter1.anfrageBearbeiten("Bearbeiter2");
        bearbeiter1.anfrageBearbeiten("Unbekannt");

    }
}
