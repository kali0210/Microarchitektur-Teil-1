import java.util.Stack;

/**
 *  Dies ist die Hauptklasse der Anwendung "Die Welt von Zuul".
 *  "Die Welt von Zuul" ist ein sehr einfaches, textbasiertes
 *  Adventure-Game. Ein Spieler kann sich in einer Umgebung bewegen,
 *  mehr nicht. Das Spiel sollte auf jeden Fall ausgebaut werden,
 *  damit es interessanter wird!
 * 
 *  Zum Spielen muss eine Instanz dieser Klasse erzeugt werden und
 *  an ihr die Methode "spielen" aufgerufen werden.
 * 
 *  Diese Instanz erzeugt und initialisiert alle anderen Objekte
 *  der Anwendung: Sie legt alle R�ume und einen Parser an und
 *  startet das Spiel. Sie wertet auch die Befehle aus, die der
 *  Parser liefert, und sorgt f�r ihre Ausf�hrung.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 2016.02.29
 */

public class Spiel {
    private Parser parser;
    private Spieler spieler;
    private Raum aktuellerRaum;

    private Stack<Raum> vorherigeRaum;

    /**
     * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
     */
    public Spiel() {
        spieler = new Spieler("Naruto");
        raeumeAnlegen();
        parser = new Parser();
        vorherigeRaum = new Stack<>();
    }

    /**
     * Erzeuge alle R�ume und verbinde ihre Ausg�nge miteinander.
     */
    private void raeumeAnlegen() {
        Raum draussen, hoersaal, cafeteria, labor, buero;

        // die R�ume erzeugen
        draussen = new Raum("vor dem Haupteingang der Universit�t");
        hoersaal = new Raum("in einem Vorlesungssaal");
        cafeteria = new Raum("in der Cafeteria der Uni");
        labor = new Raum("in einem Rechnerraum");
        buero = new Raum("im Verwaltungsb�ro der Informatik");

        // die Ausg�nge initialisieren
        draussen.setzeAusgang("east", hoersaal);
        draussen.setzeAusgang("south", labor);
        draussen.setzeAusgang("west", cafeteria);

        hoersaal.setzeAusgang("west", draussen);
        cafeteria.setzeAusgang("east", draussen);
        labor.setzeAusgang("east", buero);
        labor.setzeAusgang("south", buero);
        buero.setzeAusgang("west", labor);

        aktuellerRaum = draussen;  // das Spiel startet draussen
    }

    private void Zimmerbetreten(Raum naechsteRaum){

        rauminfoAusgeben();
        aktuellerRaum = naechsteRaum;
        System.out.println(aktuellerRaum.gibLangeBeschreibung());

    }

    private void zurueckGehen(Befehl befehl){
        if (befehl.hatZweitesWort()){
            System.out.println("Zur�ck Wohin?");
            return;
        }
        if (vorherigeRaum.isEmpty()){
            System.out.println("Du kannst nicht mehr zur�ckgehen");
        }else {
           Raum vRaum = vorherigeRaum.pop();
           Zimmerbetreten(vRaum);
        }
    }

    /**
     * Die Hauptmethode zum Spielen. L�uft bis zum Ende des Spiels
     * in einer Schleife.
     */
    public void spielen() {
        willkommenstextAusgeben();

        // Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
        // und f�hren sie aus, bis das Spiel beendet wird.

        boolean beendet = false;
        while (!beendet) {
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);
        }
        System.out.println("Danke f�r dieses Spiel. Auf Wiedersehen.");
    }

    /**
     * Einen Begr��ungstext f�r den Spieler ausgeben.
     */
    private void willkommenstextAusgeben() {
        System.out.println();
        System.out.println("Willkommen zu Zuul!");
        System.out.println("Zuul ist ein neues, unglaublich langweiliges Spiel.");
        System.out.println("Tippen Sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        System.out.println(aktuellerRaum.gibLangeBeschreibung());
    }

    private void rauminfoAusgeben() {

        System.out.println("Sie sind " + aktuellerRaum.gibBeschreibung());
        System.out.print(aktuellerRaum.gibAusgaengealsString());
        System.out.println();
    }

    /**
     * Verarbeite einen gegebenen Befehl (f�hre ihn aus).
     *
     * @param befehl der zu verarbeitende Befehl.
     * @return true wenn der Befehl das Spiel beendet, false sonst
     */
    private boolean verarbeiteBefehl(Befehl befehl) {
        boolean moechteBeenden = false;

        if (befehl.istUnbekannt()) {
            System.out.println("Ich weiss nicht, was Sie meinen ...");
            return false;
        }
        String befehlswort = befehl.gibBefehlswort();
        if (befehlswort.equals("help")) {
            hilfstextAusgeben();
        } else if (befehlswort.equals("go")) {
            wechsleRaum(befehl);
        } else if (befehlswort.equals("look")) {
            umsehen();
        } else if (befehlswort.equals("eat")) {
            eat();
        } else if (befehlswort.equals("quit")) {
            moechteBeenden = beenden(befehl);
        } else if (befehlswort.equals("back")){
            zurueckGehen(befehl);
        }
        return moechteBeenden;
    }

    // Implementierung der Benutzerbefehle:

    /**
     * Gib Hilfsinformationen aus.
     * Hier geben wir eine etwas alberne und unklare Beschreibung
     * aus, sowie eine Liste der Befehlsw�rter.
     */
    private void hilfstextAusgeben() {
        System.out.println("Sie haben sich verlaufen. Sie sind allein.");
        System.out.println("Sie irren auf dem Unigel�nde herum.");
        System.out.println();
        System.out.println("Ihnen stehen folgende Befehle zur Verf�gung:");
        System.out.println(parser.gibBefehlsliste());
    }

    /**
     * Versuche, in eine Richtung zu gehen. Wenn es einen Ausgang gibt,
     * wechsele in den neuen Raum, ansonsten gib eine Fehlermeldung
     * aus.
     */
    private void wechsleRaum(Befehl befehl) {
        if (!befehl.hatZweitesWort()) {
            // Gibt es kein zweites Wort, wissen wir nicht, wohin...
            System.out.println("Wohin m�chten Sie gehen?");
            return;
        }

        String richtung = befehl.gibZweitesWort();

        // Wir versuchen, den Raum zu verlassen.

        Raum naechsterRaum = spieler.getCurrentRoom().gibAusgang(richtung);

        if (naechsterRaum == null) {
            System.out.println("Dort ist keine T�r!");
        } else {
            aktuellerRaum = naechsterRaum;
            System.out.println(aktuellerRaum.gibLangeBeschreibung());

        }
    }

        /**
         * "quit" wurde eingegeben. �berpr�fe den Rest des Befehls,
         * ob das Spiel wirklich beendet werden soll.
         * @return true, wenn der Befehl das Spiel beendet, false sonst
         */
        private boolean beenden(Befehl befehl){

            if(befehl.hatZweitesWort()) {
                System.out.println("Was soll beendet werden?");
                return false;
            }
            else {
                return true;  // Das Spiel soll beendet werden.
            }
    }
    public void umsehen(){
        System.out.println(aktuellerRaum.gibLangeBeschreibung());
    }

    public void eat(){
        System.out.println("Sie haben jetzt gegessen und sind nicht mehr hungrig");
    }
}
