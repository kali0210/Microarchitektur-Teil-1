package at.ItKolleg.Imst.TemplateMethod;

/**
 * Die Klasse TestSpiel enthält die main-Methode, um das Template Method Entwurfsmuster zu testen.
 */

public class TestSpiel {
    public static void main(String[] args) {

        // Erstellt eine Instanz von Basketball
        Spiel basketball = new Basketball();
        basketball.spielen();

        // Erstellt eine Instanz von Fussball
        Spiel fussball = new Fussball();
        fussball.spielen();
    }
}
