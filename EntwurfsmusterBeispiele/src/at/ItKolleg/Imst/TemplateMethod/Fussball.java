package at.ItKolleg.Imst.TemplateMethod;

/**
 * Die Klasse Fussball ist eine konkrete Implementierung der abstrakten Klasse Spiel.
 */
public class Fussball extends Spiel {

    /**
     * Bereitet das Fußballspiel vor.
     */
    @Override
    protected void spielInitialisierung() {
        // Bereitet das Spiel vor.
        System.out.println("Spiel geht los");
    }

    /**
     * Startet das Fußballspiel.
     */
    @Override
    protected void spielstart() {
        // Beginnt das Spiel.
        System.out.println("Das Spiel beginnt");
    }

    /**
     * Beendet das Fußballspiel.
     */
    @Override
    protected void spielende() {
        // Beendet das Spiel.
        System.out.println("Das Spiel ist beendet");
    }
}
