package at.ItKolleg.Imst.Decorater;

/**
 * Die Klasse DecoratorTest dient dazu, das Dekorierer zu testen
 */
public class DecoratorTest {

    public static void main(String[] args) {

        // Erzeugung eines Professor-Objekts.
        ISchulpersonal professor = new Professor();
        System.out.println(professor.getRolle());

        // Erweitern des Professors
        professor = new KlassenvorstandDecorator(professor);
        System.out.println(professor.getRolle());

        // Weitere Erweiterung des Professors
        professor = new PruefungsausschussDecorator(professor);
        System.out.println(professor.getRolle());
    }
}
